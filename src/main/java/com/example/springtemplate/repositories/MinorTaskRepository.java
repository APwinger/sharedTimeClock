package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Minor_Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MinorTaskRepository
        extends CrudRepository<Minor_Task, Integer> {
  @Query(value = "SELECT * FROM minor_tasks",
    nativeQuery = true)
  public List<Minor_Task> findAllMinorTasks();

  @Query(value = "SELECT * FROM minor_tasks WHERE id=:id",
    nativeQuery = true)
  public Minor_Task findMinorTaskById(@Param("id") Integer id);

}
