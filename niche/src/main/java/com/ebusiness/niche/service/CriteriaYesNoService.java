/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.CriteriaYesNo;

/**
 * @author denisputnam
 *
 */
public interface CriteriaYesNoService {
	public CriteriaYesNo create(CriteriaYesNo criteriaYesNo);
	public CriteriaYesNo update(CriteriaYesNo criteriaYesNo);
	public Optional<CriteriaYesNo> delete(Long id);
	public List<CriteriaYesNo> findAll();
	public CriteriaYesNo getOne(Long id);
	public Set<CriteriaYesNo> getByAsin(String asin);
}
