/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.campaign.dao;

import com.jeeplus.common.persistence.CrudDao;
import com.jeeplus.common.persistence.annotation.MyBatisDao;
import com.jeeplus.modules.campaign.entity.Campaign;

/**
 * 促销DAO接口
 * @author Jason Dong
 * @version 2017-12-18
 */
@MyBatisDao
public interface CampaignDao extends CrudDao<Campaign> {

	
}