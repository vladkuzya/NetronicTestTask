package com.netronic.dto;

public class LocationDto {
    private StreetDto street;
    private String city;
    private String country;
    private String postcode;
    private CoordinatesDto coordinates;
    private TimezoneDto timezone;

    public StreetDto getStreet() {
        return street;
    }

    public void setStreet(StreetDto street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public CoordinatesDto getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesDto coordinates) {
        this.coordinates = coordinates;
    }

    public TimezoneDto getTimezone() {
        return timezone;
    }

    public void setTimezone(TimezoneDto timezone) {
        this.timezone = timezone;
    }
}
