package com.example.springtemplate.daos;

import com.example.springtemplate.models.UserToProject;
import com.example.springtemplate.repositories.UserToProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class UserToProjectOrmDao {
    @Autowired
    UserToProjectRepository utpRepository;

    @GetMapping("/orm/create/usertoproject/{user}/{project}/{role}")
    public UserToProject createMapping(
      @PathVariable("user") int user,
      @PathVariable("project") int project,
      @PathVariable("role") String role) {
        UserToProject utp = new UserToProject(user, project, role);
        return utpRepository.save(utp);
    }
    
    @GetMapping("/orm/find/usertoprojects")
    public List<UserToProject> findAllMappings() {
        return utpRepository.findAllMaps();
    }

    @GetMapping("/orm/find/usertoproject/{userId}")
    public List<UserToProject> findUserById(
      @PathVariable("userId") Integer id) {
        return utpRepository.findMapByUserId(id);
    }

    @GetMapping("/orm/update/usertoproject/{mapId}/{userId}/{projectId}/{role}")
    public UserToProject updateMapping(
      @PathVariable("userId") Integer id,
      @PathVariable("userId") Integer userId,
      @PathVariable("projectId") Integer projectId,
      @PathVariable("role") String role) {
        UserToProject upt = utpRepository.findMapById(id);
        upt.setUserId(userId);
        upt.setProjectId(projectId);
        upt.setRole(role);
        return utpRepository.save(upt);
    }


    @DeleteMapping("/orm/delete/{utpId}")
    public void deleteMapping(
      @PathVariable("utpId") Integer id) {
        utpRepository.deleteById(id);
    }
}