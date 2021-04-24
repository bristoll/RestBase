package com.bristoll.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bristoll.entity.User;
import com.bristoll.iservice.IUserService;
import com.bristoll.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> findAllUsers() throws ServiceException {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public Optional<User> findUserById(long id) throws ServiceException {
		return userRepo.findById(id);
	}

	@Override
	public User saveUser(User user) throws ServiceException {
		return userRepo.save(user);
	}

	@Override
	public Optional<User> updateUserById(long id, String name) throws ServiceException {
		Optional<User> userOp = userRepo.findById(id);
		User user = null;
		if (userOp.isPresent()) {
			user = userOp.get();
			user.setName(name);
			userRepo.save(user);
		}
		return Optional.of(user);
	}

	@Override
	public void deleteUserById(long id) throws ServiceException {
		 userRepo.deleteById(id);
	}

}
