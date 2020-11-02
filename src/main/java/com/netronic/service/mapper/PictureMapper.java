package com.netronic.service.mapper;

import com.netronic.dto.PictureDto;
import com.netronic.model.Picture;
import org.springframework.stereotype.Component;

@Component
public class PictureMapper {
    public Picture mapToEntity(PictureDto dto) {
        Picture picture = new Picture();
        picture.setThumbnail(dto.getThumbnail());
        picture.setMedium(dto.getMedium());
        picture.setLarge(dto.getLarge());
        return picture;
    }
}
