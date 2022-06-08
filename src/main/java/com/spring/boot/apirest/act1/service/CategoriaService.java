package com.spring.boot.apirest.act1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.apirest.act1.model.Categoria;
import com.spring.boot.apirest.act1.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategorias() {
		return (List<Categoria>)categoriaRepository.findAll();
	}

	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	public Categoria create(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}
}
