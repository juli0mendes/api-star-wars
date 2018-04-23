package br.com.juliomendes90.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.juliomendes90.crud.api.documents.Planeta;

/**
 * @author Julio Mendes
 * @version 1.0 (22/04/2018)
 *
 */
@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	public Planeta findOneBynome(String nome);
	
}
