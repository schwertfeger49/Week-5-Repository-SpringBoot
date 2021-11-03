package com.promineotech.birds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.birds.dao.BasicBirdNameDao.SqlParams;
import com.promineotech.birds.entity.BirdTypeEnum;
import com.promineotech.birds.entity.Sightings;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicDeleteSightingDao implements DeleteSightingDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public void deleteSighting(int sightingId) {
    // future work: check that jdbc return value is not 0
    log.debug("DAO: sightingId={}", sightingId);
    
    SqlParams params = generateInsertSql(sightingId);
    
    jdbcTemplate.update(params.sql, params.source);
    
  }

  private SqlParams generateInsertSql(int sightingId) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "DELETE "
        + "from sightings "
        + "where sighting_id = "
        + ":sightingId";
    // @formatter:on
    
    params.source.addValue("sightingId", sightingId);
    
    return params;
    
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
}
