package com.example.testeruts1;

import java.io.Serializable;

public class BookingData implements Serializable {
    private String name;
    private String email;
    private String phone;
    private String destination;
    private String date;
    private String gender;
    private String facilities;
    private int ticketCount;
    private double totalPrice;

    public BookingData(String name, String email, String phone, String destination,
                       String date, String gender, String facilities, int ticketCount, double totalPrice) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.destination = destination;
        this.date = date;
        this.gender = gender;
        this.facilities = facilities;
        this.ticketCount = ticketCount;
        this.totalPrice = totalPrice;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public String getGender() { return gender; }
    public String getFacilities() { return facilities; }
    public int getTicketCount() { return ticketCount; }
    public double getTotalPrice() { return totalPrice; }
}
