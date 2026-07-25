package com.airtribe.meditrack.entity;

import java.time.LocalDateTime;

public abstract class MedicalEntity {

    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MedicalEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }
}