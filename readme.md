This is a sample spring boot rest api project with:

1- H2 in-memory database
2- Swagger 2 implemented for rest api documentation.
3- Basic authentication using spring security's in-memory auth.

To secure the rest api spring-security needs to be enabled. Here are the steps:

Step 1- Add following dependency to in maven project:

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

After adding the dependency restart the app. Now all the URL's of the application
are protected via spring security. Accessing them will present a login screen.

Step 2 - Create a class that extends WebSecurityConfigurerAdapter from package
     org.springframework.security.config.annotation.web.configuration
     
     