package ca.sheridancollege.tapnioc.models;

import lombok.Data;

@Data
public class AuthenticationResponse {
	private final String jwt;
}
