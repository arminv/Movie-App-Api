# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Development Commands

### Building and Running
- **Build**: `./mvnw clean compile` or `mvn clean compile`
- **Run application**: `./mvnw spring-boot:run` or `mvn spring-boot:run`
- **Run with specific profile**: `ACTIVE_SPRING_PROFILE=dev ./mvnw spring-boot:run`

### Testing
- **Run all tests**: `./mvnw test` or `mvn test`
- **Run specific test class**: `./mvnw test -Dtest=MovieControllerIntegrationTests`
- **Run tests with Docker**: Ensure Docker is running (required for Testcontainers)
- **Integration tests**: All integration tests must extend `BaseMongoTest` abstract class

### Database
- **Local MongoDB**: Uncomment sections in `docker-compose.yaml` and `application.yml`, then run `docker-compose up`
- **Mongo Express UI**: http://localhost:8081/ (when running locally)

### API Documentation
- **Swagger UI**: http://localhost:8080/swagger-ui/index.html

## Architecture Overview

This is a Spring Boot REST API for a movie management application with the following key architectural components:

### Core Structure
- **Package**: `com.movieapp.movieapp`
- **Main Application**: `MovieappApplication.java` - Standard Spring Boot entry point
- **Database**: MongoDB with Spring Data MongoDB
- **Authentication**: OAuth2 (GitHub) with Spring Security

### Domain Architecture
The application follows a layered architecture with two main domains:

**Movie Domain** (`movie/` package):
- `Movie.java` - Entity model
- `MovieService.java`/`MovieServiceImpl.java` - Business logic
- `MovieController.java` - REST endpoints
- `MovieRepository.java` - Data access
- `MovieDto.java` + `MovieMapper.java` - Data transfer and mapping
- `CreateUpdateMovieRequest.java` + mapper - Request handling

**User Domain** (`user/` package):
- Similar structure to Movie domain
- Handles OAuth2 user creation and management
- User statistics and profile management

### Configuration
- **Security**: `SecurityConfig.java` - OAuth2 setup, CSRF handling, profile-based configuration
- **Mapping**: `MapperConfig.java` - ModelMapper bean configuration
- **OAuth2**: `CustomOAuth2SuccessHandler.java` - Post-authentication handling

### Testing Strategy
- **Base Test Class**: `BaseMongoTest.java` - Testcontainers setup for MongoDB
- **Test Types**: Integration tests for controllers, repositories, and mappers
- **Test Utilities**: `TestDataUtil.java` - Helper methods for test data creation

### Environment Configuration
- **Profiles**: test (default), dev, prod
- **Required Environment Variables**:
  - `ACTIVE_SPRING_PROFILE`
  - `MONGO_URI`
  - `GB_CLIENT_ID` (GitHub OAuth)
  - `GB_CLIENT_SECRET` (GitHub OAuth)

### Key Dependencies
- Spring Boot 3.3.4 with Java 23
- Spring Data MongoDB + Testcontainers
- Spring Security OAuth2
- Lombok for boilerplate reduction
- ModelMapper for entity/DTO conversion
- SpringDoc OpenAPI (Swagger)

### Security Notes
- Currently configured with `permitAll()` for all endpoints (marked as TODO)
- CSRF disabled for dev/test profiles
- OAuth2 login with GitHub provider
- Session-based authentication with cookie management