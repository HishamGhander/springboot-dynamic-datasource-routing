package com.allegiancemd.service;

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
        return patientRepository.findAll();
    }
}
