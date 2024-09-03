/**
 This package contains model classes for the Artsurge application.
 Model classes represent the data entities of the application. They are typically mapped to database tables
 using JPA annotations. */

package org.maksimgoncharov.artsurge.model;
import jakarta.persistence.*;

/**

 The Role class represents a user role in the Artsurge application.

 A role defines the permissions a user has within the application. For example, there might be an "ADMIN" role

 that grants users administrative privileges, and a "USER" role for regular users.

 This class is annotated with @Entity to indicate that it is a JPA entity class.
 */

// Entity annotation to mark this class as a JPA entity
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
//       return "Role{" +
//               "id=" + id +
//               ", name='" + name + ''' +
//               '}';
    }
}