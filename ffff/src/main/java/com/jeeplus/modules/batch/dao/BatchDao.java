/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.batch.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.batch.entity.Batch;

/**
 * 批次管理DAO接口
 * @author Jason Dong
 * @version 2017-12-18
 */
@MyBatisDao
public interface BatchDao extends CrudDao<Batch> {

	
}