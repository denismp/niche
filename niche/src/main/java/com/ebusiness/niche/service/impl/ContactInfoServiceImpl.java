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

import com.ebusiness.niche.dao.ContactInfoDao;
import com.ebusiness.niche.entity.ContactInfo;
import com.ebusiness.niche.service.ContactInfoService;

/**
 * @author denisputnam
 *
 */
@Service("contactInfoService")
@Transactional(value="transactionManager")
public class ContactInfoServiceImpl implements ContactInfoService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ContactInfoDao contactInfoDao;
	
	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ContactInfoService#create(com.ebusiness.niche.entity.ContactInfo)
	 */
	@Override
	public ContactInfo create(ContactInfo contactInfo) {
		contactInfo.setCreatedDate(new Date());
		contactInfo.setUpdatedDate(contactInfo.getCreatedDate());
		contactInfo.setCreatedBy("niche");
		contactInfo.setUpdatedBy("niche");
		contactInfo = this.contactInfoDao.saveAndFlush(contactInfo);
		return contactInfo;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ContactInfoService#update(com.ebusiness.niche.entity.ContactInfo)
	 */
	@Override
	public ContactInfo update(ContactInfo contactInfo) {
		contactInfo.setUpdatedBy("niche");
		contactInfo.setUpdatedDate(new Date());
		contactInfo = this.contactInfoDao.saveAndFlush(contactInfo);
		return contactInfo;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ContactInfoService#delete(java.lang.Long)
	 */
	@Override
	public Optional<ContactInfo> delete(Long id) {
		Optional<ContactInfo> contactInfo = null;
		contactInfo = this.contactInfoDao.findById(id);
		this.contactInfoDao.deleteById(id);
		return contactInfo;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ContactInfoService#findAll()
	 */
	@Override
	public List<ContactInfo> findAll() {
		return this.contactInfoDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ContactInfoService#getByEmail(java.lang.String)
	 */
	@Override
	public Set<ContactInfo> getByEmail(String email) {
		return this.getByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ContactInfoService#getOne(java.lang.Long)
	 */
	@Override
	public ContactInfo getOne(Long id) {
		return this.contactInfoDao.getOne(id);
	}

}
