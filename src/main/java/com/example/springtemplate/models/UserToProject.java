package com.example.springtemplate.models;

import javax.persistence.*;

@Entity
@Table(name="users_to_projects")
public class UserToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int user;
    private int project;
    //can be
    //admin, employee, manager
    private String role;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getUserId() { return user; }
    public void setUserId(Integer id) { this.user = id; }
    public Integer getProjectId() { return project; }
    public void setProjectId(Integer id) { this.project = id; }
    public String getRole() { return this.role;}
    public void setRole(String role) { this.role = role;}



    public UserToProject(int userId, int projectId, String role) {
        this.user = userId;
        this.project = projectId;
        this.role = role;
    }

    public UserToProject() {}
}
