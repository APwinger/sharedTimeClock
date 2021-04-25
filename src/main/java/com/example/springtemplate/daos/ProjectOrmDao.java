package com.example.springtemplate.daos;

import com.example.springtemplate.models.Project;
import com.example.springtemplate.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProjectOrmDao {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/orm/create/project/{description}")
    public Project createProject(
      @PathVariable("description") String description) {
        Project project = new Project(description);
        return projectRepository.save(project);
    }
    
    @GetMapping("/orm/find/projects")
    public List<Project> findAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }
    
    @GetMapping("/orm/find/project/{projectId}")
    public Project findProjectById(
            @PathVariable("projectId") Integer id) {
        return projectRepository.findById(id).get();
    }

    @GetMapping("/orm/update/project/{projectId}/{description}")
    public Project updateProject(
      @PathVariable("projectId") Integer id,
      @PathVariable("description") String desc) {
        Project project = this.findProjectById(id);
        project.setDescription(desc);
        return projectRepository.save(project);
    }

    @DeleteMapping("/orm/delete/minortask/{ProjectId}")
    public void deleteProject(
            @PathVariable("ProjectId") Integer id) {
        projectRepository.deleteById(id);
    }
}