package com.canftin.demo.repository;

import com.canftin.demo.domain.User;

import java.util.List;

public interface UserRepository {

	User saveOrUpdateUser(User user);

	void deleteUser(Long id);

	User getUserById(Long id);

	List<User> listUser();
}
