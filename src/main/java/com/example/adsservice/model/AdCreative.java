package com.example.adsservice.model;

import java.util.UUID;

public class AdCreative {
  private final String imageUrl;
  private final Integer widthPixels;
  private final Integer heightPixels;
  private final String location;
  private final DeviceType deviceType;

  public AdCreative(String imageUrl, Integer widthPixels, Integer heightPixels, String location, DeviceType deviceType) {
    this.imageUrl = imageUrl;
    this.widthPixels = widthPixels;
    this.heightPixels = heightPixels;
    this.location = location;
    this.deviceType = deviceType;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public Integer getWidthPixels() {
    return widthPixels;
  }

  public Integer getHeightPixels() {
    return heightPixels;
  }

  public String getLocation() {
    return location;
  }

  public DeviceType getDeviceType() {
    return deviceType;
  }
}
