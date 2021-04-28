package com.example.springtemplate.daos;
import com.example.springtemplate.models.UserToProject;
import com.example.springtemplate.repositories.UserToProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserToProjectOrmDao {
    @Autowired
    UserToProjectRepository utpRepository;

//    @GetMapping("/orm/mapping/create/{user}/{project}/{role}")
//    public UserToProject createMapping(
//      @PathVariable("user") int user,
//      @PathVariable("project") int project,
//      @PathVariable("role") String role) {
//        UserToProject utp = new UserToProject(user, project, role);
//        return utpRepository.save(utp);
//    }

    @PostMapping("/orm/mapping/create")
    public UserToProject createMapping(@RequestBody UserToProject utp) {
        return utpRepository.save(utp);
    }
    
    @GetMapping("/orm/mapping/find")
    public List<UserToProject> findAllMappings() {
        return utpRepository.findAllMaps();
    }

//    @GetMapping("/orm/mapping/find/{userId}")
//    public List<UserToProject> findUserById(
//      @PathVariable("userId") Integer id) {
//        return utpRepository.findMapByUserId(id);
//    }

    @GetMapping("/orm/mapping/find/{id}")
    public UserToProject findMapById(
      @PathVariable("id") Integer id) {
        return utpRepository.findMapById(id);
    }


    @PutMapping("/orm/mapping/update/{mappingId}")
    public UserToProject updateMapping(
      @PathVariable("mappingId") Integer id,
      @RequestBody UserToProject mappingUpdates) {
        UserToProject utp = utpRepository.findMapById(id);
        utp.setUserId(mappingUpdates.getUserId());
        utp.setProjectId(mappingUpdates.getProjectId());
        utp.setRole(mappingUpdates.getRole());
        return utpRepository.save(utp);
    }

    @DeleteMapping("/orm/mapping/delete/{utpId}")
    public void deleteMapping(
      @PathVariable("utpId") Integer id) {
        utpRepository.deleteById(id);
    }
}