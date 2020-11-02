package com.netronic.service.mapper;

import com.netronic.dto.TimezoneDto;
import com.netronic.model.location.Timezone;
import org.springframework.stereotype.Component;

@Component
public class TimezoneMapper {
    public Timezone mapToEntity(TimezoneDto dto) {
        Timezone timezone = new Timezone();
        timezone.setDescription(dto.getDescription());
        timezone.setOffset(dto.getOffset());
        return timezone;
    }
}
