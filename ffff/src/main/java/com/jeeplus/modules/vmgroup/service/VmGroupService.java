/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmgroup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.vmgroup.entity.VmGroup;
import com.jeeplus.modules.vmgroup.dao.VmGroupDao;

/**
 * 售货机分组Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class VmGroupService extends CrudService<VmGroupDao, VmGroup> {

	public VmGroup get(String id) {
		return super.get(id);
	}
	
	public List<VmGroup> findList(VmGroup vmGroup) {
		return super.findList(vmGroup);
	}
	
	public Page<VmGroup> findPage(Page<VmGroup> page, VmGroup vmGroup) {
		return super.findPage(page, vmGroup);
	}
	
	@Transactional(readOnly = false)
	public void save(VmGroup vmGroup) {
		super.save(vmGroup);
	}
	
	@Transactional(readOnly = false)
	public void delete(VmGroup vmGroup) {
		super.delete(vmGroup);
	}
	
	
	
	
}