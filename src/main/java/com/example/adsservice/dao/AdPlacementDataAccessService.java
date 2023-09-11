package com.example.adsservice.dao;

import com.example.adsservice.mappers.AdPlacementResultRowMapper;
import com.example.adsservice.model.AdPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository("ad_placement_pg")
public class AdPlacementDataAccessService implements AdPlacementDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public AdPlacementDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Optional<AdPlacement> selectById(Integer id) {
    final String sql = "SELECT * from public.ad_placement where id = ?";
    return jdbcTemplate.query(sql, new AdPlacementResultRowMapper(), id)
      .stream().findFirst();
  }

  @Override
  public Integer insertAdPlacement(AdPlacement adPlacement) {
//    final String sql = "INSERT into public.ad_placement (width_pixels, height_pixels, location, device_type) VALUES (?, ?, ?, ?, ?)";
//    jdbcTemplate.update(sql, adPlacement.getWidthPixels(), adPlacement.getHeightPixels(), adPlacement.getLocation(), adPlacement.getDeviceType());
//    return 1;
    final Map<String, Object> parameters = new HashMap<>();
    parameters.put("width_pixels", adPlacement.getWidthPixels());
    parameters.put("height_pixels", adPlacement.getHeightPixels());
    parameters.put("location", adPlacement.getLocation());
    parameters.put("device_type", adPlacement.getDeviceType());

    final SimpleJdbcInsert insertIntoAdPlacement = new SimpleJdbcInsert(jdbcTemplate).withTableName("ad_placement").usingGeneratedKeyColumns("id");
    return insertIntoAdPlacement.executeAndReturnKey(parameters).intValue();
  }
}
