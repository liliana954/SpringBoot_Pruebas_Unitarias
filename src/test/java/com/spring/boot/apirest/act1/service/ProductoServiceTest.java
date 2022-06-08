package com.spring.boot.apirest.act1.service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.boot.apirest.act1.model.Producto;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductoServiceTest {
	
	@Mock
	ProductoService service;
	
	@InjectMocks
	Producto productoTest;
	
	@Before
	public void prepare () {
		productoTest= new Producto();
				
		productoTest.setId((long)4);
		productoTest.setNombre_producto("trajeta crédito");
		productoTest.setBeneficios("sin anualidad");
	}
	
	@Test
	@Order(1)
	public void testCreate() {
		Producto productoNuevo = new Producto();
		productoNuevo.setId((long)4);
		productoNuevo.setNombre_producto("Cuenta Maestra");
		productoNuevo.setBeneficios("Apertura con mínima cantidad");
		service.create(productoNuevo);
		assertThat(productoNuevo).isNotNull();	
	}
	
	@Test
	@Order(2)
	public void testGetAll() {
		List<Producto> response = service.getAllProductos();
		assertThat(response).isNotNull();
	}
	
	@Test
	@Order(3)
	public void testGetById() {
		Producto productoElegido = (Producto) service.findById(4L);
		assertEquals(productoElegido, 4L);
	}
}