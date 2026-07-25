package com.airtribe.meditrack.entity;

public class Bill extends MedicalEntity {

    private Appointment appointment;
    private double consultationFee;
    private double gst;
    private double totalAmount;

    public Bill() {
        super();
    }

    public Bill(int id,
                Appointment appointment,
                double consultationFee,
                double gst,
                double totalAmount) {

        super();

        setId(id);

        this.appointment = appointment;
        this.consultationFee = consultationFee;
        this.gst = gst;
        this.totalAmount = totalAmount;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public double getGst() {
        return gst;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + getId() +
                ", patient=" + appointment.getPatient().getName() +
                ", doctor=" + appointment.getDoctor().getName() +
                ", consultationFee=" + consultationFee +
                ", gst=" + gst +
                ", totalAmount=" + totalAmount +
                '}';
    }
}