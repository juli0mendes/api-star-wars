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

import com.google.gson.Gson;

import br.com.juliomendes90.crud.api.Constantes.Constantes;
import br.com.juliomendes90.crud.api.DTO.ResponseDTO;
import br.com.juliomendes90.crud.api.DTO.ResponsePlanetaDTO;
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
			item.setQuantAparicoesEmFilmes(getQtdFilmes(item));
		});
		
		return planetas;
	}

	@Override
	public Planeta buscarPorID(String id) {
		Planeta p = this.repository.findOne(id);
		
		if (p != null) {
			p.setQuantAparicoesEmFilmes(this.getQtdFilmes(p));
		}
		
		return p;
	}

	@Override
	public Planeta buscarPorNome(String nome) {
		return this.repository.findOneBynome(nome);
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
	
	private Integer getQtdFilmes(Planeta planeta) {
		
		Gson gson = new Gson();
		
		String url = Constantes.URL.PLANETS + planeta.getNome();
		
		RestTemplate restTemplate = new RestTemplate();
        
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		ResponseDTO dto = gson.fromJson(response.getBody(), ResponseDTO.class);
        
		return obtemQtdFilmes(planeta.getNome(), dto);
	}
	
	private Integer obtemQtdFilmes(final String planeta, ResponseDTO dto) {
		if (dto.getCount() < 0) {
			return 0;
		} else if (dto.getCount() > 1) {
			return verificaEqualNome(dto.getResults(), planeta);
		} else {
			return dto.getResults().get(0).getFilms().size();
		}
	}
	
	private Integer verificaEqualNome(List<ResponsePlanetaDTO> lista, String nome) {
		for (ResponsePlanetaDTO dto : lista) {
			if (dto.getName().equals(nome)) {
				return dto.getFilms().size();
			}
		}
		return 0;
	}
}
