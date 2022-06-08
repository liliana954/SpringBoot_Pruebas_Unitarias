package com.spring.boot.apirest.act1.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.apirest.act1.model.Producto;
import com.spring.boot.apirest.act1.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired //para decirle al servicio que está conectado al repositorio y que está haciendo uso de la BD y de los objetos
	private ProductoRepository productoRepository;
	
	
	public List<Producto> getAllProductos() {
		return (List<Producto>)productoRepository.findAll();
	}

	public Producto findById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public void delete(Long id) {
		productoRepository.deleteById(id);
	}
}
