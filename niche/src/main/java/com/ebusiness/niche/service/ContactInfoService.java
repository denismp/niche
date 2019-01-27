/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.ContactInfo;

/**
 * @author denisputnam
 *
 */
public interface ContactInfoService {
	public ContactInfo create(ContactInfo contactInfo);
	public ContactInfo update(ContactInfo contactInfo);
	public Optional<ContactInfo> delete(Long id);
	public List<ContactInfo> findAll();
	public Set<ContactInfo> getByEmail(String email);
	public ContactInfo getOne(Long id);
}
