package com.netronic.service.mapper;

import com.netronic.dto.LoginDto;
import com.netronic.model.Login;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {
    public Login mapToEntity(LoginDto dto) {
        Login login = new Login();
        login.setUuid(dto.getUuid());
        login.setUsername(dto.getUsername());
        login.setPassword(dto.getPassword());
        login.setSalt(dto.getSalt());
        login.setMd5(dto.getMd5());
        login.setSha1(dto.getSha1());
        login.setSha256(dto.getSha256());
        return login;
    }
}
