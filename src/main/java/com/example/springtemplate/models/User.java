package com.example.springtemplate.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String dateOfBirth;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() { return firstname; }
    public void setFirstName(String firstName) { this.firstname = firstName; }
    public String getLastName() { return lastname; }
    public void setLastName(String lastName) { this.lastname = lastName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDob() { return dateOfBirth; }
    public void setDob(String dob) { this.dateOfBirth = dob; }

    public User(String firstName, String lastName, String username, String password,  String email) {
        this.username = username;
        this.password = password;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
    }

    public User() {}
}
