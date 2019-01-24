/**
 * 
 */
package com.ebusiness.niche.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebusiness.niche.dao.CheckPointCriteriaDao;
import com.ebusiness.niche.entity.CheckPointCriteria;
import com.ebusiness.niche.service.CheckPointCriteriaService;

/**
 * @author denisputnam
 *
 */
@Service("checkPointCriteriaService")
@Transactional(value="transactionManager")
public class CheckPointCriteriaServiceImpl implements CheckPointCriteriaService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CheckPointCriteriaDao checkPointCriteriaDao;

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CheckPointCriteriaService#create(com.ebusiness.niche.entity.CheckPointCriteria)
	 */
	@Override
	public CheckPointCriteria create(CheckPointCriteria checkPointCriteria) {
		checkPointCriteria.setCreatedDate(new Date());
		checkPointCriteria.setUpdatedDate(checkPointCriteria.getCreatedDate());
		checkPointCriteria.setCreatedBy("niche");
		checkPointCriteria.setUpdatedBy("niche");
		checkPointCriteria = this.checkPointCriteriaDao.saveAndFlush(checkPointCriteria);
		return checkPointCriteria;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CheckPointCriteriaService#update(com.ebusiness.niche.entity.CheckPointCriteria)
	 */
	@Override
	public CheckPointCriteria update(CheckPointCriteria checkPointCriteria) {
		checkPointCriteria.setUpdatedBy("niche");
		checkPointCriteria.setUpdatedDate(new Date());
		checkPointCriteria = this.checkPointCriteriaDao.saveAndFlush(checkPointCriteria);
		return checkPointCriteria;	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CheckPointCriteriaService#delete(java.lang.Long)
	 */
	@Override
	public Optional<CheckPointCriteria> delete(Long id) {
		Optional<CheckPointCriteria> checkPointCriteria = this.checkPointCriteriaDao.findById(id);
		this.checkPointCriteriaDao.deleteById(id);
		return checkPointCriteria;
	}

	@Override
	public List<CheckPointCriteria> findAll() {
		// TODO Auto-generated method stub
		return this.checkPointCriteriaDao.findAll();
	}

}
