package com.airtribe.meditrack.factory;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.Specialization;

public class PersonFactory {

    public static Doctor createDoctor(
            int id,
            String name,
            int age,
            String gender,
            String phone,
            String email,
            Specialization specialization,
            double consultationFee,
            int experience,
            boolean available) {

        return new Doctor(
                id,
                name,
                age,
                gender,
                phone,
                email,
                specialization,
                consultationFee,
                experience,
                available
        );
    }

    public static Patient createPatient(
            int id,
            String name,
            int age,
            String gender,
            String phone,
            String email,
            String bloodGroup,
            String address,
            String medicalHistory) {

        return new Patient(
                id,
                name,
                age,
                gender,
                phone,
                email,
                bloodGroup,
                address,
                medicalHistory
        );
    }
}