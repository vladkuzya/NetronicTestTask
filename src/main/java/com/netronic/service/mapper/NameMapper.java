package com.netronic.service.mapper;

import com.netronic.dto.NameDto;
import com.netronic.model.Name;
import org.springframework.stereotype.Component;

@Component
public class NameMapper {
    public Name mapToEntity(NameDto dto) {
        Name name = new Name();
        name.setTitle(dto.getTitle());
        name.setFirst(dto.getFirst());
        name.setLast(dto.getLast());
        return name;
    }
}
