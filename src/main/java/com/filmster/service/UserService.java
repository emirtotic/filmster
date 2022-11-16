package com.filmster.service;

import com.filmster.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> allUsers();
    UserDTO findUserById(Long id);
}
