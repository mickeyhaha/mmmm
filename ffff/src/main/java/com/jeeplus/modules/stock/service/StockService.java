/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.stock.entity.Stock;
import com.jeeplus.modules.stock.dao.StockDao;

/**
 * 仓库库存Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class StockService extends CrudService<StockDao, Stock> {

	public Stock get(String id) {
		return super.get(id);
	}
	
	public List<Stock> findList(Stock stock) {
		return super.findList(stock);
	}
	
	public Page<Stock> findPage(Page<Stock> page, Stock stock) {
		return super.findPage(page, stock);
	}
	
	@Transactional(readOnly = false)
	public void save(Stock stock) {
		super.save(stock);
	}
	
	@Transactional(readOnly = false)
	public void delete(Stock stock) {
		super.delete(stock);
	}
	
	
	
	
}