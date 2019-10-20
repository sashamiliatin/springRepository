package com.miliatin.tictactoe.repository;
import com.miliatin.tictactoe.entity.AndroidUser;
import com.miliatin.tictactoe.entity.User;
import org.apache.catalina.startup.ClassLoaderFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface AndroidUserRepository extends CrudRepository<AndroidUser,String> {

}
