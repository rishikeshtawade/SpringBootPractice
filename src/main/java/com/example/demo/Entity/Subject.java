package com.example.demo.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Subject {
	private String marathi;
	private String English;
	private String Mathametics;
	
	public String getMarathi() {
		return marathi;
	}
	public void setMarathi(String marathi) {
		this.marathi = marathi;
	}
	public String getEnglish() {
		return English;
	}
	public void setEnglish(String english) {
		English = english;
	}
	public String getMathametics() {
		return Mathametics;
	}
	public void setMathametics(String mathametics) {
		Mathametics = mathametics;
	}
		
}
