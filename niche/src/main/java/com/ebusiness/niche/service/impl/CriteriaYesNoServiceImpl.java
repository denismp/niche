/**
 * 
 */
package com.ebusiness.niche.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebusiness.niche.dao.CriteriaYesNoDao;
import com.ebusiness.niche.entity.CriteriaYesNo;
import com.ebusiness.niche.service.CriteriaYesNoService;

/**
 * @author denisputnam
 *
 */
@Service("criteriaYesNoService")
@Transactional(value="transactionManager")
public class CriteriaYesNoServiceImpl implements CriteriaYesNoService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CriteriaYesNoDao criteriaYesNoDao;

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CriteriaYesNoService#create(com.ebusiness.niche.entity.CriteriaYesNo)
	 */
	@Override
	public CriteriaYesNo create(CriteriaYesNo criteriaYesNo) {
		criteriaYesNo.setCreatedDate(new Date());
		criteriaYesNo.setUpdatedDate(criteriaYesNo.getCreatedDate());
		criteriaYesNo.setCreatedBy("niche");
		criteriaYesNo.setUpdatedBy("niche");
		criteriaYesNo = this.criteriaYesNoDao.saveAndFlush(criteriaYesNo);
		return criteriaYesNo;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CriteriaYesNoService#update(com.ebusiness.niche.entity.CriteriaYesNo)
	 */
	@Override
	public CriteriaYesNo update(CriteriaYesNo criteriaYesNo) {
		criteriaYesNo.setUpdatedBy("niche");
		criteriaYesNo.setUpdatedDate(new Date());
		criteriaYesNo = this.criteriaYesNoDao.saveAndFlush(criteriaYesNo);
		return criteriaYesNo;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CriteriaYesNoService#delete(java.lang.Long)
	 */
	@Override
	public Optional<CriteriaYesNo> delete(Long id) {
		Optional<CriteriaYesNo> criteriaYesNo = null;
		criteriaYesNo = this.criteriaYesNoDao.findById(id);
		this.criteriaYesNoDao.deleteById(id);
		return criteriaYesNo;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.CriteriaYesNoService#findAll()
	 */
	@Override
	public List<CriteriaYesNo> findAll() {
		return this.criteriaYesNoDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.CriteriaYesNoService#getOne(java.lang.Long)
	 */
	@Override
	public CriteriaYesNo getOne(Long id) {
		return this.criteriaYesNoDao.getOne(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.CriteriaYesNoService#getByAsin(java.lang.String)
	 */
	@Override
	public Set<CriteriaYesNo> getByAsin(String asin) {
		return this.getByAsin(asin);
	}

}
