package com.allegiancemd.controller;

import com.allegiancemd.entity.Patient;
import com.allegiancemd.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PatientController {
    private final PatientService patientService;

    @GetMapping(value = "patients")
    public ResponseEntity<List<Patient>> getPatients(){
        final List<Patient> patients = patientService.getPatients();
        return ResponseEntity.status((HttpStatus.OK)).body(patients);
    }
}
