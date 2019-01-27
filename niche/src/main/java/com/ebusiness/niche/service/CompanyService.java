/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.Company;

/**
 * @author denisputnam
 *
 */
public interface CompanyService {
	public Company create(Company company);
	public Company update(Company company);
	public Optional<Company> delete(Long id);
	public List<Company> findAll();
	public Set<Company> getByEmail(String email);
	public Company getOne(Long id);
}
