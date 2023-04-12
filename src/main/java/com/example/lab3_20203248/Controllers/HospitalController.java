package com.example.lab3_20203248.Controllers;

import com.example.lab3_20203248.Entities.Doctor;
import com.example.lab3_20203248.Entities.Hospital;
import com.example.lab3_20203248.Repositories.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HospitalController {
    final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping(value = {"", "/", "index"})
    public String indexHospital(Model model){
        List<Hospital> hospitalList = hospitalRepository.findAll();
        model.addAttribute("hospitalList", hospitalList);
        return "indexHospital";
    }

    @GetMapping("/MostrarDoctores")
    public String mostrarDoctores(@RequestParam(name = "id") int id,
                                  Model model){
        List<Doctor> doctorList = hospitalRepository.mostrarDoctores(id);
        model.addAttribute("doctorList", doctorList);
        return "mostrarDoctores";
    }

    @GetMapping("/MostrarPacientes")
    public String mostrarPacientes(@RequestParam(name = "id") int id){
        return "";
    }
}
