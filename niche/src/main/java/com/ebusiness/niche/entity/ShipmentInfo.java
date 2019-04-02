/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * @author denisputnam
 *
 */
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"shipmentId"})
        }
)
public class ShipmentInfo extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = 175178829089137336L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String shipmentId;
	
	@Column
	private String fnsku;
	
	@Column
	private String sku;
	
	@Column
	private Integer numberUnits;
	
	@Column
	@NotNull
	private Date shipmentDate;
	
	@Column
	private Date skuAssignedDate;
	
	@OneToOne
//	@JsonProperty(access = Access.WRITE_ONLY)
	@PrimaryKeyJoinColumn
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Integer getNumberUnits() {
		return numberUnits;
	}

	public void setNumberUnits(Integer numberUnits) {
		this.numberUnits = numberUnits;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getFnsku() {
		return fnsku;
	}

	public void setFnsku(String fnsku) {
		this.fnsku = fnsku;
	}

	public Date getShipmentCreateDate() {
		return shipmentDate;
	}

	public void setShipmentCreateDate(Date shipmentCreateDate) {
		this.shipmentDate = shipmentCreateDate;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public Date getSkuAssignedDate() {
		return skuAssignedDate;
	}

	public void setSkuAssignedDate(Date skuAssignedDate) {
		this.skuAssignedDate = skuAssignedDate;
	}

}
