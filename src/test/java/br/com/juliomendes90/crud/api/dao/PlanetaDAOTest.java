package br.com.juliomendes90.crud.api.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.juliomendes90.crud.api.documents.Planeta;
import br.com.juliomendes90.crud.api.repositories.PlanetaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetaDAOTest {

	@Autowired
	private PlanetaRepository repository;
	
	@Before
    public void setUp() throws Exception {
        
		Planeta planeta1 = new Planeta("Teste 1", "teste 1", "teste 1", 3);
        Planeta planeta2 = new Planeta("Teste 2", "teste 2", "teste 2", 5);
        
        assertNull(planeta1.getId());
        assertNull(planeta2.getId());
        
        this.repository.save(planeta1);
        this.repository.save(planeta2);
        
        assertNotNull(planeta1.getId());
        assertNotNull(planeta2.getId());
    }
	
	@Test
    public void testarBusca(){
        Planeta planeta1 = repository.findOneBynome("Teste 2");
        
        assertNotNull(planeta1);
        assertEquals(5, planeta1.getQuantAparicoesEmFilmes().longValue());
        
        Iterable<Planeta> planetas = repository.findAll();
        
        int count = 0;
        
        for(@SuppressWarnings("unused") Planeta p : planetas){
            count++;
        }
        
        assertEquals(count, 2);
    }
	
	@Test
    public void testarAtualizacao(){
        
		Planeta p = repository.findOneBynome("Teste 2");
        p.setQuantAparicoesEmFilmes(6);
        
        repository.save(p);
        
        Planeta planetaB = repository.findOneBynome("Teste 2");
        
        assertNotNull(planetaB);
        assertEquals(6, planetaB.getQuantAparicoesEmFilmes().longValue());
    }
	
	@After
    public void tearDown() throws Exception {
      this.repository.deleteAll();
    }
}
