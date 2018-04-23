package br.com.juliomendes90.crud.api.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Julio Mendes
 * @version 1.0 (22/04/2018)
 *
 */
@Document
public class Planeta {

	@Id
	private String id;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	private Integer quantAparicoesEmFilmes;
	
	public Planeta(String nome, String clima, String terreno, Integer quantAparicoesEmFilmes) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quantAparicoesEmFilmes = quantAparicoesEmFilmes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Nome nao pode ser vazio")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "Clima nao pode ser vazio")
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	@NotEmpty(message = "Terreno nao pode ser vazio")
	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQuantAparicoesEmFilmes() {
		return quantAparicoesEmFilmes;
	}

	public void setQuantAparicoesEmFilmes(Integer quantAparicoesEmFilmes) {
		this.quantAparicoesEmFilmes = quantAparicoesEmFilmes;
	}
	
	
}
