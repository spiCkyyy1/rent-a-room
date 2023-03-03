package com.example.rentrooms.DataHandler;

public class BookingDetails {
    private String owner;
    private String contact;
    private String notes;

    public BookingDetails(String owner, String contact, String notes) {
        this.owner = owner;
        this.contact = contact;
        this.notes = notes;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
