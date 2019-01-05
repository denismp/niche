/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.Company;
import com.ebusiness.niche.entity.ContactInfo;

/**
 * @author denisputnam
 *
 */
public interface ContactInfoDao extends JpaRepository<ContactInfo, Long> {
	@Query("SELECT c FROM ContactInfo c WHERE c.email = ?1")
	public Set<Company> getByEmail( String email );

}
