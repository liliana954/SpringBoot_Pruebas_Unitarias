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

import com.spring.boot.apirest.act1.model.Categoria;
import com.spring.boot.apirest.act1.service.CategoriaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping
	@ApiOperation(value = "Crea una categoria")
	private ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
		Categoria temporal = categoriaService.create(categoria);
		
		try {
			return ResponseEntity.created(new URI("/api/producto"+temporal.getId())).body(temporal); 
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Obtiene todas las categorias")
	private ResponseEntity<List<Categoria>> listarTodosLasCategorias(){
		return ResponseEntity.ok(categoriaService.getAllCategorias()); 
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Obtiene categoria por id")
	private ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable ("id") Long id){
		return ResponseEntity.ok(categoriaService.findById(id)); 
	}
	
	@DeleteMapping (value = "/{id}")
	@ApiOperation(value = "Elimina una categoria por id")
	private ResponseEntity<Void> eliminarCategoria(@PathVariable ("id")Long id){
		categoriaService.delete(id);
		return ResponseEntity.ok().build(); 
	}
}
