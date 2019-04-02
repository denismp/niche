/**
 * 
 */
package com.ebusiness.niche.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
                @UniqueConstraint(columnNames = {"contactDate"})
        }
)
public class ContactInfo extends History {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7752253807187592214L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	private String phone1;
	
	@Column
	private String phone2;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String city;
	
	@Column 
	private String stateOrProvince;
	
	@Column
	private String postalCoed;
	
	@Column
	private String country;
	
	
	@Column
	@NotNull
	private Date contactDate;
	
	@Column(length=4096)
	private String notes;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;

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

	public Date getContactDate() {
		return contactDate;
	}

	public void setContactDate(Date contactDate) {
		this.contactDate = contactDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getPostalCoed() {
		return postalCoed;
	}

	public void setPostalCoed(String postalCoed) {
		this.postalCoed = postalCoed;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
