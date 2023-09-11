package com.example.adsservice.service;

import com.example.adsservice.dao.AdPlacementDao;
import com.example.adsservice.model.AdPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdPlacementService {
  private final AdPlacementDao adPlacementDao;
  @Autowired
  public AdPlacementService(@Qualifier("ad_placement_pg") AdPlacementDao adPlacementDao) { this.adPlacementDao = adPlacementDao; }

  public Optional<AdPlacement> getById(Integer id) { return adPlacementDao.selectById(id); }

  public Integer insertAdPlacement(AdPlacement adPlacement) { return adPlacementDao.insertAdPlacement(adPlacement);}
}
