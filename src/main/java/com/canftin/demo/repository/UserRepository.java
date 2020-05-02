package com.canftin.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.canftin.demo.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
