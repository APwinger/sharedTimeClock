package com.example.springtemplate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role_levels")
public class RoleLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String level;


    public String getLevel() { return level; }


    public RoleLevel() {

    }
}
