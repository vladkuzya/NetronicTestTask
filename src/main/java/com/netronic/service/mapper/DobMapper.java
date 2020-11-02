package com.netronic.service.mapper;

import com.netronic.dto.DobDto;
import com.netronic.model.Dob;
import org.springframework.stereotype.Component;

@Component
public class DobMapper {
    public Dob mapToEntity(DobDto dto) {
        Dob dob = new Dob();
        dob.setDate(dto.getDate());
        dob.setAge(dto.getAge());
        return dob;
    }
}
