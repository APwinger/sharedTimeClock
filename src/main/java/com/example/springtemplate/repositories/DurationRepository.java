package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Duration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DurationRepository
        extends CrudRepository<Duration, Integer> {
    @Query(value = "SELECT * FROM durations",
            nativeQuery = true)
    public List<Duration> findAllDurations();
    @Query(value = "SELECT * FROM durations WHERE id=:mtID",
      nativeQuery = true)
    public List<Duration> findDurationByMinorTaskId(@Param("mtID") Integer id);
    @Query(value = "SELECT * FROM durations WHERE id=:id",
      nativeQuery = true)
    public Duration findDurationById(@Param("id") Integer id);
}
