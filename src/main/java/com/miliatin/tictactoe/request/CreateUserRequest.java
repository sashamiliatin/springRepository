package com.miliatin.tictactoe.request;

import com.miliatin.tictactoe.entity.User;

public class CreateUserRequest {
    private String userId;
    private User user;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
