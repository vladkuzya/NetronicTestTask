package com.netronic.service;

import com.netronic.model.User;
import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAll();

    User getById(Long id);
}
