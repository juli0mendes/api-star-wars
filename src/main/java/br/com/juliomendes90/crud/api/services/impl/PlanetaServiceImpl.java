package br.com.juliomendes90.crud.api.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.juliomendes90.crud.api.Constantes.Constantes;
import br.com.juliomendes90.crud.api.DTO.PlanetaDTO;
import br.com.juliomendes90.crud.api.documents.Planeta;
import br.com.juliomendes90.crud.api.repositories.PlanetaRepository;
import br.com.juliomendes90.crud.api.services.PlanetaService;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository repository;
	
	@Override
	public List<Planeta> buscarTodos() {

		List<Planeta> planetas = this.repository.findAll();
		
		planetas.forEach(item -> {
			String url = Constantes.URL.PLANETS + "3";
			
			RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);


            ResponseEntity<PlanetaDTO> retorno = restTemplate.exchange(url, HttpMethod.GET, entity, PlanetaDTO.class);
			
			System.out.println(">>> " + retorno);
		});
		
		return planetas;
	}

	@Override
	public Planeta buscarPorID(String id) {
		return this.repository.findOne(id);
	}

	@Override
	public List<Planeta> buscarPorNome(String nome) {
		// TODO implementar no repository
		return null;
	}

	@Override
	public Planeta cadastrar(Planeta planeta) {
		return this.repository.save(planeta);
	}

	@Override
	public Planeta alterar(Planeta planeta) {
		return this.repository.save(planeta);
	}

	@Override
	public void remover(String id) {
		this.repository.delete(id);
	}

}
