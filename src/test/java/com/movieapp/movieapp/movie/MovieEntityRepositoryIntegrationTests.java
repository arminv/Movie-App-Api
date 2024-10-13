package com.movieapp.movieapp.movie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import static org.assertj.core.api.Assertions.assertThat;

import com.movieapp.movieapp.BaseMongoTest;
import com.movieapp.movieapp.TestDataUtil;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MovieEntityRepositoryIntegrationTests extends BaseMongoTest {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieEntityRepositoryIntegrationTests(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Test
    public void testThatMovieCanBeCreatedAndRecalled() {
        Movie movieEntity = TestDataUtil.createTestMovieEntityA();
        movieRepository.save(movieEntity);

        List<Movie> result = movieRepository.findByUserId(movieEntity.getUserId());

        assertThat(result).isEqualTo(List.of(movieEntity));
    }

    @Test
    public void testThatMovieCanBeUpdated() {
        Movie movieEntity = TestDataUtil.createTestMovieEntityA();
        movieRepository.save(movieEntity);

        movieEntity.setName("UPDATED Movie 29fj29rj");
        movieEntity.setRating(4.5f);
        movieEntity.setDateWatched(LocalDateTime.parse("2019-02-01T17:15:12.102"));
        movieRepository.save(movieEntity);
        Optional<Movie> result = movieRepository.findById(movieEntity.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(movieEntity);
    }

    @Test
    public void testThatMovieCanBeDeleted() {
        Movie movieEntity = TestDataUtil.createTestMovieEntityA();
        movieRepository.delete(movieEntity);

        Optional<Movie> result = movieRepository.findById(movieEntity.getId());

        assertThat(result).isEmpty();
    }

}
