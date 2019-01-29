package com.yash.springsecuritywithmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.springsecuritywithmysql.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
