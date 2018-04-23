package br.com.juliomendes90.crud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * @author Julio Mendes
 * @version 1.0 (22/04/2018)
 *
 */
@SpringBootApplication
public class ApiStarWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStarWarsApplication.class, args);
	}
}
