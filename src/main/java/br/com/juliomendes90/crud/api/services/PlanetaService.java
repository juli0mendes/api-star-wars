package br.com.juliomendes90.crud.api.services;

import java.util.List;

import br.com.juliomendes90.crud.api.documents.Planeta;

/**
 * @author Julio Mendes
 * @version 1.0 (22/04/2018)
 *
 */
public interface PlanetaService {

	List<Planeta> buscarTodos();
	
	Planeta buscarPorID(String id);
	
	Planeta buscarPorNome(String nome);
	
	Planeta cadastrar(Planeta planeta);
	
	Planeta alterar(Planeta planeta);
	
	void remover(String id);
}
