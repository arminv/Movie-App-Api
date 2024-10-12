package com.movieapp.movieapp.user;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.movieapp.movieapp.BaseMongoTest;
import com.movieapp.movieapp.TestDataUtil;

@SpringBootTest
public class UserEntityRepositoryIntegrationTests extends BaseMongoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        User userEntity = TestDataUtil.createTestUserEntityA();
        userRepository.save(userEntity);

        Optional<User> result = userRepository.findById(userEntity.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(userEntity);
    }

}
