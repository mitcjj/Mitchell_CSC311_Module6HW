package org.example.mitchell_csc311_module6hw;

public class Form {
    private String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String zipCode;

    public Form(String firstName, String lastName, String email, String dob, String zipCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getZipCode() {
        return zipCode;
    }
}
