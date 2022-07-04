package com.filmster.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignUpDTO {

    private String name;
    private String username;
    private String email;
    private String password;

}
