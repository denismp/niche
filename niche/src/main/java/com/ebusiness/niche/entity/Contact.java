/**
 * 
 */
package com.ebusiness.niche.entity;

import java.io.Serializable;

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
                @UniqueConstraint(columnNames = {"name"})
        }
)
public class Contact extends History implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1329304564033025946L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String name;

}
