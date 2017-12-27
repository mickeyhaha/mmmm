/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmlog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.vmlog.entity.VMLog;
import com.jeeplus.modules.vmlog.dao.VMLogDao;

/**
 * 售货机日志Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class VMLogService extends CrudService<VMLogDao, VMLog> {

	public VMLog get(String id) {
		return super.get(id);
	}
	
	public List<VMLog> findList(VMLog vMLog) {
		return super.findList(vMLog);
	}
	
	public Page<VMLog> findPage(Page<VMLog> page, VMLog vMLog) {
		return super.findPage(page, vMLog);
	}
	
	@Transactional(readOnly = false)
	public void save(VMLog vMLog) {
		super.save(vMLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(VMLog vMLog) {
		super.delete(vMLog);
	}
	
	
	
	
}