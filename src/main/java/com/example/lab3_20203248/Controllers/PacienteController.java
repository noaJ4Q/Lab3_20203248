package com.example.lab3_20203248.Controllers;

import com.example.lab3_20203248.Entities.Paciente;
import com.example.lab3_20203248.Repositories.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Pacientes")
public class PacienteController {
    final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping(value = {"", "/", "index"})
    public String indexPaciente(Model model){
        List<Paciente> pacienteList = pacienteRepository.findAll();
        model.addAttribute("pacienteList", pacienteList);
        return "indexPaciente";
    }
}
