package com.DocDB.controller;

import com.DocDB.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUserById(@RequestParam(value = "id") Long id) {
        return service.getUserById(id);
    }

    @RequestMapping(value = "/userByEmail", method = RequestMethod.GET)
    public User getUserByEmail(@RequestParam(value = "email") String email) {
        return service.findByEmail(email);
    }

    @RequestMapping(value = "/userByUsername", method = RequestMethod.GET)
    public User findByUsername(@RequestParam(value = "username") String username) {
        return service.findByUsername(username);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestParam(value = "identifier") String identifier,
                      @RequestParam(value = "password") String password) {
        return service.login(identifier, password);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(@RequestBody User user) {
        return service.createUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void deleteUserById(@RequestParam(value = "id") Long id) {
        service.removeUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

}
