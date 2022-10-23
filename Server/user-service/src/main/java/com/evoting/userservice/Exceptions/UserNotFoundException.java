package com.evoting.userservice.Exceptions;

import java.util.UUID;
public class UserNotFoundException extends Throwable {
    public UserNotFoundException(UUID id) {
        super("Cannot found user number [" + id + "]");
    }
}
