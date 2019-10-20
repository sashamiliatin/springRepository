package com.miliatin.tictactoe.service;

import com.miliatin.tictactoe.entity.AndroidUser;
import com.miliatin.tictactoe.entity.User;
import com.miliatin.tictactoe.repository.AndroidUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private AndroidUserRepository repository;

    @Autowired
    public UserService(AndroidUserRepository repository) {
        this.repository = repository;
    }

    public void createUser(String id , User user){
        AndroidUser androidUser = new AndroidUser(id, user);
        repository.save(androidUser);
    }

    public void updateUser(String id , User user){
        AndroidUser androidUser = getUser(id);
        androidUser.setUser(user);
    }

    public void deleteUser(String id){
        repository.delete(getUser(id));
    }

    public AndroidUser getUser(String id){
        return repository
                .findById(id)
                .orElseThrow();
    }
}
