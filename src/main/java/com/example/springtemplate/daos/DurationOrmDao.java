package com.example.springtemplate.daos;

import com.example.springtemplate.models.Duration;
import com.example.springtemplate.models.Minor_Task;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.DurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
public class DurationOrmDao {
    @Autowired
    DurationRepository durationRepository;

    @GetMapping("/orm/create/duration/{mtID}")
    public Duration startDuration(
      @PathVariable("mtID") int minorTaskID) {
        Duration duration = new Duration(minorTaskID);
        return durationRepository.save(duration);
    }

    @GetMapping("/orm/end/duration/{durationId}")
    public Duration endDuration(
      @PathVariable("durationId") Integer id) {
        Duration duration = durationRepository.findDurationById(id);
        duration.endDuration();
        return durationRepository.save(duration);
    }
    
    @GetMapping("/orm/find/durations")
    public List<Duration> findAllDurations() {
        return durationRepository.findAllDurations();
    }

    @GetMapping("/orm/find/durationsbymtid/{mtID}")
    public List<Duration> findDurationByMinorTaskId(@PathVariable("mtID") int minorTaskID) {
        return durationRepository.findDurationByMinorTaskId(minorTaskID);
    }

    @GetMapping("/orm/find/duration/{durationId}")
    public Duration findDurationById(
      @PathVariable("durationId") Integer id) {
        return durationRepository.findDurationById(id);
    }

    @DeleteMapping("/orm/users/{durationId}")
    public void deleteDuration(
      @PathVariable("durationId") Integer id) {
        durationRepository.deleteById(id);
    }
}