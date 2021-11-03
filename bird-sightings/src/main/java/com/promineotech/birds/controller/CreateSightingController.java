package com.promineotech.birds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.birds.entity.Sightings;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/sightings")
@OpenAPIDefinition(info = @Info(title = "Bird Sightings Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface CreateSightingController {

//@formatter:off
  @Operation(
      summary = "Creates a Sighting",
      description = "Creates a Sighting when a bird name, city, state, and username is provided",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A Sighting is created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Sightings.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The bird name, city, state, or username is invalid",
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
              name = "birdName",
              allowEmptyValue = false,
              required = false,
              description = "The bird name (i.e. 'American Robin')"),
          
          @Parameter(
              name = "city",
              allowEmptyValue = false,
              required = false,
              description = "The city (i.e. 'Missoula')"),
          
          @Parameter(
              name = "state",
              allowEmptyValue = false,
              required = false,
              description = "The state (i.e. 'Montana')"),
          
          @Parameter(
              name = "username",
              allowEmptyValue = false,
              required = false,
              description = "The username (i.e. 'schwertfeger49')"),
          @Parameter(
              name = "dateTime",
              allowEmptyValue = false,
              required = false,
              description = "The date and time (i.e. '2021-06-01 12:00:00')")
      }
    )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Sightings createdSighting(
      @RequestParam(required = false)
          String birdName,
      @RequestParam(required = false)
          String city,
      @RequestParam(required = false)
          String state,
      @RequestParam(required = false)
          String username,
      @RequestParam(required = false)
          String dateTime);
  // @formatter:on
}
