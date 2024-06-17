package com.example.Crud.API.Spring.Boot.repository;

import com.example.Crud.API.Spring.Boot.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
