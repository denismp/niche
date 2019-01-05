/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.CompetitorsToTarget;

/**
 * @author denisputnam
 *
 */
public interface CompetitorsToTargetDao extends JpaRepository<CompetitorsToTarget, Long> {
	@Query("SELECT c FROM CompetitorsToTarget c WHERE c.sellerName = ?1")
	public Set<CompetitorsToTarget> getBySellerName( String sellerName );
	
	@Query("SELECT c FROM CompetitorsToTarget c inner join c.products p WHERE p.asin = ?1")
	public Set<CompetitorsToTarget> getByAsin( String asin );
}
