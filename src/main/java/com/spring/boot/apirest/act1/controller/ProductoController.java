package com.spring.boot.apirest.act1.controller;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.apirest.act1.model.Producto;
import com.spring.boot.apirest.act1.service.ProductoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	@ApiOperation(value = "Crea un producto")
	private ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		Producto temporal = productoService.create(producto);
		
		try {
			return ResponseEntity.created(new URI("/api/producto"+temporal.getId())).body(temporal); 
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Obtiene todos los productos")
	private ResponseEntity<List<Producto>> listarTodosLosProductos(){
		return ResponseEntity.ok(productoService.getAllProductos()); 
	}
	
	@DeleteMapping (value = "/{id}")
	@ApiOperation(value = "Elimina un producto por id")
	private ResponseEntity<Void> eliminarProducto(@PathVariable ("id")Long id){
		productoService.delete(id);
		return ResponseEntity.ok().build(); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene un producto por id")
	private ResponseEntity<Producto> listarProductoPorId(@PathVariable ("id") Long id){
		return ResponseEntity.ok(productoService.findById(id)); 
	}
}
