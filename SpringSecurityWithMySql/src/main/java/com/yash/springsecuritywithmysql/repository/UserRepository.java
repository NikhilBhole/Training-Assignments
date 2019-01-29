package com.yash.springsecuritywithmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.springsecuritywithmysql.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByusername(String username);

}
