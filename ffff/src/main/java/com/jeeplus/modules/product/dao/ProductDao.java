/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.product.dao;

import com.jeeplus.modules.batch.entity.Batch;
import java.util.List;
import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.product.entity.Product;

/**
 * 产品列表DAO接口
 * @author Jason Dong
 * @version 2017-12-20
 */
@MyBatisDao
public interface ProductDao extends CrudDao<Product> {

	public List<Batch> findListBybatch(Batch batch);
	
}