package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;
import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.util.CSVUtil;

import java.util.ArrayList;
import java.util.List;

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
    public void saveDoctors() {

        List<String> lines = new ArrayList<>();

        for (Doctor doctor : doctorStore.getAll()) {

            String record =
                    doctor.getId() + "," +
                    doctor.getName() + "," +
                    doctor.getAge() + "," +
                    doctor.getGender() + "," +
                    doctor.getPhone() + "," +
                    doctor.getEmail() + "," +
                    doctor.getSpecialization() + "," +
                    doctor.getConsultationFee() + "," +
                    doctor.getExperience() + "," +
                    doctor.isAvailable();

            lines.add(record);
        }

        CSVUtil.writeLines(Constants.DOCTOR_FILE, lines);
    }

    public void loadDoctors() {

        List<String> lines = CSVUtil.readLines(Constants.DOCTOR_FILE);

        doctorStore.getAll().clear();

        for (String line : lines) {

            String[] data = line.split(",");

            Doctor doctor = new Doctor(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3],
                    data[4],
                    data[5],
                    Specialization.valueOf(data[6]),
                    Double.parseDouble(data[7]),
                    Integer.parseInt(data[8]),
                    Boolean.parseBoolean(data[9])
            );

            doctorStore.add(doctor);
        }
    }
}