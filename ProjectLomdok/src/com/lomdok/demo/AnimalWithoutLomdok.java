package com.lomdok.demo;

import java.util.Objects;

public class AnimalWithoutLomdok {

	private String name;
	private String gender;
	private String species;

	public AnimalWithoutLomdok(String name, String gender, String species) {
		this.name = name;
		this.gender = gender;
		this.species = species;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof AnimalWithoutLomdok))
			return false;

		AnimalWithoutLomdok animal = (AnimalWithoutLomdok) o;

		if (gender != null ? !gender.equals(animal.gender)
				: animal.gender != null)
			return false;
		if (name != null ? !name.equals(animal.name) : animal.name != null)
			return false;
		if (species != null ? !species.equals(animal.species)
				: animal.species != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (species != null ? species.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return Objects.toString(this);
	}
}