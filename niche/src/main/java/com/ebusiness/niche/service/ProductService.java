/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.Product;

/**
 * @author denisputnam
 *
 */
public interface ProductService {
	public Product create(Product product);
	public Product update(Product product);
	public Optional<Product> delete(Long id);
	public List<Product> findAll();
	public Set<Product> getByAsin(String asin);
	public Product getOne(Long id);
}
