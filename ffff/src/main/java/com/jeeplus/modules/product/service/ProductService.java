/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.modules.batch.entity.Batch;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.product.entity.Product;
import com.jeeplus.modules.product.dao.ProductDao;

/**
 * 产品列表Service
 * @author Jason Dong
 * @version 2017-12-19
 */
@Service
@Transactional(readOnly = true)
public class ProductService extends CrudService<ProductDao, Product> {

	public Product get(String id) {
		return super.get(id);
	}
	
	public List<Product> findList(Product product) {
		return super.findList(product);
	}
	
	public Page<Product> findPage(Page<Product> page, Product product) {
		return super.findPage(page, product);
	}
	
	@Transactional(readOnly = false)
	public void save(Product product) {
		super.save(product);
	}
	
	@Transactional(readOnly = false)
	public void delete(Product product) {
		super.delete(product);
	}
	
	public Page<Batch> findPageBybatch(Page<Batch> page, Batch batch) {
		batch.setPage(page);
		page.setList(dao.findListBybatch(batch));
		return page;
	}
	
	
	
}