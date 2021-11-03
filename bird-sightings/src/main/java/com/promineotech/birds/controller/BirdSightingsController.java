package com.promineotech.birds.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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


public interface BirdSightingsController {
  
//@formatter:off
  @Operation(
      summary = "Returns a list of sightings",
      description = "Returns a list of sightings given a bird name",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A list of sightings is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Sightings.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The request paramters are invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404",
              description = "No sightings were found with the input criteria",
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
              description = "The bird name (i.e. 'American Robin')")
      }
    )
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Sightings> fetchSightings(
      @RequestParam(required = false)
          String birdName);
  // @formatter:on
}
