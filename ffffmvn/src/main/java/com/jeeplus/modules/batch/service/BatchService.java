/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.batch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.batch.entity.Batch;
import com.jeeplus.modules.batch.dao.BatchDao;

/**
 * 批次管理Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class BatchService extends CrudService<BatchDao, Batch> {

	public Batch get(String id) {
		return super.get(id);
	}
	
	public List<Batch> findList(Batch batch) {
		return super.findList(batch);
	}
	
	public Page<Batch> findPage(Page<Batch> page, Batch batch) {
		return super.findPage(page, batch);
	}
	
	@Transactional(readOnly = false)
	public void save(Batch batch) {
		super.save(batch);
	}
	
	@Transactional(readOnly = false)
	public void delete(Batch batch) {
		super.delete(batch);
	}
	
	
	
	
}