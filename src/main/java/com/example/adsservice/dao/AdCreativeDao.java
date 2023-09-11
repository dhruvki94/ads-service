package com.example.adsservice.dao;

import com.example.adsservice.model.AdCreative;
import com.example.adsservice.model.AdPlacement;

import java.util.List;

public interface AdCreativeDao {
  List<AdCreative> selectAdCreativeByAdPlacement(AdPlacement placement);
  Integer insertAdCreative(AdCreative adCreative);
}
