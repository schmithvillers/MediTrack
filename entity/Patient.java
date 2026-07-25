package com.airtribe.meditrack.entity;

public class Patient extends Person implements Cloneable {

    private String bloodGroup;
    private String address;
    private String medicalHistory;

    public Patient() {
        super();
    }

    public Patient(int id,
                   String name,
                   int age,
                   String gender,
                   String phone,
                   String email,
                   String bloodGroup,
                   String address,
                   String medicalHistory) {

        super(name, age, gender, phone, email);

        setId(id);

        this.bloodGroup = bloodGroup;
        this.address = address;
        this.medicalHistory = medicalHistory;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        updateTimestamp();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        updateTimestamp();
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
        updateTimestamp();
    }

    @Override
    public Patient clone() {
        try {
            return (Patient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}