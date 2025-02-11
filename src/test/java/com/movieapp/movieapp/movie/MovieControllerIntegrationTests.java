package com.movieapp.movieapp.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieapp.movieapp.BaseMongoTest;
import com.movieapp.movieapp.TestDataUtil;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class MovieControllerIntegrationTests extends BaseMongoTest {

    private final MockMvc mockMvc;

    private final ObjectMapper objectMapper;

    private final MovieService movieService;

    @Autowired
    public MovieControllerIntegrationTests(MockMvc mockMvc, MovieService movieService) {
        this.mockMvc = mockMvc;
        this.movieService = movieService;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules();
    }

    @Test
    public void testCreateMovieReturnsHttpStatus201Created() throws Exception {
        MovieDto testMovieA = TestDataUtil.createTestMovieDtoA();
        String movieJson = objectMapper.writeValueAsString(testMovieA);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/movies/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movieJson)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testUpdateMovieReturnsHttpStatus201Created() throws Exception {
        Movie testMovieEntityA = TestDataUtil.createTestMovieEntityA();
        Movie savedMovieEntity = movieService.createUpdateMovie(
            testMovieEntityA.getId(), CreateUpdateMovieRequest.builder()
                .movieDBId(testMovieEntityA.getId())
                .name(testMovieEntityA.getName())
                .userId(testMovieEntityA.getUserId())
                .rating(testMovieEntityA.getRating())
                .review(testMovieEntityA.getReview())
                .dateWatched(testMovieEntityA.getDateWatched())
                .build()
        );

        MovieDto testMovieA = TestDataUtil.createTestMovieDtoB();
        testMovieA.setId(savedMovieEntity.getId());
        String movieJson = objectMapper.writeValueAsString(testMovieA);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/movies/" + testMovieA.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(movieJson)
        ).andExpect(
            MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testCreateMovieReturnsCreatedMovie() throws Exception {
        MovieDto testMovieC = TestDataUtil.createTestMovieDtoC();
        String movieJson = objectMapper.writeValueAsString(testMovieC);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/movies/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movieJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value("Lost")
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.rating").value(4.0f)
        );
    }

    @Test
    public void testUpdateMovieReturnsUpdatedMovie() throws Exception {
        Movie testMovieEntityA = TestDataUtil.createTestMovieEntityA();
        Movie savedMovieEntity = movieService.createUpdateMovie(
            testMovieEntityA.getId(), CreateUpdateMovieRequest.builder()
                .movieDBId(testMovieEntityA.getId())
                .name(testMovieEntityA.getName())
                .userId(testMovieEntityA.getUserId())
                .rating(testMovieEntityA.getRating())
                .review(testMovieEntityA.getReview())
                .dateWatched(testMovieEntityA.getDateWatched())
                .build()
        );

        MovieDto testMovieC = TestDataUtil.createTestMovieDtoC();
        testMovieC.setId(savedMovieEntity.getId());
        testMovieC.setMovieDBId(savedMovieEntity.getMovieDBId());
        String movieJson = objectMapper.writeValueAsString(testMovieC);

        mockMvc.perform(
            MockMvcRequestBuilders.put("/movies/" + testMovieC.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(movieJson)
        ).andExpect(
            MockMvcResultMatchers.jsonPath("$.rating").value(4.0f)
        );
    }

    @Test
    public void testDeleteExistingMovieReturnsHttpStatus204NoContent() throws Exception {
        Movie testMovieEntityB = TestDataUtil.createTestMovieEntityB();
        movieService.createUpdateMovie(
            testMovieEntityB.getId(), CreateUpdateMovieRequest.builder()
                .movieDBId(testMovieEntityB.getId())
                .name(testMovieEntityB.getName())
                .userId(testMovieEntityB.getUserId())
                .rating(testMovieEntityB.getRating())
                .review(testMovieEntityB.getReview())
                .dateWatched(testMovieEntityB.getDateWatched())
                .build()
        );

        mockMvc.perform(
            MockMvcRequestBuilders.delete("/movies/" + testMovieEntityB.getId())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testDeleteNonExistingMovieReturnsHttpStatus204NoContent() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders.delete("/movies/38fhe8du39fNonExisting")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testGetMovieReturnsHttpStatus202AcceptedWhenUserHasMovies() throws Exception {
        MovieDto testMovieC = TestDataUtil.createTestMovieDtoC();
        objectMapper.writeValueAsString(testMovieC);

        mockMvc.perform(
            MockMvcRequestBuilders.get("/movies/users/" + testMovieC.getUserId())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
            MockMvcResultMatchers.status().isAccepted()
        );
    }

    @Test
    public void testGetMovieReturnsHttpStatus202AcceptedWhenUserDoesNotHaveMovies() throws Exception {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/movies/users/3945jv30vk3NonExisting")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
            MockMvcResultMatchers.status().isAccepted()
        );
    }

}
