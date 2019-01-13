/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.ParentAsin;

/**
 * @author denisputnam
 *
 */
public interface ParentAsinDao extends JpaRepository<ParentAsin, Long> {
	@Query("SELECT p FROM ParentAsin p WHERE p.asin = ?1")
	public Set<ParentAsin> getByAsin( String asin );
}
