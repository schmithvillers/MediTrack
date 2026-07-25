package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class PatientService {

    private final DataStore<Patient> patientStore;

    public PatientService() {
        patientStore = new DataStore<>();
    }

    public void addPatient(Patient patient) {
        patientStore.add(patient);
    }

    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    public Patient getPatientById(int id) {

        for (Patient patient : patientStore.getAll()) {

            if (patient.getId() == id) {
                return patient;
            }
        }

        return null;
    }

    public boolean deletePatient(int id) {

        Patient patient = getPatientById(id);

        if (patient == null) {
            return false;
        }

        patientStore.remove(patient);
        return true;
    }
}