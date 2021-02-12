package com.satuamal.RestAPI.controllers;

import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satuamal.RestAPI.exception.AuthException;
import com.satuamal.RestAPI.models.User;
import com.satuamal.RestAPI.payloads.UserPayload;
import com.satuamal.RestAPI.repositories.UserRepo;

@RestController
@RequestMapping("/user/login")
public class LoginController {

	@Autowired
	UserRepo userRepo;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody UserPayload userPayload) {
				
		User user = userRepo.findByEmail(userPayload.getEmail());
		if(BCrypt.checkpw(userPayload.getPassword(), user.getPassword())) {
			Map<String, String> responseMap = new HashMap<>();
			responseMap.put("message", "Login success");
			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		}else {
			throw new AuthException("User Unauthorize");
		}	
	}
}
