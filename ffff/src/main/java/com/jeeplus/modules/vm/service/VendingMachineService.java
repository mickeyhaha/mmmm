/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.modules.vmgroup.entity.VmGroup;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.vm.dao.VendingMachineDao;

/**
 * 售货机管理Service
 * @author Jason Dong
 * @version 2017-12-19
 */
@Service
@Transactional(readOnly = true)
public class VendingMachineService extends CrudService<VendingMachineDao, VendingMachine> {

	public VendingMachine get(String id) {
		return super.get(id);
	}
	
	public List<VendingMachine> findList(VendingMachine vendingMachine) {
		return super.findList(vendingMachine);
	}
	
	public Page<VendingMachine> findPage(Page<VendingMachine> page, VendingMachine vendingMachine) {
		return super.findPage(page, vendingMachine);
	}
	
	@Transactional(readOnly = false)
	public void save(VendingMachine vendingMachine) {
		super.save(vendingMachine);
	}
	
	@Transactional(readOnly = false)
	public void delete(VendingMachine vendingMachine) {
		super.delete(vendingMachine);
	}
	
	public Page<VmGroup> findPageByvmGroup(Page<VmGroup> page, VmGroup vmGroup) {
		vmGroup.setPage(page);
		page.setList(dao.findListByvmGroup(vmGroup));
		return page;
	}
	
	
	
}