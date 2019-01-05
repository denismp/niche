/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
                @UniqueConstraint(columnNames = {"sellerName"})
        }
)
public class CompetitorsToTarget extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7267752270724734059L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String sellerName;
	
	@Column
	private String url;
	
	@Column
	@NotNull
	private String sellerId;
	
	@Column(nullable = false)
	@NotNull
	private Date dateInventoryLastScouted = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public Date getDateInventoryLastScouted() {
		return dateInventoryLastScouted;
	}

	public void setDateInventoryLastScouted(Date dateInventoryLastScouted) {
		this.dateInventoryLastScouted = dateInventoryLastScouted;
	}

}