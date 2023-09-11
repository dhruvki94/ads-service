package com.example.adsservice.model;


public record AdPlacementRecord(
  Integer id,
  Integer widthPixels,
  Integer heightPixels,
  String location,
  DeviceType deviceType
  ) { };
