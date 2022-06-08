package com.spring.boot.apirest.act1.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.apirest.act1.model.Categoria;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoriaServiceTest {
	@Mock
	CategoriaService service;
	
	@InjectMocks
	Categoria categoriaTest;
	
	@Before
	public void prepare () {
		categoriaTest= new Categoria();
				
		categoriaTest.setId((long)6);
		categoriaTest.setNombre_categoria("Lite");
	}
	
	@Test
	void testGetAllCategorias() {
		List<Categoria> response = service.getAllCategorias();
		assertThat(response).isNotNull();
	}

	@Test
	void testCreate() {
		Categoria categoriaNueva = new Categoria();
		categoriaNueva.setId((long)6);
		categoriaNueva.setNombre_categoria("Lite");
		service.create(categoriaNueva);
		assertThat(categoriaNueva).isNotNull();	
	}

}
