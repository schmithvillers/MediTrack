Architecture:
                MedicalEntity (abstract)
                        ▲
                        │
                 Person (abstract)
                 ▲              ▲
                 │              │
             Doctor         Patient

Appointment
    │
    ├────────► Doctor
    │
    └────────► Patient

Bill
    │
    └────────► Appointment

BillSummary (Immutable)