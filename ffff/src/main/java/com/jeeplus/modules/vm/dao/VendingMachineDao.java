/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vm.dao;

import com.jeeplus.modules.vmgroup.entity.VmGroup;
import java.util.List;
import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.vm.entity.VendingMachine;

/**
 * 售货机管理DAO接口
 * @author Jason Dong
 * @version 2017-12-19
 */
@MyBatisDao
public interface VendingMachineDao extends CrudDao<VendingMachine> {

	public List<VmGroup> findListByvmGroup(VmGroup vmGroup);
	
}