package com.miliatin.tictactoe.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class AndroidUser {
    @Id
    private String androidId;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id", nullable = false)
    private User user;

    public AndroidUser(String androidId, User user) {
        this.androidId = androidId;
        this.user = user;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
