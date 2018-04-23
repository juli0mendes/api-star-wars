package br.com.juliomendes90.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliomendes90.crud.api.documents.Planeta;
import br.com.juliomendes90.crud.api.responses.Response;
import br.com.juliomendes90.crud.api.services.PlanetaService;

/**
 * @author Julio Mendes
 * @version 1.0 (22/04/2018)
 *
 */
@RestController
@RequestMapping(path = "api/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<List<Planeta>>> buscarTodos() {
		return ResponseEntity.ok(new Response<List<Planeta>>(this.service.buscarTodos()));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscarPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Planeta>> buscarPorId(@PathVariable(name = "id") String id) {
		
		
		Planeta planetaEncontrado = this.service.buscarPorID(id);
		
		if (planetaEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(new Response<Planeta>(planetaEncontrado));
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscarPorNome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Planeta>> buscarPorNome(@PathVariable(name = "nome") String nome) {
		
		Planeta planetaEncontrado = this.service.buscarPorNome(nome);
		
		if (planetaEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(new Response<Planeta>(planetaEncontrado));
		}
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		
		return ResponseEntity.ok(new Response<Planeta>(this.service.cadastrar(planeta)));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response<Planeta>> alterar(@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		
		Planeta planetaEncontrado = this.service.buscarPorID(planeta.getId());
		
		if (planetaEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(new Response<Planeta>(this.service.alterar(planeta)));
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/remover/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		
		Planeta planetaEncontrado = this.service.buscarPorID(id);
		
		if (planetaEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			this.service.remover(id);
			return ResponseEntity.ok(new Response<Integer>(1));
		}
	}
}
