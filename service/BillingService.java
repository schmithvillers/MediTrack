package com.airtribe.meditrack.service;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.entity.Bill;
import com.airtribe.meditrack.entity.BillSummary;
import java.util.ArrayList;
import java.util.List;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.DataStore;

public class BillingService {

    public Bill generateBill(int billId, Appointment appointment) {

        double consultationFee =
                appointment.getDoctor().getConsultationFee();

        double gst =
                consultationFee * Constants.GST;

        double total =
                consultationFee + gst;
        Bill bill = new Bill(
                billId,
                appointment,
                consultationFee,
                gst,
                total
        );

        billStore.add(bill);

        return bill;
    }

    public BillSummary generateSummary(Bill bill) {

        return new BillSummary(
                bill.getAppointment().getPatient().getName(),
                bill.getAppointment().getDoctor().getName(),
                bill.getTotalAmount()
        );
    }
    private final DataStore<Bill> billStore;
    public BillingService() {
        billStore = new DataStore<>();
    }
    public void saveBills() {

        List<String> lines = new ArrayList<>();

        for (Bill bill : billStore.getAll()) {

                String record =
                        bill.getId() + "," +
                        bill.getAppointment().getId() + "," +
                        bill.getConsultationFee() + "," +
                        bill.getGst() + "," +
                        bill.getTotalAmount();

                lines.add(record);
        }

        CSVUtil.writeLines(Constants.BILL_FILE, lines);
    }
    public void loadBills(AppointmentService appointmentService) {

        List<String> lines = CSVUtil.readLines(Constants.BILL_FILE);

        billStore.getAll().clear();

        for (String line : lines) {

                String[] data = line.split(",");

                Appointment appointment =
                        appointmentService.getAppointmentById(
                                Integer.parseInt(data[1]));

                Bill bill = new Bill(
                        Integer.parseInt(data[0]),
                        appointment,
                        Double.parseDouble(data[2]),
                        Double.parseDouble(data[3]),
                        Double.parseDouble(data[4])
                );

                billStore.add(bill);
        }
    }
    public List<Bill> getAllBills() {
        return billStore.getAll();
    }
}