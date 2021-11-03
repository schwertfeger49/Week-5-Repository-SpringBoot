package com.promineotech.birds.dao;

import com.promineotech.birds.entity.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicLocationDao implements LocationDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Locations createLocation(String city, String state) {
    // create location in database and return location
    log.debug("DAO: city={}, state={}", city, state);
    
    SqlParams params = generateInsertSql(city, state);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int locationId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return Locations.builder()
        .locationId(locationId)
        .city(city)
        .state(state)
        .build();
    // formatter:on
    
  }
  
  private SqlParams generateInsertSql(String city, String state) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT "
        + "into locations(city, state) "
        + "values ("
        + ":city"
        + ", "
        + ":state"
        + ")";
    // @formatter:on
    
    params.source.addValue("city", city);
    params.source.addValue("state", state);
    
    return params;
    
  }
//    Map<String, Object> params = new HashMap<>();
//    params.put("city", city);
//    params.put("state", state);
//    
//    return jdbcTemplate.query(sql, params,
//        new RowMapper<Locations>() {
//          @Override
//          public Locations mapRow(ResultSet rs, int rowNum) throws SQLException {
    

    class SqlParams {
      String sql;
      MapSqlParameterSource source = new MapSqlParameterSource();
    }

}
