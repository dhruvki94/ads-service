package com.example.adsservice.api;

import com.example.adsservice.exceptions.InvalidParameterException;
import com.example.adsservice.model.AdCreative;
import com.example.adsservice.model.AdPlacement;
import com.example.adsservice.service.AdCreativeService;
import com.example.adsservice.service.AdPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("api/v1/ad")
@RestController
public class AdsController {
  private final AdCreativeService adCreativeService;
  private final AdPlacementService adPlacementService;

  @Autowired
  public AdsController(AdCreativeService adCreativeService, AdPlacementService adPlacementService) {
    this.adCreativeService = adCreativeService;
    this.adPlacementService = adPlacementService;
  }

  @GetMapping
  public AdCreative getAdCreativeByAdPlacementId(@RequestParam("id") Integer adPlacementId) {
    Optional<AdPlacement> adPlacement = adPlacementService.getById(adPlacementId);
    if (adPlacement.isEmpty()) {
      throw new InvalidParameterException();
    }
    List<AdCreative> adCreativeList = adCreativeService.getAdCreativesByAdPlacement(adPlacement.get());
    return adCreativeService.selectAdCreativeFromList(adCreativeList);
  }

  @PostMapping("creative")
  public void addAdCreative(@RequestBody AdCreative adCreative) {
    adCreativeService.insertAdCreative(adCreative);
  }

  @PostMapping("placement")
  public Map<String, Integer> addAdPlacement(@RequestBody AdPlacement adPlacement) {
    Integer id = adPlacementService.insertAdPlacement(adPlacement);
    HashMap<String, Integer> map = new HashMap<>();
    map.put("id", id);
    return map;
  }
}
