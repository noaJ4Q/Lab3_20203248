package com.example.lab3_20203248.Repositories;

import com.example.lab3_20203248.Entities.Doctor;
import com.example.lab3_20203248.Entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    @Query(nativeQuery = true, value = "select doctor.id, doctor.nombre, doctor.especialidad, doctor.hospital_id from doctor inner join hospital on (doctor.hospital_id = hospital.id) where hospital.id = ?1;")
    List<Doctor> mostrarDoctores (int id);
}
