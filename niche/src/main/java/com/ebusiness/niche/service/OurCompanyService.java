/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.OurCompany;

/**
 * @author denisputnam
 *
 */
public interface OurCompanyService {
	public OurCompany create(OurCompany ourCompany);
	public OurCompany update(OurCompany ourCompany);
	public Optional<OurCompany> delete(Long id);
}
