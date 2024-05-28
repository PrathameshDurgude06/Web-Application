package com.blogs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.custom_exception.InvaidCredentialException;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service //mandatory cls level anno to tell sc folowing is spring bean containing B.L
//upto spring boot 3.3
@Transactional //for adding auto tx management support
public class UserServiceImpl implements UserService {
	//depdency
	@Autowired
	private UserRepository userRepository;

	@Override
	public User signInUser(String email, String pwd) {
		Optional<User> optional= userRepository.findByEmailAndPassword(email,pwd);
		return optional.orElseThrow(() -> new InvaidCredentialException("Invalid Email or Password"));
	}

}
