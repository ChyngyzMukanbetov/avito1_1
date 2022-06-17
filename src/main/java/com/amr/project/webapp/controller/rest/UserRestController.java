package com.amr.project.webapp.controller.rest;

import com.amr.project.converter.UserConverter;
import com.amr.project.model.dto.UserDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;
    private final UserConverter userConverter;


    //  Получение пользователя по id
    @ResponseBody
    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable long id) {
        User userId = userService.findById(id);
        UserDto userDto = userConverter.toDto(userId);
        return userDto;
    }

    //  Получение всех пользователей
    @ResponseBody
    @GetMapping("/users")
    public List<UserDto> getUserById() {
        List<User> userList = userService.findAll();
        List<UserDto> userDtos = userConverter.toDto(userList);
        return userDtos;
    }

    //    Создание нового пользователя
    @PostMapping("/users")
    public ResponseEntity<UserDto> createShop(@RequestBody UserDto userDto, Principal principal) {
        if (userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User user = userConverter.toModel(userDto);
            userService.persist(user);
            return new ResponseEntity<>(userConverter.toDto(userService.findById(user.getId())), HttpStatus.OK);
        }
    }

    //    Редактирование пользователя по id
    @PutMapping("/users")
    public ResponseEntity<UserDto> updateShop(@RequestBody UserDto userDto, Principal principal) {
        if (!userService.existsById(userDto.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            User user = userConverter.toModel(userDto);
            userService.update(user);
            return new ResponseEntity<>(userConverter.toDto(userService.findById(userDto.getId())), HttpStatus.OK);
        }
    }

    //    Удаление товара по id
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteItemRest(@PathVariable Long id) {
        userService.delete(userService.findById(id));
        return new ResponseEntity<>("User with id = " + id + " deleted", HttpStatus.OK);
    }

}