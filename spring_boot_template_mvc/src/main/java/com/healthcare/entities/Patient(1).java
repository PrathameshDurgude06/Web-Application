package com.healthcare.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient extends BaseEntity {
	@Column(name="name",length=20)
	String name;
	
	@Column(name="disease")
	String disease;
	
	
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String disease) {
		super();
		this.name = name;
		this.disease = disease;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", disease=" + disease + "]";
	}
	
	
}
