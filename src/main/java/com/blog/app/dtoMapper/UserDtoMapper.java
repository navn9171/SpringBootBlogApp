package com.blog.app.dtoMapper;

import com.blog.app.dto.RegistrationUserRequestDTO;
import com.blog.app.dto.RegistrationUserResponseDto;
import com.blog.app.entity.User;

public class UserDtoMapper {

	public static RegistrationUserResponseDto userToUserDtoResponse(User user){
		return new RegistrationUserResponseDto(user.getId(), user.getEmail());
	}

	public static User userRequestDtoToUser(RegistrationUserRequestDTO registrationUserRequestDTO){
		return new User(registrationUserRequestDTO.getName(), registrationUserRequestDTO.getEmail(), registrationUserRequestDTO.getPassword(), registrationUserRequestDTO.getAbout());
	}
}
