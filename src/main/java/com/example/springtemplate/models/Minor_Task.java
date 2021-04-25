package com.example.springtemplate.models;
import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

@Entity
@Table(name="minor_tasks")
public class Minor_Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String description;
    int user;
    int project;


    public int getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc;}
    public int getUser() {return this.user;}
    public void setUser(int userId) {this.user = userId;}
    public int getProject() {return this.project;}
    public void setProject(int projectId) {this.project = projectId;}


    public Minor_Task(int userId, int projectId, String desc) {
    this.user = userId;
    this.project = projectId;
    this.description = desc;
    }

    public Minor_Task() {}
}
