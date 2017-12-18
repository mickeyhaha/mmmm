/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.modules.campaign.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeeplus.common.persistence.Page;
import com.jeeplus.common.service.CrudService;
import com.jeeplus.modules.campaign.entity.Campaign;
import com.jeeplus.modules.campaign.dao.CampaignDao;

/**
 * 促销Service
 * @author Jason Dong
 * @version 2017-12-18
 */
@Service
@Transactional(readOnly = true)
public class CampaignService extends CrudService<CampaignDao, Campaign> {

	public Campaign get(String id) {
		return super.get(id);
	}
	
	public List<Campaign> findList(Campaign campaign) {
		return super.findList(campaign);
	}
	
	public Page<Campaign> findPage(Page<Campaign> page, Campaign campaign) {
		return super.findPage(page, campaign);
	}
	
	@Transactional(readOnly = false)
	public void save(Campaign campaign) {
		super.save(campaign);
	}
	
	@Transactional(readOnly = false)
	public void delete(Campaign campaign) {
		super.delete(campaign);
	}
	
	
	
	
}