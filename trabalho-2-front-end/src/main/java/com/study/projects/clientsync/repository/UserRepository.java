package com.study.projects.clientsync.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.projects.clientsync.models.User;

public interface UserRepository extends CrudRepository<User, String>{

User findById(int id);

}
