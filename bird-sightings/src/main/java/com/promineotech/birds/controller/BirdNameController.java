package com.promineotech.birds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.birds.entity.BirdNames;
import com.promineotech.birds.entity.BirdTypeEnum;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/birdName")
@OpenAPIDefinition(info = @Info(title = "Bird Sightings Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})

public interface BirdNameController {

//@formatter:off
  @Operation(
      summary = "Creates a Bird",
      description = "Creates a Bird when a bird type and bird name is provided",
      responses = {
          @ApiResponse(
              responseCode = "201",
              description = "A Bird is created",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = BirdNames.class))),
          @ApiResponse(
              responseCode = "400",
              description = "The bird type or bird name is invalid",
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
              name = "typeName",
              allowEmptyValue = false,
              required = false,
              description = "The bird type (i.e. 'Procellariiformes')"),
          
          @Parameter(
              name = "birdName",
              allowEmptyValue = false,
              required = false,
              description = "The bird name (i.e. 'American Robin')")
      }
    )
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  BirdNames createdBirdName(
      @RequestParam(required = false)
          BirdTypeEnum typeName,
      @RequestParam(required = false)
          String birdName);
  // @formatter:on
}
