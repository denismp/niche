/**
 * 
 */
package com.ebusiness.niche.service.impl;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.ebusiness.niche.dao.CompanyDao;
import com.ebusiness.niche.entity.Company;
import com.ebusiness.niche.service.CompanyService;

/**
 * @author denisputnam
 *
 */
public class CompanyServiceImpl implements CompanyService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CompanyDao companyDao;

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompanyService#create(com.ebusiness.niche.entity.Company)
	 */
	@Override
	public Company create(Company company) {
		company.setCreatedDate(new Date());
		company.setUpdatedDate(company.getCreatedDate());
		company.setCreatedBy("niche");
		company.setUpdatedBy("niche");
		company = this.companyDao.saveAndFlush(company);
		return company;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompanyService#update(com.ebusiness.niche.entity.Company)
	 */
	@Override
	public Company update(Company company) {
		company.setUpdatedBy("niche");
		company.setUpdatedDate(new Date());
		company = this.companyDao.saveAndFlush(company);
		return company;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompanyService#delete(com.ebusiness.niche.entity.Company)
	 */
	@Override
	public Optional<Company> delete(Long id) {
		Optional<Company> company = null;
		company = this.companyDao.findById(id);
		return company;
	}

}
