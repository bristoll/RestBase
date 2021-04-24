package com.bristoll.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bristoll.Entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
