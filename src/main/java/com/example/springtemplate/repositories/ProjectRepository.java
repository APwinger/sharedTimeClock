package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository
        extends CrudRepository<Project, Integer> {
  @Query(value = "SELECT * FROM projects",
    nativeQuery = true)
  public List<Project> findAllProjects();

  @Query(value = "SELECT * FROM projects WHERE id=:id",
    nativeQuery = true)
  public Project findProjectById(@Param("id") Integer id);

}
