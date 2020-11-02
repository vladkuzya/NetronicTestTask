package com.netronic.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private String gender;
    private NameDto name;
    private LocationDto location;
    private String email;
    private LoginDto login;
    private DobDto dob;
    private RegisteredDto registered;
    private String phone;
    private String cell;
    private IddDto id;
    private PictureDto picture;
    private String nat;
}
