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

import com.ebusiness.niche.dao.OurCompanyDao;
import com.ebusiness.niche.entity.OurCompany;
import com.ebusiness.niche.service.OurCompanyService;

/**
 * @author denisputnam
 *
 */
@Service("ourCompanyService")
@Transactional(value="transactionManager")
public class OurCompanyServiceImpl implements OurCompanyService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private OurCompanyDao ourCompanyDao;
	
	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.OurCompanyService#create(com.ebusiness.niche.entity.OurCompany)
	 */
	@Override
	public OurCompany create(OurCompany ourCompany) {
		ourCompany.setCreatedDate(new Date());
		ourCompany.setUpdatedDate(ourCompany.getCreatedDate());
		ourCompany.setCreatedBy("niche");
		ourCompany.setUpdatedBy("niche");
		ourCompany = this.ourCompanyDao.saveAndFlush(ourCompany);
		return ourCompany;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.OurCompanyService#update(com.ebusiness.niche.entity.OurCompany)
	 */
	@Override
	public OurCompany update(OurCompany ourCompany) {
		ourCompany.setUpdatedBy("niche");
		ourCompany.setUpdatedDate(new Date());
		ourCompany = this.ourCompanyDao.saveAndFlush(ourCompany);
		return ourCompany;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.OurCompanyService#delete(java.lang.Long)
	 */
	@Override
	public Optional<OurCompany> delete(Long id) {
		Optional<OurCompany> ourCompany = null;
		ourCompany = this.ourCompanyDao.findById(id);
		this.ourCompanyDao.deleteById(id);
		return ourCompany;
	}

}
