/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.Contact;

/**
 * @author denisputnam
 *
 */
public interface ContactDao extends JpaRepository<Contact, Long> {
	@Query("SELECT n FROM Contact n WHERE n.name = ?1")
	public Set<Contact> getByName( String name );

}
