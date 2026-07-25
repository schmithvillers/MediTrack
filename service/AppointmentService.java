package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.enums.AppointmentStatus;
import com.airtribe.meditrack.util.DataStore;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private final DataStore<Appointment> appointmentStore;

    public AppointmentService() {
        appointmentStore = new DataStore<>();
    }

    public void bookAppointment(Appointment appointment) {
        appointmentStore.add(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentStore.getAll();
    }

    public Appointment getAppointmentById(int id) {

        for (Appointment appointment : appointmentStore.getAll()) {

            if (appointment.getId() == id) {
                return appointment;
            }
        }

        return null;
    }

    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointmentStore.getAll()) {

            if (appointment.getDoctor().equals(doctor)) {
                result.add(appointment);
            }
        }

        return result;
    }

    public List<Appointment> getAppointmentsByPatient(Patient patient) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointmentStore.getAll()) {

            if (appointment.getPatient().equals(patient)) {
                result.add(appointment);
            }
        }

        return result;
    }

    public boolean cancelAppointment(int id) {

        Appointment appointment = getAppointmentById(id);

        if (appointment == null) {
            return false;
        }

        appointment.setStatus(AppointmentStatus.CANCELLED);
        return true;
    }
}