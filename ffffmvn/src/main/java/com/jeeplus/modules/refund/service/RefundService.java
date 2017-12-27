/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.refund.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.refund.entity.Refund;
import com.jeeplus.modules.refund.dao.RefundDao;

/**
 * 退款Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class RefundService extends CrudService<RefundDao, Refund> {

	public Refund get(String id) {
		return super.get(id);
	}
	
	public List<Refund> findList(Refund refund) {
		return super.findList(refund);
	}
	
	public Page<Refund> findPage(Page<Refund> page, Refund refund) {
		return super.findPage(page, refund);
	}
	
	@Transactional(readOnly = false)
	public void save(Refund refund) {
		super.save(refund);
	}
	
	@Transactional(readOnly = false)
	public void delete(Refund refund) {
		super.delete(refund);
	}
	
	
	
	
}