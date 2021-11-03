package com.promineotech.birds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.birds.entity.Locations;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/location")
@OpenAPIDefinition(info = @Info(title = "Bird Sightings Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface LocationController {

//@formatter:off
  @Operation(
      summary = "Creates a Location",
      description = "Creates a Location when a city and state is provided",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A Location is created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Locations.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The city or state is invalid",
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
              name = "city",
              allowEmptyValue = false,
              required = false,
              description = "The city (i.e. 'Missoula')"),
          
          @Parameter(
              name = "state",
              allowEmptyValue = false,
              required = false,
              description = "The state (i.e. 'Montana')")
      }
    )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Locations createdLocation(
      @RequestParam(required = false)
          String city,
      @RequestParam(required = false)
          String state);
  // @formatter:on
}
