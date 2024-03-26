package com.blog.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;

	public User(String name, String email, String password, String about){
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
}
