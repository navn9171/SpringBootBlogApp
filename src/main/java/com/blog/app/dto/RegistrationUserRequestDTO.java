package com.blog.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegistrationUserRequestDTO {
	private int id;

	@NotEmpty
	private String name;
	@Email(message = "Please Enter email correctly.")
	private String email;
	@NotEmpty
	@Size(min = 5, max = 9, message = "Password must be between 5 to 9 characters.")
	private String password;
	@NotEmpty
	private String about;
}
