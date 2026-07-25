package com.airtribe.meditrack.service;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.BillSummary;

public class BillingService {

    public Bill generateBill(int billId, Appointment appointment) {

        double consultationFee =
                appointment.getDoctor().getConsultationFee();

        double gst =
                consultationFee * Constants.GST;

        double total =
                consultationFee + gst;

        return new Bill(
                billId,
                appointment,
                consultationFee,
                gst,
                total
        );
    }

    public BillSummary generateSummary(Bill bill) {

        return new BillSummary(
                bill.getAppointment().getPatient().getName(),
                bill.getAppointment().getDoctor().getName(),
                bill.getTotalAmount()
        );
    }
}