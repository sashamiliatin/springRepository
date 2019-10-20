package com.miliatin.tictactoe.repository;

import com.miliatin.tictactoe.entity.AndroidUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AndroidUserRepository extends CrudRepository<AndroidUser, String> {

}
