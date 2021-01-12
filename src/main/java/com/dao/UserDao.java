package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

public interface UserDao extends CrudRepository<User, String> {

}
