package com.promineotech.birds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.birds.entity.Users;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BasicUserDao implements UserDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Users createUser(String username) {
 // create user in database and return user
    log.debug("DAO: username={}", username);
    
    SqlParams params = generateInsertSql(username);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int userId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return Users.builder()
      .userId(userId)
      .username(username)
      .build();
    // formatter:on
    
  }

    private SqlParams generateInsertSql(String username) {
      SqlParams params = new SqlParams();
      
      // @formatter:off
      params.sql = ""
        + "INSERT "
        + "into users(username) "
        + "values ("
        + ":username"
        + ")";
      // @formatter:on
      
      params.source.addValue("username", username);
      
    return params;
  }

    class SqlParams {
      String sql;
      MapSqlParameterSource source = new MapSqlParameterSource();
    }

    // create user in database and return user
//  log.debug("DAO: username={}", username);
//  
//  // @formatter:off
//  String sql = ""
//      + "INSERT "
//      + "into users(username) "
//      + "values ("
//      + ":username"
//      + ")";
//  // @formatter:on
//  
//  Map<String, Object> params = new HashMap<>();
//  params.put("username", username);
//  
//  return jdbcTemplate.query(sql, params,
//      new RowMapper<Users>() {
//        @Override
//        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
//          // @formatter:off
//          return Users.builder()
//              .userId(rs.getInt("user_id"))
//              .username(rs.getString("username"))
//              .build();
//          // formatter:on
//        }
//  });
}
