package com.promineotech.birds.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@Component
@Slf4j
public class BasicBirdSightingsDao implements BirdSightingsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Sightings> fetchSightings(String birdName) {
    // call database and return sightings
    log.debug("DAO: birdName={}", birdName);
    
    // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM sightings "
        + "INNER JOIN bird_names "
        + "USING (bird_id) "
        + "WHERE bird_name = :bird_name";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("bird_name", birdName);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<Sightings>() {
          @Override
          public Sightings mapRow(ResultSet rs, int rowNum) throws SQLException {
            // @formatter:off
            return Sightings.builder()
                .sightingId(rs.getInt("sighting_id"))
                .birdId(rs.getInt("bird_id"))
                .locationId(rs.getInt("location_id"))
                .userId(rs.getInt("user_id"))
                .dateTime(rs.getString("date_time"))
                .build();
            // @formatter:on
            }
    });
  }
    class SqlParams {
       String sql;
       MapSqlParameterSource source = new MapSqlParameterSource();
         }
}
