package org.maksimgoncharov.artsurge.model;
import jakarta.persistence.*;
import java.util.Collection;

// This annotation marks this class as a JPA entity (persistent object)
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    // This field is the primary identifier (ID) for the User entity.
    // It's automatically generated using GenerationType.AUTO strategy.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // These fields represent the user's personal information.
    private String firstName;
    private String lastName;

    // This field represents the user's email address. The @UniqueConstraint annotation
    // ensures that no two users can have the same email address.
    private String email;

    // This field stores the user's password. It's recommended to NOT store passwords in plain text,
    // but rather use a secure hashing algorithm. We've redacted the actual value returned by
    // getPassword() for demonstration purposes.
    private String password;

    // This field represents the user's roles. It's a collection of Role objects (many-to-many relationship).
    // The @ManyToMany annotation defines this relationship and the @JoinTable specifies the join table
    // used to link Users and Roles.
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles", // Name of the join table
            joinColumns = @JoinColumn( // Defines the column in the join table referencing the User entity
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn( // Defines the column in the join table referencing the Role entity
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private Collection<Role> roles;

    // Empty constructor
    public User() {}

    // Constructor with basic user information
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

    // Constructor with all user information including roles
    public User (String firstName, String lastName, String email, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Collection<Role> getRoles() {
        return roles;
    }


    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }
}
