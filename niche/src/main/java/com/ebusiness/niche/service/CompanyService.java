/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.Company;

/**
 * @author denisputnam
 *
 */
public interface CompanyService {
	public Company create(Company company);
	public Company update(Company company);
	public Optional<Company> delete(Long id);
}
