package com.example.mvc_boot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;


@Entity
@Table(name = "users")
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    @NotEmpty
    @Size(min = 2, max = 20, message = "Firstname should be in range of 2 and 20 symbols")
    private String firstName;

    @Column(name = "lastName")
    @NotEmpty
    @Size(min = 1, max = 25, message = "Secondname should be in range of 1 and 25 symbols")
    private String lastName;

    @Column(name = "gender")
    @NotEmpty
    private String gender;

    @Column(name = "nationality")
    @NotEmpty
    @Size(min = 3, max = 20, message = "Nationality should be in range of 3 and 20 symbols")
    private String nationality;


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public User() {

    }

    public User(Long id, String firstName, String lastName, String gender, String nationality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
