package com.example.springtemplate.repositories;

import com.example.springtemplate.models.UserToProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserToProjectRepository
        extends CrudRepository<UserToProject, Integer> {
    @Query(value = "SELECT * FROM users_to_projects",
            nativeQuery = true)
    public List<UserToProject> findAllMaps();

    @Query(value = "SELECT * FROM users_to_projects WHERE id=:id",
      nativeQuery = true)
    public UserToProject findMapById(@Param("id") Integer id);

}

