/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.vmlog.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.vmlog.entity.VMLog;

/**
 * 售货机日志DAO接口
 * @author Jason Dong
 * @version 2017-12-18
 */
@MyBatisDao
public interface VMLogDao extends CrudDao<VMLog> {

	
}