package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.InvalidCredentialsException;
import com.blogs.dto.AuthDTO;
import com.blogs.dto.UserRespDTO;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;
@Service 
@Transactional
public class UserServiceImpl implements UserService {
	// dependency
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO authenticateUser(AuthDTO dto) {
		System.out.println("in service "+dto);
		//1. pass em n pass to repos method
		User user=userRepository.findByEmailAndPassword(dto.getEmail(),dto.getPwd()).orElseThrow(() ->
		new InvalidCredentialsException("Invalid Email or password !!!!"));
		
		return mapper.map(user,UserRespDTO.class);
		
	}


}
