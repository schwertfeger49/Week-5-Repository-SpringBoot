package com.promineotech.birds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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

public interface DeleteSightingController {

//@formatter:off
  @Operation(
      summary = "Deletes a sighting",
      description = "Deletes a sighting given a sightingId",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "A sighting is deleted",
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
              description = "The sightingId (i.e. '1')")
      }
    )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  void deleteSightings(
      @RequestParam(required = false)
          int sightingId);
  // @formatter:on
}
