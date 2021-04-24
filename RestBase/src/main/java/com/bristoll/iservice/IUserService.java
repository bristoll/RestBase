package com.bristoll.iservice;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;

import com.bristoll.entity.User;

public interface IUserService {


	public List<User> findAllUsers()throws ServiceException;


	public Optional<User> findUserById(long id)throws ServiceException;
	

	public User saveUser(User user) throws ServiceException;
	

	public Optional<User> updateUserById(long id, String name) throws ServiceException;


	public void deleteUserById(long id)throws ServiceException;
}
