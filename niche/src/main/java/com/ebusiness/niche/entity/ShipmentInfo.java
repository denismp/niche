/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
                @UniqueConstraint(columnNames = {"fnsku"})
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
	private String fnsku;
	
	@Column
	@NotNull
	private Date shipmentDate;
	
	@OneToMany
	private Set<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
