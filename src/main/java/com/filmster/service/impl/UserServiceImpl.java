package com.filmster.service.impl;

import com.filmster.dto.UserDTO;
import com.filmster.exception.UserNotFound;
import com.filmster.mapper.UserMapper;
import com.filmster.repository.UserRepository;
import com.filmster.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public List<UserDTO> allUsers() {
        return userMapper.mapToDto(userRepository.findAll());
    }

    @Override
    public UserDTO findUserById(Long id) {
        return userMapper.mapToDto(userRepository.findById(id).orElseThrow(() -> new UserNotFound(id)));
    }
}
