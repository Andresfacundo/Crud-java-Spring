package com.example.Crud.API.Spring.Boot.services;

import com.example.Crud.API.Spring.Boot.model.Paciente;
import com.example.Crud.API.Spring.Boot.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    public ArrayList<Paciente> getAllPacientes() {
        return (ArrayList<Paciente>) pacienteRepository.findAll();
    }

    public Paciente saveUser(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente updatePaciente(Paciente request, Long id) {
        Paciente pacienteOptional = pacienteRepository.findById(id).get();

        pacienteOptional.setNombre(request.getNombre());
        pacienteOptional.setApellido(request.getApellido());
        pacienteOptional.setEmail(request.getEmail());

        return pacienteRepository.save(pacienteOptional);

    }

    public boolean deletePaciente(Long id) {
        try {
            pacienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
