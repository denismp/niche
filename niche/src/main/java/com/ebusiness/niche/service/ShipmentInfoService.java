/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.ebusiness.niche.entity.ShipmentInfo;

/**
 * @author denisputnam
 *
 */
public interface ShipmentInfoService {
	public ShipmentInfo create(ShipmentInfo shipmentInfo);
	public ShipmentInfo update(ShipmentInfo shipmentInfo);
	public Optional<ShipmentInfo> delete(Long id);
	public List<ShipmentInfo> findAll();
	public Set<ShipmentInfo> getByfnsku(String fnsku);	
	public Set<ShipmentInfo> getBysku(String sku);	
	public ShipmentInfo getOne(Long id);
}
