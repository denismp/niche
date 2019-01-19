/**
 * 
 */
package com.ebusiness.niche.service;

import java.util.Optional;

import com.ebusiness.niche.entity.ShipmentInfo;

/**
 * @author denisputnam
 *
 */
public interface ShipmentInfoService {
	public ShipmentInfo create(ShipmentInfo shipmentInfo);
	public ShipmentInfo update(ShipmentInfo shipmentInfo);
	public Optional<ShipmentInfo> delete(Long id);

}
