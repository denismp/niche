/**
 * 
 */
package com.ebusiness.niche.entity;

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
                @UniqueConstraint(columnNames = {"asin"})
        }
)
public class ParentAsin extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4973910878765405863L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String asin;
	
	@OneToMany
	private Set<Product> childAsins;

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

	public Set<Product> getChildAsins() {
		return childAsins;
	}

	public void setChildAsins(Set<Product> childAsins) {
		this.childAsins = childAsins;
	}
}
