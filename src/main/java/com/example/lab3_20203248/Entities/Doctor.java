package com.example.lab3_20203248.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
