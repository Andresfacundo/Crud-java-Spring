package com.example.Crud.API.Spring.Boot.controller;

import com.example.Crud.API.Spring.Boot.model.Cita;
import com.example.Crud.API.Spring.Boot.model.Medico;
import com.example.Crud.API.Spring.Boot.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/citas")

public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ArrayList<Cita> getAllCitas() {
        return this.citaService.getAllCitas();
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return this.citaService.createCita(cita);
    }

    @GetMapping(path = "/{id}")
    public Optional<Cita> getCitaById(@PathVariable long id) {
        return this.citaService.getCitaById(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateCita(@RequestBody Cita request, @PathVariable("id") Long id) {
        Optional<Cita> existingCita = this.citaService.getCitaById(id);
        if (existingCita.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cita updatedCita = this.citaService.updateCita(request, id);
        return ResponseEntity.ok(updatedCita);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCita(@PathVariable("id") long id) {
        if (!citaService.getCitaById(id).isPresent()) {
            return ("No se puede eliminar la cita con id " + id);
        } else {
            boolean notFound = this.citaService.deleteCita(id);

            if (notFound) {
                return "Cita con id " + id + " eliminada";
            } else {
                return "Error al eliminar la cita";
            }
        }
    }
}
