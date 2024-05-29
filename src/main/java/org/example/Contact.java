package org.example;

public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;

    public Contact(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return getFullName() + " | " + getPhoneNumber() + " | " + getEmail();
    }

    public String toFileFormat() {
        return fullName + ";" + phoneNumber + ";" + email;
    }
}
