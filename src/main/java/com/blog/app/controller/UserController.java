package com.blog.app.controller;

import com.blog.app.dto.RegistrationUserRequestDTO;
import com.blog.app.dto.RegistrationUserResponseDto;
import com.blog.app.dto.UserListingDto;
import com.blog.app.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping()
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationUserRequestDTO registrationUserRequestDTO){
		try{
			RegistrationUserResponseDto registrationUserResponseDto = userService.registerUser(registrationUserRequestDTO);
			return new ResponseEntity<>(registrationUserResponseDto, HttpStatus.CREATED);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("all")
	public ResponseEntity<?> getAllUsers(){
		try{
			List<UserListingDto> allUsers = userService.getAllUsers();
			return new ResponseEntity<>(allUsers, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id){
//		try{
			UserListingDto user = userService.getUserById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
//		}catch(Exception e){
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody RegistrationUserRequestDTO registrationUserRequestDTO){
		try{
			UserListingDto user = userService.updateUser(registrationUserRequestDTO, id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){
		try{
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
