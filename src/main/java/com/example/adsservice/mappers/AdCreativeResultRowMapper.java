package com.example.adsservice.mappers;

import com.example.adsservice.model.AdCreative;
import com.example.adsservice.model.DeviceType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdCreativeResultRowMapper implements RowMapper<AdCreative> {
  @Override
  public AdCreative mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new AdCreative(
      rs.getString("image_url"),
      rs.getInt("width_pixels"),
      rs.getInt("height_pixels"),
      rs.getString("location"),
      DeviceType.valueOf(rs.getString("device_type"))
    );
  }
}
