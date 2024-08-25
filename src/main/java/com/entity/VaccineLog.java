package com.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccinelog")
public class VaccineLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @ManyToOne
    @JoinColumn(name = "childID", nullable = false)
    private Child child;
    @Column
    private String vaccineName;
    @Column
    private Date date;
    @Column
    private int ageMonths;
    
	public VaccineLog(int id, Child child, String vaccineName, Date date, int ageMonths) {
		super();
		this.id = id;
		this.child = child;
		this.vaccineName = vaccineName;
		this.date = date;
		this.ageMonths = ageMonths;
	}

	public VaccineLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public VaccineLog(Child child, String vaccineName, Date date, int ageMonths) {
		super();
		this.child = child;
		this.vaccineName = vaccineName;
		this.date = date;
		this.ageMonths = ageMonths;
	}

	public int getId() {
		return id;
	}

	public Child getChild() {
		return child;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public Date getDate() {
		return date;
	}

	public int getAgeMonths() {
		return ageMonths;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setAgeMonths(int ageMonths) {
		this.ageMonths = ageMonths;
	}
    
}
