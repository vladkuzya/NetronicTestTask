package com.netronic.service.mapper;

import com.netronic.dto.StreetDto;
import com.netronic.model.location.Street;
import org.springframework.stereotype.Component;

@Component
public class StreetMapper {
    public Street mapToEntity(StreetDto dto) {
        Street street = new Street();
        street.setName(dto.getName());
        street.setNumber(dto.getNumber());
        return street;
    }
}
