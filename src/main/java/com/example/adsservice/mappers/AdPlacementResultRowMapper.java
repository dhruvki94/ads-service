package com.example.adsservice.mappers;

import com.example.adsservice.model.AdPlacement;
import com.example.adsservice.model.DeviceType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdPlacementResultRowMapper implements RowMapper<AdPlacement> {
  @Override
  public AdPlacement mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new AdPlacement(
      rs.getInt("width_pixels"),
      rs.getInt("height_pixels"),
      rs.getString("location"),
      DeviceType.valueOf(rs.getString("device_type"))
    );
  }
}
