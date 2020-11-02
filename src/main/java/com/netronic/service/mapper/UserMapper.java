package com.netronic.service.mapper;

import com.netronic.dto.UserResponseDto;
import com.netronic.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final NameMapper nameMapper;
    private final LocationMapper locationMapper;
    private final LoginMapper loginMapper;
    private final DobMapper dobMapper;
    private final RegisteredMapper registeredMapper;
    private final IddMapper iddMapper;
    private final PictureMapper pictureMapper;

    public UserMapper(NameMapper nameMapper,
                      LocationMapper locationMapper,
                      LoginMapper loginMapper,
                      DobMapper dobMapper,
                      RegisteredMapper registeredMapper,
                      IddMapper iddMapper,
                      PictureMapper pictureMapper) {
        this.nameMapper = nameMapper;
        this.locationMapper = locationMapper;
        this.loginMapper = loginMapper;
        this.dobMapper = dobMapper;
        this.registeredMapper = registeredMapper;
        this.iddMapper = iddMapper;
        this.pictureMapper = pictureMapper;
    }

    public User mapToEntity(UserResponseDto dto) {
        User user = new User();
        user.setName(nameMapper.mapToEntity(dto.getName()));
        user.setLocation(locationMapper.mapToEntity(dto.getLocation()));
        user.setEmail(dto.getEmail());
        user.setLogin(loginMapper.mapToEntity(dto.getLogin()));
        user.setDob(dobMapper.mapToEntity(dto.getDob()));
        user.setRegistered(registeredMapper.mapToEntity(dto.getRegistered()));
        user.setPhone(dto.getPhone());
        user.setCell(dto.getCell());
        user.setIdd(iddMapper.mapToEntity(dto.getId()));
        user.setPicture(pictureMapper.mapToEntity(dto.getPicture()));
        user.setNat(dto.getNat());
        return user;
    }
}
