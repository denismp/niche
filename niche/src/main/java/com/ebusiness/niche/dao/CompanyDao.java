/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.Company;

/**
 * @author denisputnam
 *
 */
public interface CompanyDao extends JpaRepository<Company, Long> {
	@Query("SELECT n FROM Company n WHERE n.email = ?1")
	public Set<Company> getByEmail( String email );

}
