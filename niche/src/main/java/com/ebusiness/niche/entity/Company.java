/**
 * 
 */
package com.ebusiness.niche.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * @author denisputnam
 *
 */
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"})
        }
)
public class Company extends History implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1329304564033025946L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String companyName;
	
	@Column
	@NotNull
	private String webSite;
	
	@Column
	@NotNull
	private String phone;
	
	@Column(length=4096)
	private String notes;
	
	@ManyToMany(mappedBy="companys")
	@JsonProperty(access = Access.WRITE_ONLY)
	Set<Product> products;
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonIgnore
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
