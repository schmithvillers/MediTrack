package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.BillSummary;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.service.AppointmentService;
import com.airtribe.meditrack.service.BillingService;
import com.airtribe.meditrack.service.DoctorService;
import com.airtribe.meditrack.service.PatientService;
import com.airtribe.meditrack.singleton.HospitalManager;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("      Welcome to MediTrack System");
        System.out.println("========================================");

        // Get Singleton Instance
        HospitalManager manager = HospitalManager.getInstance();

        DoctorService doctorService = manager.getDoctorService();
        PatientService patientService = manager.getPatientService();
        AppointmentService appointmentService = manager.getAppointmentService();
        BillingService billingService = manager.getBillingService();

        // ===========================
        // Create Doctors
        // ===========================

        Doctor doctor1 = new Doctor(
                1,
                "Dr. Sharma",
                45,
                "Female",
                "9876543210",
                "sharma@hospital.com",
                Specialization.CARDIOLOGIST,
                1000,
                18,
                true
        );

        Doctor doctor2 = new Doctor(
                2,
                "Dr. Mehta",
                39,
                "Male",
                "9876543211",
                "mehta@hospital.com",
                Specialization.DERMATOLOGIST,
                800,
                12,
                true
        );

        doctorService.addDoctor(doctor1);
        doctorService.addDoctor(doctor2);

        // ===========================
        // Create Patients
        // ===========================

        Patient patient1 = new Patient(
                101,
                "Rahul Verma",
                25,
                "Male",
                "9123456789",
                "rahul@gmail.com",
                "O+",
                "Pune",
                "Diabetes"
        );

        Patient patient2 = new Patient(
                102,
                "Priya Singh",
                31,
                "Female",
                "9871234567",
                "priya@gmail.com",
                "A+",
                "Mumbai",
                "Hypertension"
        );

        patientService.addPatient(patient1);
        patientService.addPatient(patient2);

        // ===========================
        // Display Doctors
        // ===========================

        System.out.println("\n----------- Doctors -----------");

        for (Doctor doctor : doctorService.getAllDoctors()) {
            System.out.println(doctor);
        }

        // ===========================
        // Display Patients
        // ===========================

        System.out.println("\n----------- Patients -----------");

        for (Patient patient : patientService.getAllPatients()) {
            System.out.println(patient);
        }

        // ===========================
        // Search Doctor
        // ===========================

        System.out.println("\n----------- Search Doctor -----------");

        Doctor foundDoctor = doctorService.getDoctorById(1);

        if (foundDoctor != null) {
            System.out.println(foundDoctor);
        } else {
            System.out.println("Doctor not found.");
        }

        // ===========================
        // Search Patient
        // ===========================

        System.out.println("\n----------- Search Patient -----------");

        Patient foundPatient = patientService.getPatientById(102);

        if (foundPatient != null) {
            System.out.println(foundPatient);
        } else {
            System.out.println("Patient not found.");
        }

        // ===========================
        // Book Appointments
        // ===========================

        Appointment appointment1 = new Appointment(
                1001,
                doctor1,
                patient1,
                LocalDate.now(),
                LocalTime.of(10, 30)
        );

        Appointment appointment2 = new Appointment(
                1002,
                doctor2,
                patient2,
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 0)
        );

        appointmentService.bookAppointment(appointment1);
        appointmentService.bookAppointment(appointment2);

        System.out.println("\n----------- Appointments -----------");

        for (Appointment appointment : appointmentService.getAllAppointments()) {
            System.out.println(appointment);
        }

        // ===========================
        // Cancel Appointment
        // ===========================

        appointmentService.cancelAppointment(1002);

        System.out.println("\n----------- Appointments After Cancellation -----------");

        for (Appointment appointment : appointmentService.getAllAppointments()) {
            System.out.println(appointment);
        }

        // ===========================
        // Generate Bill
        // ===========================

        Bill bill = billingService.generateBill(5001, appointment1);

        System.out.println("\n----------- Bill -----------");
        System.out.println(bill);

        BillSummary summary = billingService.generateSummary(bill);

        System.out.println("\n----------- Bill Summary -----------");
        System.out.println(summary);

        // ===========================
        // Save Data
        // ===========================

        doctorService.saveDoctors();
        patientService.savePatients();
        billingService.saveBills();

        System.out.println("\nData saved successfully.");

        // ===========================
        // Delete Patient
        // ===========================

        System.out.println("\nDeleting Patient with ID 101...");

        patientService.deletePatient(101);

        System.out.println("\n----------- Patients After Deletion -----------");

        for (Patient patient : patientService.getAllPatients()) {
            System.out.println(patient);
        }

        // ===========================
        // Reload Data (Optional Demo)
        // ===========================

        doctorService.loadDoctors();
        patientService.loadPatients();

        System.out.println("\n----------- Doctors Loaded From CSV -----------");

        for (Doctor doctor : doctorService.getAllDoctors()) {
            System.out.println(doctor);
        }

        System.out.println("\n----------- Patients Loaded From CSV -----------");

        for (Patient patient : patientService.getAllPatients()) {
            System.out.println(patient);
        }

        System.out.println("\n========================================");
        System.out.println(" MediTrack Demo Completed Successfully ");
        System.out.println("========================================");
    }
}