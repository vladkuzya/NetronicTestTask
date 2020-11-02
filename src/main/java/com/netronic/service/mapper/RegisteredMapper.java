package com.netronic.service.mapper;

import com.netronic.dto.RegisteredDto;
import com.netronic.model.Registered;
import org.springframework.stereotype.Component;

@Component
public class RegisteredMapper {
    public Registered mapToEntity(RegisteredDto dto) {
        Registered registered = new Registered();
        registered.setAge(dto.getAge());
        registered.setDate(dto.getDate());
        return registered;
    }
}
