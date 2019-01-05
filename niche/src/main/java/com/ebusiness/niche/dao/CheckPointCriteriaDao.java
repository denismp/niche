/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.CheckPointCriteria;

/**
 * @author denisputnam
 *
 */
public interface CheckPointCriteriaDao extends JpaRepository<CheckPointCriteria, Long> {
	@Query("SELECT c FROM CheckPointCriteria c WHERE c.criteriaName = ?1")
	public Set<CheckPointCriteria> getByCriteria( String criteria );
}
