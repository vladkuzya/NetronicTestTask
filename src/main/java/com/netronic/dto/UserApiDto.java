package com.netronic.dto;

import java.util.List;
import lombok.Data;

@Data
public class UserApiDto {
    private List<UserResponseDto> results;
}
