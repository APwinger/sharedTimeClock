package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserOrmDao {
    @Autowired
    UserRepository userRepository;

//    @GetMapping("/orm/user/create/{fn}/{ln}/{un}/{pw}")
//    public User createUser(
//      @PathVariable("fn") String first,
//      @PathVariable("ln") String last,
//      @PathVariable("un") String uname,
//      @PathVariable("pw") String pass) {
//        User user = new User(first, last, uname, pass, null);
//        return userRepository.save(user);
//    }

    @PostMapping("/orm/user/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping("/orm/user/find")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @GetMapping("/orm/user/find/{userId}")
    public User findUserById(
      @PathVariable("userId") Integer id) {
        return userRepository.findUserById(id);
    }

    @GetMapping("/orm/user/update/{userId}/{password}")
    public User updateUser(
      @PathVariable("userId") Integer id,
      @PathVariable("password") String newPass) {
        User user = userRepository.findUserById(id);
        user.setPassword(newPass);
        return userRepository.save(user);
    }


    @DeleteMapping("/orm/user/delete/{userId}")
    public void deleteUser(
      @PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }
}