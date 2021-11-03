package com.promineotech.birds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.birds.entity.Users;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/user")
@OpenAPIDefinition(info = @Info(title = "Bird Sightings Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface UserController {
  
//@formatter:off
  @Operation(
      summary = "Creates a User",
      description = "Creates a User when username is provided",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A User is created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Users.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The username is invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500",
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "username",
              allowEmptyValue = false,
              required = false,
              description = "The username (i.e. 'schwertfeger49')")
      }
    )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Users createdUser(
      @RequestParam(required = false)
          String username);
  // @formatter:on
}
