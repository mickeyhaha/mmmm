/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmstock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.vmstock.entity.VmStock;
import com.jeeplus.modules.vmstock.dao.VmStockDao;

/**
 * 售货机库存Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class VmStockService extends CrudService<VmStockDao, VmStock> {

	public VmStock get(String id) {
		return super.get(id);
	}
	
	public List<VmStock> findList(VmStock vmStock) {
		return super.findList(vmStock);
	}
	
	public Page<VmStock> findPage(Page<VmStock> page, VmStock vmStock) {
		return super.findPage(page, vmStock);
	}
	
	@Transactional(readOnly = false)
	public void save(VmStock vmStock) {
		super.save(vmStock);
	}
	
	@Transactional(readOnly = false)
	public void delete(VmStock vmStock) {
		super.delete(vmStock);
	}
	
	
	
	
}