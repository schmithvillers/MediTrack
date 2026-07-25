package com.airtribe.meditrack.entity;

public abstract class Person extends MedicalEntity {

    private String name;
    private int age;
    private String gender;
    private String phone;
    private String email;

    public Person() {
        super();
    }

    public Person(String name,
                  int age,
                  String gender,
                  String phone,
                  String email) {

        super();

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateTimestamp();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        updateTimestamp();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        updateTimestamp();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        updateTimestamp();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        updateTimestamp();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}