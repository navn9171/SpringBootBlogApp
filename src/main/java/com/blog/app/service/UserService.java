package com.blog.app.service;

import com.blog.app.dto.RegistrationUserRequestDTO;
import com.blog.app.dto.RegistrationUserResponseDto;
import com.blog.app.dto.UserListingDto;
import com.blog.app.entity.User;

import java.util.List;

public interface UserService {
	RegistrationUserResponseDto registerUser(RegistrationUserRequestDTO registrationUserRequestDTO);

	List<UserListingDto> getAllUsers();

	UserListingDto getUserById(Integer id);

	UserListingDto updateUser(RegistrationUserRequestDTO user, Integer id);

	void deleteUser(Integer id);
}
