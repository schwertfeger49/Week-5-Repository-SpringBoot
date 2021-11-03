package com.promineotech.birds.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.birds.dao.BasicBirdNameDao.SqlParams;
import com.promineotech.birds.entity.BirdTypeEnum;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicCreateSightingDao implements CreateSightingDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Sightings createSighting(String birdName, String city, String state, String username,
      String dateTime) {
      // create sighting in database and return sighting
      // future work: fetch ids from parameter input
      log.debug("DAO: birdName={}, city={}, state={}, username={}, dateTime={}", birdName, city, state, username, dateTime);
    
    SqlParams params = generateInsertSql(birdName, city, state, username, dateTime);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int sightingId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return Sightings.builder()
        .sightingId(sightingId)
        .build();
    // @formatter:on
    }
    
    private SqlParams generateInsertSql(String birdName, String city, String state, String username,
        String dateTime) {
      SqlParams params = new SqlParams();
    
      // @formatter:off
      params.sql = ""
        + "INSERT "
        + "into sightings(bird_id, location_id, user_id, date_time) "
        + "values ("
        + "(SELECT bird_id FROM bird_names WHERE bird_name = "
        + ":birdName"
        + "), "
        + "(SELECT location_id FROM locations WHERE city = "
        + ":city"
        + " AND state = "
        + ":state"
        + "), "
        + "(SELECT user_id FROM users WHERE username = "
        + ":username"
        + "), "
        + ":dateTime"
        + ")";
      // @formatter:on
    
      params.source.addValue("birdName", birdName);
      params.source.addValue("city", city);
      params.source.addValue("state", state);
      params.source.addValue("username", username);
      params.source.addValue("dateTime", dateTime);
    
      return params;
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
      }
}
