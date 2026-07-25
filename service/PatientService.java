package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.util.CSVUtil;

import java.util.ArrayList;

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

    public void savePatients() {

        List<String> lines = new ArrayList<>();

        for (Patient patient : patientStore.getAll()) {

            String record =
                    patient.getId() + "," +
                    patient.getName() + "," +
                    patient.getAge() + "," +
                    patient.getGender() + "," +
                    patient.getPhone() + "," +
                    patient.getEmail() + "," +
                    patient.getBloodGroup() + "," +
                    patient.getAddress() + "," +
                    patient.getMedicalHistory();

            lines.add(record);
        }

        CSVUtil.writeLines(Constants.PATIENT_FILE, lines);
    }
    public void loadPatients() {
        List<String> lines =
                CSVUtil.readLines(Constants.PATIENT_FILE);

        patientStore.getAll().clear();

        for (String line : lines) {

            String[] data = line.split(",");

            Patient patient = new Patient(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3],
                    data[4],
                    data[5],
                    data[6],
                    data[7],
                    data[8]
            );

            patientStore.add(patient);
        }
    }
}