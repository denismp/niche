/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.ParentAsin;

/**
 * @author denisputnam
 *
 */
public interface ParentAsinService {
	public ParentAsin create(ParentAsin parentAsin);
	public ParentAsin update(ParentAsin parentAsin);
	public Optional<ParentAsin> delete(Long id);
}
