/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.ContactInfo;

/**
 * @author denisputnam
 *
 */
public interface ContactInfoService {
	public ContactInfo create(ContactInfo contactInfo);
	public ContactInfo update(ContactInfo contactInfo);
	public Optional<ContactInfo> delete(Long id);
}
