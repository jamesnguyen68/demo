package com.example.demo.converter;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    public User toDo(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
