/**
 * 
 */
package com.ebusiness.niche.service.impl;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebusiness.niche.dao.CompetitorsToTargetDao;
import com.ebusiness.niche.entity.CompetitorsToTarget;
import com.ebusiness.niche.service.CompetitorsToTargetService;

/**
 * @author denisputnam
 *
 */
@Service("competitorsToTargetService")
@Transactional(value="transactionManager")
public class CompetitorsToTargetServiceImpl implements CompetitorsToTargetService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CompetitorsToTargetDao competitorsToTargetDao;

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompetitorsToTargetService#create(com.ebusiness.niche.entity.CompetitorsToTarget)
	 */
	@Override
	public CompetitorsToTarget create(CompetitorsToTarget competitorsToTarget) {
		competitorsToTarget.setCreatedDate(new Date());
		competitorsToTarget.setUpdatedDate(competitorsToTarget.getCreatedDate());
		competitorsToTarget.setCreatedBy("niche");
		competitorsToTarget.setUpdatedBy("niche");
		competitorsToTarget = this.competitorsToTargetDao.saveAndFlush(competitorsToTarget);
		return competitorsToTarget;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompetitorsToTargetService#update(com.ebusiness.niche.entity.CompetitorsToTarget)
	 */
	@Override
	public CompetitorsToTarget update(CompetitorsToTarget competitorsToTarget) {
		competitorsToTarget.setUpdatedBy("niche");
		competitorsToTarget.setUpdatedDate(new Date());
		competitorsToTarget = this.competitorsToTargetDao.saveAndFlush(competitorsToTarget);
		return competitorsToTarget;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompetitorsToTargetService#delete(java.lang.Long)
	 */
	@Override
	public Optional<CompetitorsToTarget> delete(Long id) {
		Optional<CompetitorsToTarget> competitorsToTarget = null;
		competitorsToTarget = this.competitorsToTargetDao.findById(id);
		this.competitorsToTargetDao.deleteById(id);
		return competitorsToTarget;
	}

}
