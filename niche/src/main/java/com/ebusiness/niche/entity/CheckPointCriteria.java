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
                @UniqueConstraint(columnNames = {"criteriaName"})
        }
)
public class CheckPointCriteria extends History {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4664034671811060733L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String criteriaName;
	
	@Column
	@NotNull
	private Integer points;
	
	@ManyToMany
	@JsonProperty(access = Access.WRITE_ONLY)
	private Set<CriteriaYesNo> criteriaYesNos = new HashSet<CriteriaYesNo>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Set<CriteriaYesNo> getCriteriaYesNos() {
		return criteriaYesNos;
	}

	public void setCriteriaYesNos(Set<CriteriaYesNo> criteriaYesNos) {
		this.criteriaYesNos = criteriaYesNos;
	}

}
