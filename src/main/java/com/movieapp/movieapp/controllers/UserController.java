package com.movieapp.movieapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.movieapp.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    //    TODO:
//    @PutMapping(path = "/{id}")
//    public UserDto createUpdateUser(
////        @PathVariable final String id,
//        @RequestBody final CreateUpdateUserRequestDto requestBody
//    ) {
//    }
}
