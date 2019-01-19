/**
 * 
 */
package com.ebusiness.niche.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ebusiness.niche.entity.ShipmentInfo;

/**
 * @author denisputnam
 *
 */
public interface ShipmentInfoDao extends JpaRepository<ShipmentInfo, Long> {
	@Query("SELECT s FROM ShipmentInfoService s WHERE s.fnsku = ?1")
	public Set<ShipmentInfo> getByfnsku( String fnsku );
	
	@Query("SELECT s FROM ShipmentInfoService s WHERE s.sku = ?1")
	public Set<ShipmentInfo> getBysku( String sku );
}
