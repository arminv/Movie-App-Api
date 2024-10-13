package com.movieapp.movieapp.movie;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.movieapp.movieapp.mappers.Mapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/movies")
public class MovieController {

    private MovieService movieService;

    private Mapper<Movie, MovieDto> movieMapper;

    private Mapper<CreateUpdateMovieRequest, CreateUpdateMovieRequestDto> createUpdateRequestMapper;

    @Operation(
        description = "Create or Update a movie by ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Movie successfully created/updated"),
            @ApiResponse(responseCode = "403", description = "Missing or invalid user")
        }
    )
    @PutMapping(value = {"/{id}", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto createUpdateMovie(
        @PathVariable(required = false) final String id,
        @RequestBody final CreateUpdateMovieRequestDto requestBody
    ) {
        final CreateUpdateMovieRequest createUpdateMovieRequest = createUpdateRequestMapper.mapFrom(requestBody);

        try {
            final Movie createUpdatedMovie = movieService.createUpdateMovie(id, createUpdateMovieRequest);
            return movieMapper.mapTo(createUpdatedMovie);
        } catch (DuplicateKeyException e) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Movie already exists", e);
        }
    }

    @Operation(
        description = "Get the list of liked movies by user ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Movies successfully found"),
            @ApiResponse(responseCode = "403", description = "Missing or invalid user")
        }
    )
    @GetMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Page<MovieDto> getMoviesByUserId(
        @PathVariable final String userId,
        @RequestParam(defaultValue = "0") final int page,
        @RequestParam(defaultValue = "30") final int pageSize,
        @RequestParam(defaultValue = "created") final String sortBy,
        @RequestParam(defaultValue = "desc") final String sortDirection
    ) {
        return movieService.getMoviesByUserId(userId, page, pageSize, sortBy, sortDirection)
            .map(movieMapper::mapTo);
    }

    @Operation(
        description = "Delete a movie by ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Movie successfully deleted"),
            @ApiResponse(responseCode = "403", description = "Missing or invalid user")
        }
    )
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable final String id) {
        movieService.deleteMovie(id);
    }

}
