/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	
	// Number of none AMZ FBA sellers at or below the lowest prime price + 1.
	@Column
	@NotNull
	private Integer numberOfCompetitiveSellers;
	
	@Column
	private Integer unitsPerMonth;
	
	@Column
	private Double revenuePerMonth;
	
	@Column
	private Double estimatedProductCost; // should be 50% of FBA
	
	@Column
	private Double actualProductCost;
	
	@Column
	private Double estimatedAmazonFees;

	@Column
	private Double actualAmazonFees;
	
	@Column
	private Double estimatedShippingCost;
	
	@Column
	private Double actualShippingCost;
	
	@Column
	private Double estimatedProcessingCost;
	
	@Column
	private Double actualProcessingCost;
	
	@Column 
	private Double estimatedProfitMargin; // (Sales price - cost of goods sold)/Sales price -- is a decimal value.  x100 for percent
	
	@Column
	private Double actualProfitMargin;
	
	@Column
	private Double estimatedROI; // estimatedProfitMargin/(product cost + shipping cost + estimatedAmazonFees + processCost) -- should be 30%
	
	@Column
	private Double actualROI;
	
	@ManyToMany
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<Company> companys;
	
	@OneToMany
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<ContactInfo> contactInfos;
	
	@OneToMany
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<CriteriaYesNo> criteriaYesNos;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private CompetitorsToTarget competitorsToTarget;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private ShipmentInfo shipmentInfo;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private ParentAsin parentAsin;

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

	public Integer getUnitsPerMonth() {
		return unitsPerMonth;
	}

	public void setUnitsPerMonth(Integer unitsPerMonth) {
		this.unitsPerMonth = unitsPerMonth;
	}

	public Double getRevenuePerMonth() {
		return revenuePerMonth;
	}

	public void setRevenuePerMonth(Double revenuePerMonth) {
		this.revenuePerMonth = revenuePerMonth;
	}

	public Set<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(Set<Company> companys) {
		this.companys = companys;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Set<ContactInfo> getContactInfos() {
		return contactInfos;
	}

	public void setContactInfos(Set<ContactInfo> contactInfos) {
		this.contactInfos = contactInfos;
	}

	public Set<CriteriaYesNo> getCriteriaYesNos() {
		return criteriaYesNos;
	}

	public void setCriteriaYesNos(Set<CriteriaYesNo> criteriaYesNos) {
		this.criteriaYesNos = criteriaYesNos;
	}

	public CompetitorsToTarget getCompetitorsToTarget() {
		return competitorsToTarget;
	}

	public void setCompetitorsToTarget(CompetitorsToTarget competitorsToTarget) {
		this.competitorsToTarget = competitorsToTarget;
	}

	public ShipmentInfo getShipmentInfo() {
		return shipmentInfo;
	}

	public void setShipmentInfo(ShipmentInfo shipmentInfo) {
		this.shipmentInfo = shipmentInfo;
	}

	public ParentAsin getParentAsin() {
		return parentAsin;
	}

	public void setParentAsin(ParentAsin parentAsin) {
		this.parentAsin = parentAsin;
	}

	public Double getEstimatedProductCost() {
		return estimatedProductCost;
	}

	public void setEstimatedProductCost(Double estimatedProductCost) {
		this.estimatedProductCost = estimatedProductCost;
	}

	public Double getActualProductCost() {
		return actualProductCost;
	}

	public void setActualProductCost(Double actualProductCost) {
		this.actualProductCost = actualProductCost;
	}

	public Double getAmazonFees() {
		return estimatedAmazonFees;
	}

	public void setAmazonFees(Double amazonFees) {
		this.estimatedAmazonFees = amazonFees;
	}

	public Double getEstimatedShippingCost() {
		return estimatedShippingCost;
	}

	public void setEstimatedShippingCost(Double estimatedShippingCost) {
		this.estimatedShippingCost = estimatedShippingCost;
	}

	public Double getActualShippingCost() {
		return actualShippingCost;
	}

	public void setActualShippingCost(Double actualShippingCost) {
		this.actualShippingCost = actualShippingCost;
	}

	public Double getEstimatedProcessingCost() {
		return estimatedProcessingCost;
	}

	public void setEstimatedProcessingCost(Double estimatedProcessingCost) {
		this.estimatedProcessingCost = estimatedProcessingCost;
	}

	public Double getEstimatedProfitMargin() {
		return estimatedProfitMargin;
	}

	public void setEstimatedProfitMargin(Double estimatedProfitMargin) {
		this.estimatedProfitMargin = estimatedProfitMargin;
	}

	public Double getActualProfitMargin() {
		return actualProfitMargin;
	}

	public void setActualProfitMargin(Double actualProfitMargin) {
		this.actualProfitMargin = actualProfitMargin;
	}

	public Double getEstimatedROI() {
		return estimatedROI;
	}

	public void setEstimatedROI(Double estimatedROI) {
		this.estimatedROI = estimatedROI;
	}

	public Double getActualROI() {
		return actualROI;
	}

	public void setActualROI(Double actualROI) {
		this.actualROI = actualROI;
	}

	public Double getActualProcessingCost() {
		return actualProcessingCost;
	}

	public void setActualProcessingCost(Double actualProcessingCost) {
		this.actualProcessingCost = actualProcessingCost;
	}

	public Double getEstimatedAmazonFees() {
		return estimatedAmazonFees;
	}

	public void setEstimatedAmazonFees(Double estimatedAmazonFees) {
		this.estimatedAmazonFees = estimatedAmazonFees;
	}

	public Double getActualAmazonFees() {
		return actualAmazonFees;
	}

	public void setActualAmazonFees(Double actualAmazonFees) {
		this.actualAmazonFees = actualAmazonFees;
	}
}
