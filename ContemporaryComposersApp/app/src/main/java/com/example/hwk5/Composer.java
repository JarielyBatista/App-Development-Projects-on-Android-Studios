package com.example.hwk5;

public class Composer {
    private String firstName;
    private String lastName;
    private String photo;
    private int yearOfBirth;
    private int yearOfDeath;
    private String country;

    public Composer(String firstName, String lastName, String photo, int yearOfBirth, int yearOfDeath, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.yearOfBirth = yearOfBirth;
        this.yearOfDeath = yearOfDeath;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public String getCountry() {
        return country;
    }
}
