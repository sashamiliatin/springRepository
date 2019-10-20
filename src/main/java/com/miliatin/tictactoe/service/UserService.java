package com.miliatin.tictactoe.service;
import com.miliatin.tictactoe.entity.AndroidUser;
import com.miliatin.tictactoe.entity.User;
import com.miliatin.tictactoe.repository.AndroidUserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    User users;
    String user_id;
    private AndroidUserRepository repository;
    private AndroidUser androidUser;

public void CreateUser(String id , User user){
    androidUser = new AndroidUser(id,user);
    repository.save(androidUser);
}

public void UpdateUser(String id , User user){
    androidUser = new AndroidUser(id,user);
    repository.save(androidUser);
}

public void DeleteUser(String id){

    repository.delete(GetUser(id));
}

public AndroidUser GetUser(String id){
    AndroidUser obj =  repository.findById(id).get();
    return obj;
}

}
