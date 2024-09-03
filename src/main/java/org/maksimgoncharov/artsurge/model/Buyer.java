package org.maksimgoncharov.artsurge.model;

import jakarta.persistence.*;


// Entity annotation to mark this class as a JPA entity
@Entity
// Table annotation to specify the database table name
@Table(name = "buyers")
public class Buyer {

    // Primary key of the entity
    @Id
    // Specifies that the ID should be automatically generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column for first name, marked as non-nullable
    @Column(name = "first_name", nullable = false)
    private String firstName;

    // Column for last name
    @Column(name = "last_name")
    private String lastName;

    // Column for email
    @Column(name = "email")
    private String email;

    // Default constructor
    public Buyer() {
    }

    // Parameterized constructor
    public Buyer(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}