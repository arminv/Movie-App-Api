package com.movieapp.movieapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class BaseMongoTest {

    protected static MongoDBContainer mongoDBContainer;

    @BeforeAll
    public static void setUp() {
        // Start the MongoDB container
        mongoDBContainer = new MongoDBContainer("mongo:8.0");
        mongoDBContainer.start();

        // Set the system property to override the default MongoDB connection string
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }

    @AfterAll
    public static void tearDown() {
        if (mongoDBContainer != null) {
            mongoDBContainer.stop();
        }
    }

}
