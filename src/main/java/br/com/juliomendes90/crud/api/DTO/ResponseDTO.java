package br.com.juliomendes90.crud.api.DTO;

import java.util.List;

public class ResponseDTO {

	private Integer count;
	
	private String next;
	
	private String previous;
	
	private List<ResponsePlanetaDTO> results;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<ResponsePlanetaDTO> getResults() {
		return results;
	}

	public void setResults(List<ResponsePlanetaDTO> results) {
		this.results = results;
	}
}
