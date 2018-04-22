package br.com.juliomendes90.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.juliomendes90.crud.api.documents.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {

}
