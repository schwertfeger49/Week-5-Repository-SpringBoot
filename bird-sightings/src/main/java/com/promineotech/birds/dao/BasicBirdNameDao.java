package com.promineotech.birds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.birds.entity.BirdNames;
import com.promineotech.birds.entity.BirdTypeEnum;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicBirdNameDao implements BirdNameDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public BirdNames createBirdName(BirdTypeEnum typeName, String birdName) {
    // create bird name in database and return bird name
    log.debug("DAO: birdType={}, birdName={}", typeName, birdName);
    
    SqlParams params = generateInsertSql(typeName, birdName);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int birdId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return BirdNames.builder()
        .birdId(birdId)
        .typeName(typeName)
        .birdName(birdName)
        .build();
    // @formatter:on
    
  }

  private SqlParams generateInsertSql(BirdTypeEnum typeName, String birdName) {
    SqlParams params = new SqlParams();
    
    // @formatter:off
    params.sql = ""
        + "INSERT "
        + "into bird_names(type_id, bird_name) "
        + "values ("
        + "(SELECT type_id FROM type_names WHERE type_name = "
        + ":typeName"
        + "), "
        + ":birdName"
        + ")";
    // @formatter:on
    
    params.source.addValue("typeName", typeName.toString());
    params.source.addValue("birdName", birdName);
    
    return params;
    
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
}
