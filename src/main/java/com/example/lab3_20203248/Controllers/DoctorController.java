package com.example.lab3_20203248.Controllers;

import com.example.lab3_20203248.Entities.Doctor;
import com.example.lab3_20203248.Repositories.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Doctores")
public class DoctorController {
    final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @GetMapping(value = {"", "/", "index"})
    public String indexDoctor(Model model){
        List<Doctor> doctorList = doctorRepository.findAll();
        model.addAttribute("doctorList", doctorList);
        return "indexDoctor";
    }
}
