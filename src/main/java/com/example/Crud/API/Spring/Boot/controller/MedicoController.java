package com.example.Crud.API.Spring.Boot.controller;


import com.example.Crud.API.Spring.Boot.model.Medico;
import com.example.Crud.API.Spring.Boot.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ArrayList<Medico> getAllMedicos() {
        return this.medicoService.getAllMedicos();
    }

    @PostMapping
    public Medico saveMedico(@RequestBody Medico medico) {
        return this.medicoService.saveMedico(medico);
    }

    @GetMapping(path = "/{id}")
    public Optional<Medico> getMedicoById(@PathVariable Long id) {
        return this.medicoService.getMedicoById(id);
    }

    @PutMapping(path = "/{id}")
    public Medico updateMedico( @RequestBody Medico request, @PathVariable("id") Long id) {
        return this.medicoService.updateMedico(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteMedico(@PathVariable("id") Long id) {
        boolean ok = this.medicoService.deleteMedico(id);
        if (ok){
            return "Medico con id " + id + " eliminado";
        }else{
            return "Error al eliminar el Medico";
        }
    }




}
