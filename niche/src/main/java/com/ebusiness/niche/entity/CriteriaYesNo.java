/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author denisputnam
 *
 */
@Entity
public class CriteriaYesNo extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660306049796606376L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private Boolean yes = false;
	
	@ManyToOne
	private Product product;
	
	@ManyToMany(mappedBy = "criteriaYesNos")
	private Set<CheckPointCriteria> checkPointCriterias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getYes() {
		return yes;
	}

	public void setYes(Boolean yes) {
		this.yes = yes;
	}

	public Set<CheckPointCriteria> getCheckPointCriterias() {
		return checkPointCriterias;
	}

	public void setCheckPointCriterias(Set<CheckPointCriteria> checkPointCriterias) {
		this.checkPointCriterias = checkPointCriterias;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
