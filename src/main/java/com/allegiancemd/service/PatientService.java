package com.allegiancemd.service;

import com.allegiancemd.config.DatabaseContextHolder;
import com.allegiancemd.entity.Patient;
import com.allegiancemd.repo.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getPatients() {
        final List<Patient> patients = patientRepository.findAll();
        DatabaseContextHolder.clearDatabaseContext();
        return patients;
    }
}
