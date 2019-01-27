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

import com.ebusiness.niche.dao.ShipmentInfoDao;
import com.ebusiness.niche.entity.ShipmentInfo;
import com.ebusiness.niche.service.ShipmentInfoService;

/**
 * @author denisputnam
 *
 */
@Service("shipmentInfoService")
@Transactional(value="transactionManager")
public class ShipmentInfoServiceImpl implements ShipmentInfoService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ShipmentInfoDao shipmentInfoDao;

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ShipmentInfoService#create(com.ebusiness.niche.entity.ShipmentInfo)
	 */
	@Override
	public ShipmentInfo create(ShipmentInfo shipmentInfo) {
		shipmentInfo.setCreatedDate(new Date());
		shipmentInfo.setUpdatedDate(shipmentInfo.getCreatedDate());
		shipmentInfo.setCreatedBy("niche");
		shipmentInfo.setUpdatedBy("niche");
		shipmentInfo = this.shipmentInfoDao.saveAndFlush(shipmentInfo);
		return shipmentInfo;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ShipmentInfoService#update(com.ebusiness.niche.entity.ShipmentInfo)
	 */
	@Override
	public ShipmentInfo update(ShipmentInfo shipmentInfo) {
		shipmentInfo.setUpdatedBy("niche");
		shipmentInfo.setUpdatedDate(new Date());
		shipmentInfo = this.shipmentInfoDao.saveAndFlush(shipmentInfo);
		return shipmentInfo;
	}

	/* (non-Javadoc)
	 * @see com.ebusiness.niche.service.ShipmentInfoService#delete(java.lang.Long)
	 */
	@Override
	public Optional<ShipmentInfo> delete(Long id) {
		Optional<ShipmentInfo> shipmentInfo = this.shipmentInfoDao.findById(id);
		this.shipmentInfoDao.deleteById(id);
		return shipmentInfo;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ShipmentInfoService#findAll()
	 */
	@Override
	public List<ShipmentInfo> findAll() {
		return this.shipmentInfoDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ShipmentInfoService#getByfnsku(java.lang.String)
	 */
	@Override
	public Set<ShipmentInfo> getByfnsku(String fnsku) {
		return this.shipmentInfoDao.getByfnsku(fnsku);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ebusiness.niche.service.ShipmentInfoService#getBysku(java.lang.String)
	 */
	@Override
	public Set<ShipmentInfo> getBysku(String sku) {
		return this.shipmentInfoDao.getByfnsku(sku);
	}

	@Override
	public ShipmentInfo getOne(Long id) {
		return this.shipmentInfoDao.getOne(id);
	}

}
