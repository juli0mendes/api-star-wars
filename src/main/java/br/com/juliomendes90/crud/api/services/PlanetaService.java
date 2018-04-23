package br.com.juliomendes90.crud.api.services;

import java.util.List;

import br.com.juliomendes90.crud.api.documents.Planeta;

public interface PlanetaService {

	List<Planeta> buscarTodos();
	
	Planeta buscarPorID(String id);
	
	Planeta buscarPorNome(String nome);
	
	Planeta cadastrar(Planeta planeta);
	
	Planeta alterar(Planeta planeta);
	
	void remover(String id);
}
