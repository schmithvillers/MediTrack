package com.airtribe.meditrack.singleton;

import com.airtribe.meditrack.service.AppointmentService;
import com.airtribe.meditrack.service.BillingService;
import com.airtribe.meditrack.service.DoctorService;
import com.airtribe.meditrack.service.PatientService;

public class HospitalManager {

    private static HospitalManager instance;

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentService appointmentService;
    private final BillingService billingService;

    private HospitalManager() {
        doctorService = new DoctorService();
        patientService = new PatientService();
        appointmentService = new AppointmentService();
        billingService = new BillingService();
    }

    public static HospitalManager getInstance() {

        if (instance == null) {
            instance = new HospitalManager();
        }

        return instance;
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public PatientService getPatientService() {
        return patientService;
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public BillingService getBillingService() {
        return billingService;
    }
}