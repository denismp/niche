/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.Product;

/**
 * @author denisputnam
 *
 */
public interface ProductDao extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.asin = ?1")
	public Set<Product> getByAsin( String asin );
}
