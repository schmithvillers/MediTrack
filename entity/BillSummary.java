package com.airtribe.meditrack.entity;

public class BillSummary {

    private String patientName;
    private String doctorName;
    private double totalAmount;

    public BillSummary(String patientName,
                       String doctorName,
                       double totalAmount) {

        this.patientName = patientName;
        this.doctorName = doctorName;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "BillSummary{" +
                "patient='" + patientName + '\'' +
                ", doctor='" + doctorName + '\'' +
                ", total=" + totalAmount +
                '}';
    }
}