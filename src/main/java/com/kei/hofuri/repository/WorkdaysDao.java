package com.kei.hofuri.repository;

import com.kei.hofuri.entity.Workday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class WorkdaysDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  public int update(Workday workday) {
    String sql = "UPDATE workdays SET fetched_flg = :fetchedFlg WHERE workday = :workday";
    SqlParameterSource parameterSource = new MapSqlParameterSource("fetchedFlg", workday.isFetchedFlg())
                                             .addValue("workday", workday.getWorkday());
    return jdbcTemplate.update(sql, parameterSource);
  }
}
