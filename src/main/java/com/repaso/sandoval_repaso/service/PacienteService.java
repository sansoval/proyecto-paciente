package com.repaso.sandoval_repaso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.sandoval_repaso.entity.Paciente;
import com.repaso.sandoval_repaso.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repo;
	
	public void Registrar(Paciente p) {
		repo.save(p);
	}
	
	public void Actualzar(Paciente p) {
		repo.save(p);
	}
	
	public void Eliminar(Integer p) {
		repo.deleteById(p);
	}
	
	public Paciente BuscarPorId(Integer p) {
		return repo.findById(p).orElse(null);
	}
	
	public List<Paciente> ListarTodo(){
		return repo.findAll();
	}
}
