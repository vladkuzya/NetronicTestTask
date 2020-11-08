package com.netronic.dto;

import java.util.List;

public class UserApiDto {
    private List<UserResponseDto> results;

    public List<UserResponseDto> getResults() {
        return results;
    }

    public void setResults(List<UserResponseDto> results) {
        this.results = results;
    }
}
