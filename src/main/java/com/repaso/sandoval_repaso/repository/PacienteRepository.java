package com.repaso.sandoval_repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repaso.sandoval_repaso.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
