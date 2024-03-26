package com.blog.app.service.Impl;

import com.blog.app.dto.RegistrationUserRequestDTO;
import com.blog.app.dto.RegistrationUserResponseDto;
import com.blog.app.dto.UserListingDto;
import com.blog.app.dtoMapper.UserDtoMapper;
import com.blog.app.entity.User;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.repository.UserRepository;
import com.blog.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public RegistrationUserResponseDto registerUser(RegistrationUserRequestDTO registrationUserRequestDTO) {
		System.out.println(registrationUserRequestDTO);
		User user = UserDtoMapper.userRequestDtoToUser(registrationUserRequestDTO);
		System.out.println(user);
		User savedUser = userRepository.save(user);
		return UserDtoMapper.userToUserDtoResponse(savedUser);
	}

	@Override
	public List<UserListingDto> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		List<UserListingDto> users = allUsers.stream()
				.map(user -> new UserListingDto(user.getId(), user.getName(), user.getEmail(), user.getAbout()))
				.collect(Collectors.toList());
		return users;
	}

	@Override
	public UserListingDto getUserById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found with the id: " + id));

		return new UserListingDto(user.getId(), user.getName(), user.getEmail(), user.getAbout());
	}

	@Override
	public UserListingDto updateUser(RegistrationUserRequestDTO user, Integer id) {
		User foundUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found with id: " + id));
		foundUser.setName(user.getName());
		foundUser.setEmail(user.getEmail());
//		foundUser.setPassword(user.getPassword());
		foundUser.setAbout(user.getAbout());
		User updatedUser = userRepository.save(foundUser);
		return new UserListingDto(updatedUser.getId(), updatedUser.getName(), updatedUser.getEmail(), updatedUser.getAbout());
	}

	@Override
	public void deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found with id: " + id));
		userRepository.deleteById(user.getId());
	}
}
