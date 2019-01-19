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

import com.ebusiness.niche.dao.ParentAsinDao;
import com.ebusiness.niche.entity.ParentAsin;
import com.ebusiness.niche.service.ParentAsinService;

/**
 * @author denisputnam
 *
 */
@Service("parentAsinService")
@Transactional(value="transactionManager")
public class ParentAsinServiceImpl implements ParentAsinService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ParentAsinDao parentAsinDao;

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ParentAsinService#create(com.ebusiness.niche.entity.ParentAsin)
	 */
	@Override
	public ParentAsin create(ParentAsin parentAsin) {
		parentAsin.setCreatedDate(new Date());
		parentAsin.setUpdatedDate(parentAsin.getCreatedDate());
		parentAsin.setCreatedBy("niche");
		parentAsin.setUpdatedBy("niche");
		parentAsin = this.parentAsinDao.saveAndFlush(parentAsin);
		return parentAsin;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ParentAsinService#update(com.ebusiness.niche.entity.ParentAsin)
	 */
	@Override
	public ParentAsin update(ParentAsin parentAsin) {
		parentAsin.setUpdatedBy("niche");
		parentAsin.setUpdatedDate(new Date());
		parentAsin = this.parentAsinDao.saveAndFlush(parentAsin);
		return parentAsin;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ParentAsinService#delete(java.lang.Long)
	 */
	@Override
	public Optional<ParentAsin> delete(Long id) {
		Optional<ParentAsin> parentAsin = this.parentAsinDao.findById(id);
		this.parentAsinDao.deleteById(id);
		return parentAsin;
	}

}
