/**
 * 
 */
package com.ebusiness.niche.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebusiness.niche.dao.ProductDao;
import com.ebusiness.niche.entity.Product;
import com.ebusiness.niche.service.ProductService;

/**
 * @author denisputnam
 *
 */
@Service("productService")
@Transactional(value="transactionManager")
public class ProductServiceImpl implements ProductService {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProductDao productDao;

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ProductService#create(com.ebusiness.niche.entity.Product)
	 */
	@Override
	public Product create(Product product) {
		product.setCreatedDate(new Date());
		product.setUpdatedDate(product.getCreatedDate());
		product.setCreatedBy("niche");
		product.setUpdatedBy("niche");
		product = this.productDao.saveAndFlush(product);
		return product;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ProductService#update(com.ebusiness.niche.entity.Product)
	 */
	@Override
	public Product update(Product product) {
		product.setUpdatedBy("niche");
		product.setUpdatedDate(new Date());
		product = this.productDao.saveAndFlush(product);
		return product;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ProductService#delete(java.lang.Long)
	 */
	@Override
	public Optional<Product> delete(Long id) {
		Optional<Product> product = this.productDao.findById(id);
		this.productDao.deleteById(id);
		return product;
	}
	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ProductService#findAll()
	 */
	@Override
	public List<Product> findAll() {
		return this.productDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ProductService#getByAsin(java.lang.String)
	 */
	@Override
	public Set<Product> getByAsin(String asin) {
		return this.getByAsin(asin);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ProductService#getOne(java.lang.Long)
	 */
	@Override
	public Product getOne(Long id) {
		return this.getOne(id);
	}	
}
