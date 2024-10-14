# Movie App API

Backend API for a Movie App similar to [this app](https://react-movies-list.netlify.app/).
Stack/tools include the following:

- Java (23 SDK)
- Spring Boot
- Spring Security (OAuth2)
- Spring Data MongoDB
- MongoDB
- Docker
- Lombok
- Model Mapper
- Testcontainers
- Swagger
- Maven

## Env Variables

The following environment variables are needed:

- `GB_CLIENT_ID=get-your-own`
- `GB_CLIENT_SECRET=get-your-own`
- `ACTIVE_SPRING_PROFILE=dev|test|prod`
- `MONGO_URI=`

## Swagger UI

`http://localhost:8080/swagger-ui/index.html`

![screencapture-localhost-8080-swagger-ui-index-html-2024-10-14-16_07_03](https://github.com/user-attachments/assets/4e946b6d-9c89-4844-b22e-a2d7f6dbad50)


## Mongo Express UI

`http://localhost:8081/`

## Notes

- Make sure Docker is up and running (needed for both server and integration tests).
- Integration tests (that rely on Testcontainers) need to extend the `BaseMongoTest` abstract base class.

## TODO

- Add tests (integration, unit)
- Add and use custom Exception classes
- Implement authorization & role levels/types
- Add Google (OAuth provider)
- Implement JWT-based auth flow
