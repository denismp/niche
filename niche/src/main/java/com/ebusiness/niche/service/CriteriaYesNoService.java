/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.CriteriaYesNo;

/**
 * @author denisputnam
 *
 */
public interface CriteriaYesNoService {
	public CriteriaYesNo create(CriteriaYesNo criteriaYesNo);
	public CriteriaYesNo update(CriteriaYesNo criteriaYesNo);
	public Optional<CriteriaYesNo> delete(Long id);
}
