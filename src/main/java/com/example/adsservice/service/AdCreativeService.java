package com.example.adsservice.service;

import com.example.adsservice.dao.AdCreativeDao;
import com.example.adsservice.model.AdCreative;
import com.example.adsservice.model.AdPlacement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AdCreativeService {

  private final AdCreativeDao adCreativeDao;

  @Autowired
  public AdCreativeService(@Qualifier("ad_creative_pg") AdCreativeDao adCreativeDao) { this.adCreativeDao = adCreativeDao; }

  public List<AdCreative> getAdCreativesByAdPlacement(AdPlacement adPlacement) { return adCreativeDao.selectAdCreativeByAdPlacement(adPlacement); }
  public AdCreative selectAdCreativeFromList(List<AdCreative> adCreativeList) {
    //TODO() Can have actual selection logic here based on some parameters. Showing a random Ad here.
    Random rand = new Random();
    return adCreativeList.get(rand.nextInt(adCreativeList.size()));
  }
  public Integer insertAdCreative(AdCreative adCreative) {
    return adCreativeDao.insertAdCreative(adCreative);
  }

}
