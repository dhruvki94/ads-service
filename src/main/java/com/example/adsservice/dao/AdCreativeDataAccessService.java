package com.example.adsservice.dao;

import com.example.adsservice.mappers.AdCreativeResultRowMapper;
import com.example.adsservice.model.AdCreative;
import com.example.adsservice.model.AdPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ad_creative_pg")
public class AdCreativeDataAccessService implements AdCreativeDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public AdCreativeDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<AdCreative> selectAdCreativeByAdPlacement(AdPlacement placement) {
    final String sql = "SELECT * from public.ad_creative where width_pixels = ? AND height_pixels = ? AND device_type = ? AND location = ?";
    return jdbcTemplate.query(sql, new AdCreativeResultRowMapper(), placement.getWidthPixels(), placement.getHeightPixels(), placement.getDeviceType().name(), placement.getLocation());
  }

  @Override
  public Integer insertAdCreative(AdCreative adCreative) {
    final String sql = "INSERT into public.ad_creative (image_url, width_pixels, height_pixels, location, device_type) VALUES (?, ?, ?, ?, ?)";
    jdbcTemplate.update(sql, adCreative.getImageUrl(), adCreative.getWidthPixels(), adCreative.getHeightPixels(), adCreative.getLocation(), adCreative.getDeviceType().name());
    return 1;
  }
}
