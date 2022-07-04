package com.filmster.exception;

public class UserNotFound extends ApplicationException{

    public UserNotFound(Long userId) {
        super(String.format("User id=[%s] not found", userId));
    }

    public UserNotFound(String username) {
        super(String.format("User with username=[%s] not found", username));
    }

//    public UserNotFound(String email) {
//        super(String.format("User with email=[%s] not found", email));
//    }

}
