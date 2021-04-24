package com.bristoll.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bristoll.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
