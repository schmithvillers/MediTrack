# 🏥 MediTrack - Clinic & Appointment Management System

MediTrack is a modular **Core Java** application developed to manage a clinic's day-to-day operations, including doctor and patient management, appointment scheduling, billing, and CSV-based data persistence.

The project demonstrates fundamental and intermediate Java concepts such as Object-Oriented Programming (OOP), Generics, File Handling, Design Patterns, and Collections.

---

# 📌 Project Overview

MediTrack simulates a simple clinic management system where users can:

- Manage doctors
- Manage patients
- Book appointments
- Cancel appointments
- Generate bills
- Save and load records using CSV files

The project follows a layered architecture by separating entities, business logic, utilities, constants, and design pattern implementations into different packages.

---

# ✨ Features

## Doctor Management

- Add Doctor
- View All Doctors
- Search Doctor by ID
- Delete Doctor

## Patient Management

- Add Patient
- View All Patients
- Search Patient by ID
- Delete Patient

## Appointment Management

- Book Appointment
- View All Appointments
- Cancel Appointment
- Appointment Status using Enum

## Billing

- Generate Bill
- Calculate GST
- Generate Bill Summary

## File Persistence

- Save Doctors to CSV
- Save Patients to CSV
- Save Bills to CSV
- Load Doctors from CSV
- Load Patients from CSV

---

# 🏗 Project Structure

```
MediTrack
│
├── com
│   └── airtribe
│       └── meditrack
│
│           ├── constants
│           │     └── Constants.java
│           │
│           ├── entity
│           │     ├── MedicalEntity.java
│           │     ├── Person.java
│           │     ├── Doctor.java
│           │     ├── Patient.java
│           │     ├── Appointment.java
│           │     ├── Bill.java
│           │     └── BillSummary.java
│           │
│           ├── enums
│           │     ├── AppointmentStatus.java
│           │     └── Specialization.java
│           │
│           ├── exception
│           │
│           ├── factory
│           │
│           ├── interfaces
│           │
│           ├── observer
│           │
│           ├── service
│           │     ├── DoctorService.java
│           │     ├── PatientService.java
│           │     ├── AppointmentService.java
│           │     └── BillingService.java
│           │
│           ├── singleton
│           │     └── HospitalManager.java
│           │
│           ├── strategy
│           │
│           ├── thread
│           │
│           ├── util
│           │     ├── CSVUtil.java
│           │     └── DataStore.java
│           │
│           └── Main.java
│
├── data
│     ├── doctors.csv
│     ├── patients.csv
│     ├── appointments.csv
│     └── bills.csv
│
├── docs
│
└── README.md
```

---

# 💻 Technologies Used

- Java 17
- Object-Oriented Programming
- Java Collections Framework
- Java Generics
- Java Enums
- File I/O
- CSV Parsing
- Git & GitHub

---

# 🧱 OOP Concepts Demonstrated

### Encapsulation

- Private fields
- Getters and Setters

### Inheritance

```
MedicalEntity
        ▲
        │
     Person
     ▲     ▲
 Doctor  Patient
```

### Abstraction

- Abstract `MedicalEntity`
- Abstract `Person`

### Polymorphism

- Method Overriding
- Constructor Overloading

### Composition

Examples:

- Appointment has a Doctor
- Appointment has a Patient
- Bill has an Appointment

---

# 📦 Java Concepts Used

- Classes & Objects
- Constructors
- Packages
- Access Modifiers
- Enums
- Generics
- Collections
- ArrayList
- Static Members
- Exception Handling
- File Handling
- Try-With-Resources

---

# 🎯 Design Patterns

## Singleton Pattern

`HospitalManager`

Ensures only one instance of the application's services exists.

---

## Factory Pattern

`PersonFactory`

Responsible for creating Doctor and Patient objects.

---

# 📂 Data Storage

Application data is stored in CSV files located inside the **data/** folder.

```
doctors.csv
patients.csv
appointments.csv
bills.csv
```

This allows records to persist between executions.

---

# 🚀 How to Run

## Clone Repository

```bash
git clone https://github.com/schmithvillers/MediTrack.git
```

---

## Navigate to Project

```bash
cd MediTrack
```

---

## Compile

```bash
javac com/airtribe/meditrack/**/*.java
```

---

## Run

```bash
java com.airtribe.meditrack.Main
```

---

# 📷 Screenshots

## Application Output

> Add screenshots of your console output here.

Example:

```
========================================
      Welcome to MediTrack System
========================================

----------- Doctors -----------

Doctor{id=1, name='Dr. Sharma', ...}

Doctor{id=2, name='Dr. Mehta', ...}

----------- Patients -----------

Patient{id=101, name='Rahul Verma', ...}

----------- Appointments -----------

Appointment{id=1001, status=SCHEDULED}

----------- Bill -----------

Bill{id=5001, total=1180.0}

Data saved successfully.

========================================
 MediTrack Demo Completed Successfully
========================================
```

---

# 📖 Future Enhancements

The following features can be added in future versions:

- Menu-driven console interface
- Java Streams & Lambdas
- Custom Exceptions
- Observer Pattern
- Strategy Pattern
- Appointment Notifications
- Multithreading
- Database (MySQL/PostgreSQL) Integration
- REST API using Spring Boot

---

# 👩‍💻 Author

**Bhumika Sharma**

GitHub: https://github.com/schmithvillers

---

# 📄 License

This project was developed for educational purposes as part of a **Core Java learning project**.