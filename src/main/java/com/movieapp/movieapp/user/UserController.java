package com.movieapp.movieapp.user;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.movieapp.movieapp.mappers.Mapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    private Mapper<User, UserDto> userMapper;

    private Mapper<CreateUpdateUserRequest, CreateUpdateUserRequestDto> createUpdateRequestMapper;

    @Operation(
        description = "Create or Update a user by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "User successfully created/updated"),
            @ApiResponse(responseCode = "403", description = "Missing or invalid user")
        }
    )
    @PutMapping(value = {"/{id}", "/"})
    public UserDto createUpdateUser(
        @PathVariable(required = false) final String id,
        @RequestBody final CreateUpdateUserRequestDto requestBody
    ) {
        // Convert from the create/update User request presentation layer to service layer object:
        final CreateUpdateUserRequest createUpdateUserRequest = createUpdateRequestMapper.mapFrom(requestBody);

        try {
            // Pass the converted object to the service layer to create/update the User:
            final User createUpdatedUser = userService.createUpdateUser(id, createUpdateUserRequest);
            // Map the returned User to a presentation layer object and return:
            return userMapper.mapTo(createUpdatedUser);
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "User already exists", e);
        }
    }

    @Operation(
        description = "Get a user by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "User successfully found"),
            @ApiResponse(responseCode = "403", description = "Missing or invalid user")
        }
    )
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

    @Operation(
        description = "Get detailed user information by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "User successfully found"),
            @ApiResponse(responseCode = "403", description = "Missing or invalid user")
        }
    )
    @GetMapping("/user")
    public String getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        return userService.getUserInfo(principal).toString();
    }

}
