package com.example.Crud.API.Spring.Boot.controller;

import com.example.Crud.API.Spring.Boot.model.Cita;
import com.example.Crud.API.Spring.Boot.model.Medico;
import com.example.Crud.API.Spring.Boot.services.CitaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Cita saveCita(@RequestBody Cita cita) {
        return this.citaService.saveCita(cita);
    }

    @GetMapping(path = "/{id}")
    public Optional<Cita> getCitaById(@PathVariable long id) {
        return this.citaService.getCitaById(id);
    }

    @PutMapping(path = "/{id}")
    public Cita updateCita(@RequestBody Cita request,@PathVariable("id") Long id) {
        return this.citaService.updateCita(request,id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCita(@PathVariable("id") long id) {
        boolean ok = this.citaService.deleteCita(id);
        if(ok){
            return "Cita con id " + id + " eliminada";
        }else {
            return "Error al eliminar la cita";
        }

    }
}
