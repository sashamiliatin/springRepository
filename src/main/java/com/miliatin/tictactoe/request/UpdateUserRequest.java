package com.miliatin.tictactoe.request;

import com.miliatin.tictactoe.entity.User;

public class UpdateUserRequest {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
