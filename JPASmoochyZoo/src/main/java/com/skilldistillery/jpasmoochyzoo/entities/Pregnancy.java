package com.skilldistillery.jpasmoochyzoo.entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pregnancy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "expected_arrival")
	private Date expectedArrival;

	@Column(name = "number_of_offspring_expected")
	private int numberOfExpectedOffspring;

	public Pregnancy() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpectedArrival() {
		return expectedArrival;
	}

	public void setExpectedArrival(Date expectedArrival) {
		this.expectedArrival = expectedArrival;
	}

	public int getNumberOfExpectedOffspring() {
		return numberOfExpectedOffspring;
	}

	public void setNumberOfExpectedOffspring(int numberOfExpectedOffspring) {
		this.numberOfExpectedOffspring = numberOfExpectedOffspring;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pregnancy other = (Pregnancy) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Pregnancy [id=" + id + ", expectedArrival=" + expectedArrival + ", numberOfExpectedOffspring="
				+ numberOfExpectedOffspring + "]";
	}

}
