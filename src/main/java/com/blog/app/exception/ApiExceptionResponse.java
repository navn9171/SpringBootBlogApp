package com.blog.app.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiExceptionResponse {
	private String message;
	private boolean status;
}
