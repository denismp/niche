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

import com.ebusiness.niche.dao.CompanyDao;
import com.ebusiness.niche.entity.Company;
import com.ebusiness.niche.service.CompanyService;

/**
 * @author denisputnam
 *
 */
@Service("companyService")
@Transactional(value="transactionManager")
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
		this.companyDao.deleteById(id);
		return company;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompanyService#findAll()
	 */
	@Override
	public List<Company> findAll() {
		return this.companyDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompanyService#getOne(java.lang.Long)
	 */
	@Override
	public Company getOne(Long id) {
		return this.companyDao.getOne(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.CompanyService#getByEmail(java.lang.String)
	 */
	@Override
	public Set<Company> getByEmail(String email) {		
		return this.companyDao.getByEmail(email);
	}

}
