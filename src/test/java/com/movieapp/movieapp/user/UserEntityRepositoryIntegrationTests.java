package com.movieapp.movieapp.user;

import java.time.LocalDateTime;
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
public class UserEntityRepositoryIntegrationTests extends BaseMongoTest {

    private final UserRepository userRepository;

    @Autowired
    public UserEntityRepositoryIntegrationTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testThatUserCanBeCreatedAndRecalled() {
        User userEntity = TestDataUtil.createTestUserEntityA();
        userRepository.save(userEntity);

        Optional<User> result = userRepository.findByEmail(userEntity.getEmail());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userEntity);
    }

    @Test
    public void testThatUserCanBeUpdated() {
        User userEntity = TestDataUtil.createTestUserEntityA();
        userRepository.save(userEntity);

        userEntity.setName("UPDATED User 1AB32");
        userEntity.setEmail("testemailupdate@avsomethingsomething124.com");
        userEntity.setLastLoggedInOn(LocalDateTime.parse("2023-04-12T14:12:12.102"));
        userRepository.save(userEntity);
        Optional<User> result = userRepository.findById(userEntity.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userEntity);
    }

    @Test
    public void testThatUserCanBeDeleted() {
        User userEntity = TestDataUtil.createTestUserEntityA();
        userRepository.delete(userEntity);

        Optional<User> result = userRepository.findById(userEntity.getId());

        assertThat(result).isEmpty();
    }

}
