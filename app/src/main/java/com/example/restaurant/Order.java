package com.example.restaurant;

public class Order {

    public enum Payment {CreditCard, Cash}

    private String name, surname, email, adress;
    private int phone_num;

    private Payment payment;

    public Order(String name, String surname, String email, String adress, int phone_num, Payment payment) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.adress = adress;
        this.phone_num = phone_num;
        this.payment = payment;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

