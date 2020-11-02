package com.netronic.service.mapper;

import com.netronic.dto.LocationDto;
import com.netronic.model.location.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper {
    private final StreetMapper streetMapper;
    private final CoordinatesMapper coordinatesMapper;
    private final TimezoneMapper timezoneMapper;

    public LocationMapper(StreetMapper streetMapper,
                          CoordinatesMapper coordinatesMapper,
                          TimezoneMapper timezoneMapper) {
        this.streetMapper = streetMapper;
        this.coordinatesMapper = coordinatesMapper;
        this.timezoneMapper = timezoneMapper;
    }

    public Location mapToEntity(LocationDto dto) {
        Location location = new Location();
        location.setStreet(streetMapper.mapToEntity(dto.getStreet()));
        location.setCity(dto.getCity());
        location.setCountry(dto.getCountry());
        location.setPostcode(dto.getPostcode());
        location.setCoordinates(coordinatesMapper.mapToEntity(dto.getCoordinates()));
        location.setTimezone(timezoneMapper.mapToEntity(dto.getTimezone()));
        return location;
    }
}
