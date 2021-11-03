package com.promineotech.birds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.birds.dao.BasicCreateSightingDao.SqlParams;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicUpdateSightingDao implements UpdateSightingDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Sightings updateSighting(int sightingId, int birdId, int locationId, int userId,
      String dateTime) {
      // update sighting in database and return sighting
      log.debug("DAO: sightingId={}, birdId={}, locationId={}, userId={}, dateTime={}", sightingId, birdId, locationId, userId, dateTime);
      
      SqlParams params = generateInsertSql(sightingId, birdId, locationId, userId, dateTime);
      
      jdbcTemplate.update(params.sql, params.source);
      
      // @formatter:off
      return Sightings.builder()
          .sightingId(sightingId)
          .birdId(birdId)
          .locationId(locationId)
          .userId(userId)
          .dateTime(dateTime)
          .build();
      // @formatter:on
      }

  private SqlParams generateInsertSql(int sightingId, int birdId, int locationId, int userId,
      String dateTime) {
    SqlParams params = new SqlParams();
  
    // @formatter:off
    params.sql = ""
      + "UPDATE sightings SET "
      + "bird_id = :birdId, "
      + "location_id = :locationId, "
      + "user_id = :userId, "
      + "date_time = :dateTime "
      + "WHERE "
      + "sighting_id = :sightingId";
    // @formatter:on
  
    params.source.addValue("sightingId", sightingId);
    params.source.addValue("birdId", birdId);
    params.source.addValue("locationId", locationId);
    params.source.addValue("userId", userId);
    params.source.addValue("dateTime", dateTime);
  
    return params;
}

class SqlParams {
  String sql;
  MapSqlParameterSource source = new MapSqlParameterSource();
    }
}
