package com.example.springtemplate.daos;

import com.example.springtemplate.models.Minor_Task;
import com.example.springtemplate.repositories.MinorTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MinorTaskOrmDao {
    @Autowired
    MinorTaskRepository minorTaskRepository;

    @GetMapping("/orm/create/minortask/{userId}/{projectId}/{description}")
    public Minor_Task createMinor_Task(
      @PathVariable("userId") Integer userId,
      @PathVariable("projectId") Integer projectId,
      @PathVariable("description") String description) {
        Minor_Task mt = new Minor_Task(userId,projectId,description);
        return minorTaskRepository.save(mt);
    }
    
    @GetMapping("/orm/find/minortasks")
    public List<Minor_Task> findAllMinor_Tasks() {
        return (List<Minor_Task>) minorTaskRepository.findAll();
    }
    
    @GetMapping("/orm/find/minortask/{Minor_TaskId}")
    public Minor_Task findMinor_TaskById(
            @PathVariable("Minor_TaskId") Integer id) {
        return minorTaskRepository.findById(id).get();
    }


    @GetMapping("/orm/update/minortask/{Minor_TaskId}/{userId}/{projectId}")
    public Minor_Task updateMinor_Task(
      @PathVariable("Minor_TaskId") Integer id,
      @PathVariable("userId") Integer userId,
      @PathVariable("projectId") Integer projectId) {
        Minor_Task minorTask = this.findMinor_TaskById(id);
        minorTask.setProject(projectId);
        minorTask.setUser(userId);
        return minorTaskRepository.save(minorTask);
    }

    @DeleteMapping("/orm/delete/minortask/{Minor_TaskId}")
    public void deleteMinor_Task(
            @PathVariable("Minor_TaskId") Integer id) {
        minorTaskRepository.deleteById(id);
    }
}