package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.Specialization;

public class Doctor extends Person {

    private Specialization specialization;
    private double consultationFee;
    private int experience;
    private boolean available;

    public Doctor() {
        super();
    }

    public Doctor(int id,
                  String name,
                  int age,
                  String gender,
                  String phone,
                  String email,
                  Specialization specialization,
                  double consultationFee,
                  int experience,
                  boolean available) {

        super(name, age, gender, phone, email);

        setId(id);

        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.experience = experience;
        this.available = available;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
        updateTimestamp();
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
        updateTimestamp();
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
        updateTimestamp();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        updateTimestamp();
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", specialization=" + specialization +
                ", fee=" + consultationFee +
                ", experience=" + experience +
                ", available=" + available +
                '}';
    }
}