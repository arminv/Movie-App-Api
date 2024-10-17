package com.movieapp.movieapp.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.movieapp.movieapp.TestDataUtil;
import com.movieapp.movieapp.mappers.Mapper;


class UserMapperTest {

    private Mapper<User, UserDto> userMapper;

    @BeforeEach
    public void setUp() {
        this.userMapper = new UserMapper(new ModelMapper());
    }

    @Test
    public void testMapTo() {
        User userB = TestDataUtil.createTestUserEntityA();
        UserDto userDtoB = TestDataUtil.createTestUserDtoA();
        UserDto result = this.userMapper.mapTo(userB);

        assertEquals(userDtoB, result);
    }

    @Test
    public void testMapFrom() {
        UserDto userDtoA = TestDataUtil.createTestUserDtoA();
        User userA = TestDataUtil.createTestUserEntityA();
        User result = this.userMapper.mapFrom(userDtoA);

        assertEquals(userA, result);
    }

    @Test
    public void testMapToThrowsWhenPassedNull() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> this.userMapper.mapTo(null));
        assertEquals("user is null", exp.getMessage());
    }

    @Test
    public void testMapFromThrowsWhenPassedNull() {
        NullPointerException exp = assertThrows(NullPointerException.class, () -> this.userMapper.mapFrom(null));
        assertEquals("userDto is null", exp.getMessage());
    }

}
