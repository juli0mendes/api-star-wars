package br.com.juliomendes90.crud.api.dto;

import java.util.List;

/**
 * @author Julio Mendes
 * @version 1.0 (22/04/2018)
 *
 */
public class ResponsePlanetaDTO {

	private String name;
	
	private String population;
	
	private List<String> residents;
	
	private List<String> films;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
}
