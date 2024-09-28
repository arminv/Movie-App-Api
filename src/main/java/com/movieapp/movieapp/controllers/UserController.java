package com.movieapp.movieapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.movieapp.domain.CreateUpdateUserRequest;
import com.movieapp.movieapp.domain.documents.User;
import com.movieapp.movieapp.domain.dtos.UserDto;
import com.movieapp.movieapp.domain.dtos.CreateUpdateUserRequestDto;
import com.movieapp.movieapp.mappers.Mapper;
import com.movieapp.movieapp.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    private Mapper<User, UserDto> userMapper;

    private Mapper<CreateUpdateUserRequest, CreateUpdateUserRequestDto> createUpdateRequestMapper;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable final String id) {
        return userService.getUserById(id)
            .map(user ->
                // Map the User to a UserDTO:
                ResponseEntity.ok(userMapper.mapTo(user))
            )
            .orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
            );
    }

    @PutMapping(value = {"/{id}", "/"})
    public UserDto createUpdateUser(
        @PathVariable(required = false) final String id,
        @RequestBody final CreateUpdateUserRequestDto requestBody
    ) {
        // Convert from the create/update User request presentation layer to service layer object.
        final CreateUpdateUserRequest createUpdateUserRequest = createUpdateRequestMapper.mapFrom(requestBody);

        // Pass the converted object to the service layer to create/update the User.
        final User createUpdatedUser = userService.createUpdateUser(id, createUpdateUserRequest);

        // Map the returned User to a presentation layer object and return.
        return userMapper.mapTo(createUpdatedUser);
    }

}
