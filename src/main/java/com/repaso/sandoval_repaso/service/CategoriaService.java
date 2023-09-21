package com.repaso.sandoval_repaso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.sandoval_repaso.entity.Categoria;
import com.repaso.sandoval_repaso.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> ListarTodo(){
		return repo.findAll();
	}
	
	public Categoria BuscarPorId(Integer p) {
		return repo.findById(p).orElse(null);
	}
}
