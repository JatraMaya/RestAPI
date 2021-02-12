package com.satuamal.RestAPI.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satuamal.RestAPI.exception.AuthException;
import com.satuamal.RestAPI.models.City;
import com.satuamal.RestAPI.models.User;
import com.satuamal.RestAPI.payloads.UserPayload;
import com.satuamal.RestAPI.repositories.CityRepo;
import com.satuamal.RestAPI.repositories.UserRepo;

@RestController
@RequestMapping("/api/user/register")
public class RegistrationController {

	@Autowired
	CityRepo cityRepo;

	@Autowired
	UserRepo userRepo;

	@PostMapping
	public ResponseEntity<?> register(@RequestBody UserPayload userPayload) {
		try {
			City city = cityRepo.findBycityName(userPayload.getCity().toLowerCase());
			Pattern pattern = Pattern.compile("^(.+)@(.+)$");
			if (!pattern.matcher(userPayload.getEmail()).matches())
				throw new AuthException("Invalid email address");

			// If city is not found in the database add new city to the database
			if (city == null) {
				City newCity = new City(userPayload.getCity().toLowerCase());
				cityRepo.save(newCity);
				String hashPassword = BCrypt.hashpw(userPayload.getPassword(), BCrypt.gensalt(10));
				User user = new User(newCity, userPayload.getName(), userPayload.getEmail().toLowerCase(), hashPassword,
						userPayload.getAlias(), userPayload.getPhoneNumber(), userPayload.getRole(),
						userPayload.getStatus());
				user = userRepo.save(user);
				return new ResponseEntity<User>(user, HttpStatus.CREATED);
			} else {
				String hashPassword = BCrypt.hashpw(userPayload.getPassword(), BCrypt.gensalt(10));
				User user = new User(city, userPayload.getName(), userPayload.getEmail().toLowerCase(), hashPassword,
						userPayload.getAlias(), userPayload.getPhoneNumber(), userPayload.getRole(),
						userPayload.getStatus());
				user = userRepo.save(user);
				return new ResponseEntity<User>(user, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			Map<String, String> responseMap = new HashMap<>();
			responseMap.put("message", "email already in use");
			return new ResponseEntity<>(responseMap, HttpStatus.CONFLICT);
		}
	}
}
