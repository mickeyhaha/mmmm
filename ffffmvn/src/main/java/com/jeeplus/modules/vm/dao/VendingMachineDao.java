/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vm.dao;

import com.jeeplus.modules.vmgroup.entity.VmGroup;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.vm.entity.VendingMachine;

/**
 * 售货机管理DAO接口
 * @author Jason Dong
 * @version 2017-12-20
 */
@MyBatisDao
public interface VendingMachineDao extends CrudDao<VendingMachine> {

	public List<VmGroup> findListByvmGroup(VmGroup vmGroup);
	//@Param(value="propertyName")String propertyName, @Param(value="value")Object value
	public void updateStateByVmNos(@Param(value="vms")List<VendingMachine> vms, @Param(value="vmState")int vmState);
	
}