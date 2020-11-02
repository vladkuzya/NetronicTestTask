package com.netronic.controllers;

import com.netronic.dto.UserApiDto;
import com.netronic.dto.UserResponseDto;
import com.netronic.model.User;
import com.netronic.service.DataService;
import com.netronic.service.UserService;
import com.netronic.service.mapper.UserMapper;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/show")
public class UserController {
    private final DataService dataService;
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(DataService dataService,
                          UserService userService,
                          UserMapper userMapper) {
        this.dataService = dataService;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public String showListOfUsers(Model model) {
        UserApiDto apiDto = dataService.getData("https://randomuser.me/api/?results=20",
                UserApiDto.class);
        for (UserResponseDto dto : apiDto.getResults()) {
            userService.add(userMapper.mapToEntity(dto));
        }
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "main";
    }

    @GetMapping("/user")
    public String getUserInfo(@RequestParam Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("picture", user.getPicture().getMedium());
        model.addAttribute("name", user.getName().getTitle() + " "
                + user.getName().getFirst() + " " + user.getName().getLast());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("location", user.getLocation().getCountry()
                + "," + user.getLocation().getCity());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("registered", user.getRegistered().getDate());
        return "user_page";
    }
}
