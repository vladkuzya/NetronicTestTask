package com.netronic.dto;

import lombok.Data;

@Data
public class LocationDto {
    private StreetDto street;
    private String city;
    private String country;
    private String postcode;
    private CoordinatesDto coordinates;
    private TimezoneDto timezone;
}
