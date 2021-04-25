package com.example.springtemplate.models;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

@Entity
@Table(name="durations")
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
    private int timed_duration;
    //fk to minor task
    private int minor_task;


    public int getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public int getDuration() { return timed_duration; }
    public int getMinor_task() {return minor_task;}
    //im sorry idk whats happened to my capitalization but its happening.
    public void endDuration() {
        this.end_time = LocalDateTime.now();
        this.timed_duration = (int) SECONDS.between(this.start_time,this.end_time);
    }


    //creating a duration "starts" a duration
    public Duration(int minorTask) {
    this.minor_task = minorTask;
    this.start_time = LocalDateTime.now();
    }


    public Duration() {
        this.start_time = LocalDateTime.now();
    }
}
