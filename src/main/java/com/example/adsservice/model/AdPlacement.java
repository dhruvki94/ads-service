package com.example.adsservice.model;


public class AdPlacement {
  private final Integer widthPixels;
  private final Integer heightPixels;
  private final String location;
  private final DeviceType deviceType;

  public AdPlacement(Integer widthPixels, Integer heightPixels, String location, DeviceType deviceType) {
    this.widthPixels = widthPixels;
    this.heightPixels = heightPixels;
    this.location = location;
    this.deviceType = deviceType;
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
