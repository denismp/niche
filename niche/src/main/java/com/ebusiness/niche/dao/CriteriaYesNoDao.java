/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.CriteriaYesNo;

/**
 * @author denisputnam
 *
 */
public interface CriteriaYesNoDao extends JpaRepository<CriteriaYesNo, Long> {
	@Query("SELECT c FROM CriteriaYesNo c inner join c.product p WHERE p.asin = ?1")
	public Set<CriteriaYesNo> getByAsin( String asin );

}
