/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.productput.dao;

import com.jeeplus.modules.product.entity.Product;
import com.jeeplus.modules.vm.entity.VendingMachine;
import com.jeeplus.modules.sys.entity.User;
import java.util.List;
import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.productput.entity.ProductPut;

/**
 * 补货单管理DAO接口
 * @author Jason Dong
 * @version 2017-12-20
 */
@MyBatisDao
public interface ProductPutDao extends CrudDao<ProductPut> {

	public List<Product> findListByproduct(Product product);
	public List<VendingMachine> findListByvendingMachine(VendingMachine vendingMachine);
	public List<User> findListByuser(User user);
	
}