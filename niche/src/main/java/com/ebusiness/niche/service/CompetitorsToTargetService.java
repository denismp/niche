/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.CompetitorsToTarget;

/**
 * @author denisputnam
 *
 */
public interface CompetitorsToTargetService {
	public CompetitorsToTarget create(CompetitorsToTarget competitorsToTarget);
	public CompetitorsToTarget update(CompetitorsToTarget competitorsToTarget);
	public Optional<CompetitorsToTarget> delete(Long id);
}
