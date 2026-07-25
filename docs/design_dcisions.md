# Design Decisions

## Project Structure

The project follows a layered architecture.

- entity
- service
- util
- constants

This separates business logic from data models.

---

## Generic DataStore

A generic DataStore<T> is used to avoid duplicate CRUD logic and demonstrate Java Generics.

---

## Singleton

HospitalManager uses the Singleton pattern to ensure only one instance of all services exists throughout the application.

---

## Factory

PersonFactory centralizes object creation for Doctor and Patient objects.

---

## CSV Persistence

CSV files are used for lightweight data persistence without requiring an external database.

---

## Billing

Billing is separated into BillingService to keep business logic independent of entity classes.

---

## OOP Principles Used

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Composition
- Generics
- Enums
- File I/O