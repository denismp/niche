/**
 * 
 */
package com.ebusiness.niche.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author denisputnam
 *
 */
@Entity
public class OurCompany extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6743633100653587011L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
