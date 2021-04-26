package com.example.springtemplate.daos;

import com.example.springtemplate.models.Project;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProjectOrmDao {
    @Autowired
    ProjectRepository projectRepository;

    @PostMapping("/orm/project/create")
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }


    @GetMapping("/orm/project/find")
    public List<Project> findAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }
    
    @GetMapping("/orm/project/find/{projectId}")
    public Project findProjectById(
            @PathVariable("projectId") Integer id) {
        return projectRepository.findById(id).get();
    }

    @PutMapping("/orm/project/update/{projectId}")
    public Project updateProject(
      @PathVariable("projectId") Integer id,
      @RequestBody Project projectUpdates) {
        Project project = projectRepository.findProjectById(id);
        project.setDescription(projectUpdates.getDescription());
        return projectRepository.save(project);
    }

    @DeleteMapping("/orm/project/delete/{ProjectId}")
    public void deleteProject(
            @PathVariable("ProjectId") Integer id) {
        projectRepository.deleteById(id);
    }
}