package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.clients.AuthenticationFeign;
import com.cognizant.model.Admin;

@Service
public class AuthFeignService {

	@Autowired
	private AuthenticationFeign authClient;

	public ResponseEntity<?> getToken(Admin usercredentials) {

		return authClient.login(usercredentials);
	}

	public boolean validate(String token) {

		return authClient.verifyToken(token);
	}
}