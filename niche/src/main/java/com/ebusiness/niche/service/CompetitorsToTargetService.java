/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.CompetitorsToTarget;

/**
 * @author denisputnam
 *
 */
public interface CompetitorsToTargetService {
	public CompetitorsToTarget create(CompetitorsToTarget competitorsToTarget);
	public CompetitorsToTarget update(CompetitorsToTarget competitorsToTarget);
	public Optional<CompetitorsToTarget> delete(Long id);
	public List<CompetitorsToTarget> findAll();
	public Set<CompetitorsToTarget> getBySellerId(String sellerId);
	public Set<CompetitorsToTarget> getBySellerName(String name);
	public CompetitorsToTarget getOne(Long id);
}
