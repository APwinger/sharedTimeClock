package com.example.springtemplate.models;

import javax.persistence.*;

@Entity
@Table(name="durations")
public class duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String start_time;
    private String end_time;
    private int timed_duration;


    public int getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public int getDuration() { return timed_duration; }
    public void increaseDuration(int time) { this.timed_duration = timed_duration + time;}


    public durations(String firstName, String lastName, String username, String password, String email) {

    }

    public durations() {}
}
