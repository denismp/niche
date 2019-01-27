/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.ParentAsin;

/**
 * @author denisputnam
 *
 */
public interface ParentAsinService {
	public ParentAsin create(ParentAsin parentAsin);
	public ParentAsin update(ParentAsin parentAsin);
	public Optional<ParentAsin> delete(Long id);
	public List<ParentAsin> findAll();
	public Set<ParentAsin> getByAsin(String asin);
	public ParentAsin getOne(Long id);
}
