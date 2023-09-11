package com.example.adsservice.dao;

import com.example.adsservice.model.AdPlacement;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AdPlacementDao {
  Optional<AdPlacement> selectById(Integer id);
  Integer insertAdPlacement(AdPlacement adPlacement);
}
