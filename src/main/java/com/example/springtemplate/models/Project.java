package com.example.springtemplate.models;
import javax.persistence.*;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String description;


    public int getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescription() { return this.description; }
    public void setDescription(String desc) { this.description = desc;}


    public Project(String desc) {
    this.description = desc;
    }

    public Project() {}
}
