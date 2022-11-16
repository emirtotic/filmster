package com.filmster.dto;

import com.filmster.entity.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String username;
    private Set<Role> roles;
}
