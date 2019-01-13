/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.Product;

/**
 * @author denisputnam
 *
 */
public interface ProductService {
	public Product create(Product product);
	public Product update(Product product);
	public Optional<Product> delete(Long id);
}
