package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
    private String vaccineName;
	@Column
    private String vaccineDetails;
	@Column
    private double price;
	@Column
    private int months;
	
	public Vaccine(int id, String vaccineName, String vaccineDetails, double price, int months) {
		super();
		this.id = id;
		this.vaccineName = vaccineName;
		this.vaccineDetails = vaccineDetails;
		this.price = price;
		this.months = months;
	}

	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public String getVaccineDetails() {
		return vaccineDetails;
	}

	public double getPrice() {
		return price;
	}

	public int getMonths() {
		return months;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public void setVaccineDetails(String vaccineDetails) {
		this.vaccineDetails = vaccineDetails;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setMonths(int months) {
		this.months = months;
	}

}
