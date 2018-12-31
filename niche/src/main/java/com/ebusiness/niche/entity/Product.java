/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
                @UniqueConstraint(columnNames = {"asin"})
        }
)
public class Product extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2431892863112230996L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String asin;
	
	@Column
	private String productPageLink;
	
	@Column
	@NotNull
	private Integer twentyOnePointScore;
	
	@Column
	@NotNull
	private Double primeLowPrice;
	
	@Column
	@NotNull
	private Integer totalUnitsSoldPerMonth;
	
	@Column
	@NotNull
	private Double totalRevenuePerMonth;
	
	@Column
	@NotNull
	private Integer numberOfCompetitiveSellers;
	
	@ManyToOne
	private Company company;
	
	@OneToMany
	private Set<ContactInfo> contactInfos;

	@Column(length=4096)
	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getProductPageLink() {
		return productPageLink;
	}

	public void setProductPageLink(String productPageLink) {
		this.productPageLink = productPageLink;
	}

	public Integer getTwentyOnePointScore() {
		return twentyOnePointScore;
	}

	public void setTwentyOnePointScore(Integer twentyOnePointScore) {
		this.twentyOnePointScore = twentyOnePointScore;
	}

	public Double getPrimeLowPrice() {
		return primeLowPrice;
	}

	public void setPrimeLowPrice(Double primeLowPrice) {
		this.primeLowPrice = primeLowPrice;
	}

	public Integer getTotalUnitsSoldPerMonth() {
		return totalUnitsSoldPerMonth;
	}

	public void setTotalUnitsSoldPerMonth(Integer totalUnitsSoldPerMonth) {
		this.totalUnitsSoldPerMonth = totalUnitsSoldPerMonth;
	}

	public Double getTotalRevenuePerMonth() {
		return totalRevenuePerMonth;
	}

	public void setTotalRevenuePerMonth(Double totalRevenuePerMonth) {
		this.totalRevenuePerMonth = totalRevenuePerMonth;
	}

	public Integer getNumberOfCompetitiveSellers() {
		return numberOfCompetitiveSellers;
	}

	public void setNumberOfCompetitiveSellers(Integer numberOfCompetitiveSellers) {
		this.numberOfCompetitiveSellers = numberOfCompetitiveSellers;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(Set<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}
}
