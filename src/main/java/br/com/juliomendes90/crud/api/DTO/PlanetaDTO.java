package br.com.juliomendes90.crud.api.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetaDTO {

	private String name;
	
	private String rotation_period;
	
	private String orbital_period;
	
	private String diameter;
	
	private String climate;
	
	private String gravity;
	
	private String terrain;
	
	private String surface_water;
	
	private String population;
    
	private List<String> residents;

	private List<String> films;
    
	private String created;
    
    private String edited;
    
    private String url;

	public PlanetaDTO() {
		super();
	}

	public PlanetaDTO(String name, String rotation_period, String orbital_period, String diameter, String climate,
			String gravity, String terrain, String surface_water, String population, List<String> residents,
			List<String> films, String created, String edited, String url) {
		super();
		this.name = name;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.population = population;
		this.residents = residents;
		this.films = films;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRotation_period() {
		return rotation_period;
	}

	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}

	public String getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getSurface_water() {
		return surface_water;
	}

	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PlanetaDTO [name=" + name + ", rotation_period=" + rotation_period + ", orbital_period="
				+ orbital_period + ", diameter=" + diameter + ", climate=" + climate + ", gravity=" + gravity
				+ ", terrain=" + terrain + ", surface_water=" + surface_water + ", population=" + population
				+ ", residents=" + residents + ", films=" + films + ", created=" + created + ", edited=" + edited
				+ ", url=" + url + "]";
	}
	
	
}
