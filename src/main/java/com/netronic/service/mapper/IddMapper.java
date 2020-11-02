package com.netronic.service.mapper;

import com.netronic.dto.IddDto;
import com.netronic.model.Idd;
import org.springframework.stereotype.Component;

@Component
public class IddMapper {
    public Idd mapToEntity(IddDto dto) {
        Idd idd = new Idd();
        idd.setName(dto.getName());
        idd.setValue(dto.getValue());
        return idd;
    }
}
