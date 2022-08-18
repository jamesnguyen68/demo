package com.example.demo.controller;

import com.example.demo.converter.UserConverter;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("demo/api/v1")
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/users")
    public List<UserDto> findAllUser() {
        List<User> result = userService.findAllUser();
        return result == null ? new ArrayList<>() : result.stream().map(userConverter::toDto).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public UserDto findAllUser(@PathVariable int id) {
        User user = userService.findUserById(id);
        if (user != null) {
            return userConverter.toDto(user);
        }
        return null;
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserDto userDto) {
        User user = userConverter.toDo(userDto);
        User storedUserDo = userService.create(user);
        if (storedUserDo != null) {
            return userConverter.toDto(storedUserDo);
        }
        return null;
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
        User user = userConverter.toDo(userDto);
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return userConverter.toDto(updatedUser);
        }
        return null;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
