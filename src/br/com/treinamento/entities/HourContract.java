package br.com.treinamento.entities;

import java.util.Date;

public class HourContract {
	
	public Date date;
	public Double valuePerHour;
	public Integer hours;
	
	public HourContract() {
		
	}
	
	

	public HourContract(Date date, Double valuePerHour, Integer hours) {
		
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() {
		return valuePerHour*hours;
	}

}
