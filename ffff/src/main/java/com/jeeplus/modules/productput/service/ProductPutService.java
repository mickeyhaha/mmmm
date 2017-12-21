/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.productput.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.modules.product.entity.Product;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.sys.entity.User;
import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.productput.entity.ProductPut;
import com.jeeplus.modules.productput.dao.ProductPutDao;

/**
 * 补货单管理Service
 * @author Jason Dong
 * @version 2017-12-20
 */
@Service
@Transactional(readOnly = true)
public class ProductPutService extends CrudService<ProductPutDao, ProductPut> {

	public ProductPut get(String id) {
		return super.get(id);
	}
	
	public List<ProductPut> findList(ProductPut productPut) {
		return super.findList(productPut);
	}
	
	public Page<ProductPut> findPage(Page<ProductPut> page, ProductPut productPut) {
		return super.findPage(page, productPut);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductPut productPut) {
		super.save(productPut);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductPut productPut) {
		super.delete(productPut);
	}
	
	public Page<Product> findPageByproduct(Page<Product> page, Product product) {
		product.setPage(page);
		page.setList(dao.findListByproduct(product));
		return page;
	}
	public Page<VendingMachine> findPageByvendingMachine(Page<VendingMachine> page, VendingMachine vendingMachine) {
		vendingMachine.setPage(page);
		page.setList(dao.findListByvendingMachine(vendingMachine));
		return page;
	}
	public Page<User> findPageByuser(Page<User> page, User user) {
		user.setPage(page);
		page.setList(dao.findListByuser(user));
		return page;
	}
	
	
	
}