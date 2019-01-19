/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.CheckPointCriteria;

/**
 * @author denisputnam
 *
 */
public interface CheckPointCriteriaService {
	public CheckPointCriteria create(CheckPointCriteria checkPointCriteria);
	public CheckPointCriteria update(CheckPointCriteria checkPointCriteria);
	public Optional<CheckPointCriteria> delete(Long id);
}
