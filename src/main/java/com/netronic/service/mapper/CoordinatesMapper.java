package com.netronic.service.mapper;

import com.netronic.dto.CoordinatesDto;
import com.netronic.model.location.Coordinates;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesMapper {
    public Coordinates mapToEntity(CoordinatesDto dto) {
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(dto.getLatitude());
        coordinates.setLongitude(dto.getLatitude());
        return coordinates;
    }
}
