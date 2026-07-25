package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment extends MedicalEntity {

    private Doctor doctor;
    private Patient patient;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private AppointmentStatus status;

    public Appointment() {
        super();
    }

    public Appointment(int id,
                       Doctor doctor,
                       Patient patient,
                       LocalDate appointmentDate,
                       LocalTime appointmentTime) {

        super();

        setId(id);

        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
        updateTimestamp();
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + getId() +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", date=" + appointmentDate +
                ", time=" + appointmentTime +
                ", status=" + status +
                '}';
    }
}