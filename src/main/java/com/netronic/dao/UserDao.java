package com.netronic.dao;

import com.netronic.model.User;
import java.util.List;

public interface UserDao {
    User add(User user);

    List<User> getAll();

    User getById(Long id);
}
