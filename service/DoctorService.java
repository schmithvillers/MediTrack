package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;

public class DoctorService {

    private final DataStore<Doctor> doctorStore;

    public DoctorService() {
        doctorStore = new DataStore<>();
    }

    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    public Doctor getDoctorById(int id) {

        for (Doctor doctor : doctorStore.getAll()) {

            if (doctor.getId() == id) {
                return doctor;
            }
        }

        return null;
    }

    public boolean deleteDoctor(int id) {

        Doctor doctor = getDoctorById(id);

        if (doctor == null) {
            return false;
        }

        doctorStore.remove(doctor);
        return true;
    }
}