package com.holo.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.I0Itec.zkclient.IZkChildListener;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;

import com.holo.enums.VmState;
import com.holo.utils.ZkUtils;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.vm.service.VendingMachineService;

/**
 * Listner for vending machine to register 
 *
 */
public class ZkListener {

	@Autowired
	private VendingMachineService vendingMachineService;
	
	private String zkAddress = "127.0.0.1:2181";
	private String vmPath = "/holo/vm";

    /**
     * Default constructor. 
     */
    public ZkListener() {
    }

    
    private List<String> vmNoList = new ArrayList<String>();

    public void onStart()  {
    	if(true) {
    		return;
    	}
    	VendingMachine vendingMachine = new VendingMachine();
    	vendingMachine.setVmState(VmState.ONLINE.getId());
		List<VendingMachine> vmList = vendingMachineService.findList(vendingMachine);
		for(VendingMachine vm : vmList) {
			vmNoList.add(vm.getVmNo());
		}
    	
    	ZkUtils.ensurePathExist(zkAddress, vmPath, CreateMode.PERSISTENT, true);

    	ZkUtils.getZKClient(zkAddress).unsubscribeAll();
    	
		ZkUtils.getZKClient(zkAddress).subscribeChildChanges(vmPath, new IZkChildListener() {

			@Override
			public void handleChildChange(String path, List<String> vms) throws Exception {
				// new added
				List<String> vmsCopy = new ArrayList<String>();
				vmsCopy.addAll(vms);
				vmsCopy.removeAll(vmNoList);
				System.out.println("new vm arrives: " + vmsCopy.toString());				
				if(vendingMachineService != null) {
					for(String vm : vmsCopy) {
						VendingMachine vendingMachine = new VendingMachine();
						vendingMachine.setVmNo(vm);
						vendingMachine.setVmState(VmState.ONLINE.getId());
						vendingMachineService.save(vendingMachine );
					}
				} else {
					System.err.println("vendingMachineService is null");
				}
				
				// vm offline
				List<String> vmNoListCopy = new ArrayList<String>();
				vmNoListCopy.addAll(vmNoList);
				vmNoListCopy.removeAll(vms);
				System.out.println("vm got offline: " + vmNoListCopy.toString());				
				if(vendingMachineService != null) {
					List<VendingMachine> delVms = new ArrayList<VendingMachine>();
					for(String vm : vmNoListCopy) {
						VendingMachine vendingMachine = new VendingMachine();
						vendingMachine.setVmNo(vm);
						delVms.add(vendingMachine);
					}
					if(delVms.size() > 0) {
						vendingMachineService.updateVmsState(delVms, VmState.OFFLINE.getId());
					}
				} else {
					System.err.println("vendingMachineService is null");
				}
				
				vmNoList = vms;
			}
			
		});
		
		
    }
	
}
