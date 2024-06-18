package com.example.Crud.API.Spring.Boot.services;

import com.example.Crud.API.Spring.Boot.model.Cita;
import com.example.Crud.API.Spring.Boot.model.Medico;
import com.example.Crud.API.Spring.Boot.model.Paciente;
import com.example.Crud.API.Spring.Boot.repository.ICitaRepository;
import com.example.Crud.API.Spring.Boot.repository.IMedicoRepository;
import com.example.Crud.API.Spring.Boot.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    ICitaRepository citaRepository;
    IMedicoRepository medicoRepository;
    IPacienteRepository ipacienteRepository;

    public ArrayList<Cita> getAllCitas() {
        return (ArrayList<Cita>) citaRepository.findAll();
    }

    public Cita createCita(Cita cita) {
        return citaRepository.save(cita);
    }
    public Optional<Cita> getCitaById(long id) {
        return citaRepository.findById(id);
    }

    public Cita updateCita(Cita request, Long id) {
        Cita citaOptional = citaRepository.findById(id).get();

        citaOptional.setMedico(request.getMedico());
        citaOptional.setPaciente(request.getPaciente());
        citaOptional.setFecha(request.getFecha());

        return citaRepository.save(citaOptional);

    }

    public boolean deleteCita(long id) {
        try {
            citaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
