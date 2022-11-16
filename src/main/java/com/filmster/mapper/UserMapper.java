package com.filmster.mapper;

import com.filmster.dto.UserDTO;
import com.filmster.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapToDto(User user);
    User mapToEntity(UserDTO userDTO);
    List<UserDTO> mapToDto(List<User> users);
    List<User> mapToEntity(List<UserDTO> userDTOS);

}
