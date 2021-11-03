package com.promineotech.birds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.birds.entity.Sightings;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/sightings")
@OpenAPIDefinition(info = @Info(title = "Bird Sightings Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface UpdateSightingController {

  //@formatter:off
  @Operation(
      summary = "Updates a sighting",
      description = "Updates a sighting given a sightingId and additional variable",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A sighting is updated",
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
              name = "sightingId",
              allowEmptyValue = false,
              required = false,
              description = "The sightingId (i.e. '1')"),
          @Parameter(
              name = "birdId",
              allowEmptyValue = false,
              required = false,
              description = "The birdId (i.e. '1')"),
          @Parameter(
              name = "locationId",
              allowEmptyValue = false,
              required = false,
              description = "The locationId (i.e. '1')"),
          @Parameter(
              name = "userId",
              allowEmptyValue = false,
              required = false,
              description = "The userId (i.e. '1')"),
          @Parameter(
              name = "dateTime",
              allowEmptyValue = false,
              required = false,
              description = "The date and time (i.e. '2021-06-01 12:00:00')")
          
      }
    )
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Sightings updateSighting(
      @RequestParam(required = false)
          int sightingId,
      @RequestParam(required = false)
          int birdId,
      @RequestParam(required = false)
          int locationId,
      @RequestParam(required = false)
          int userId,
      @RequestParam(required = false)
          String dateTime);
  // @formatter:on
}
