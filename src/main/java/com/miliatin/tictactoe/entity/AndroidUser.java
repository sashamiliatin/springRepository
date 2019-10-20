package com.miliatin.tictactoe.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
public class AndroidUser {
    @Id
    @GeneratedValue
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    int id;
    String user_id;
    User user;
    public AndroidUser(){}

    public AndroidUser(String user_id, User user) {
        this.user_id = user_id;
        this.user = user;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
