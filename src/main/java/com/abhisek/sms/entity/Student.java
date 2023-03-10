package com.abhisek.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="first_name",nullable=false)
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="_email_")
	private String eamil;
	public Student(String firstname, String lastname, String eamil) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.eamil = eamil;
	}
	public Long getId() {
		return id;
	}
	public Student() {
		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

}
