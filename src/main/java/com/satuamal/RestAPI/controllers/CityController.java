package com.satuamal.RestAPI.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satuamal.RestAPI.models.City;
import com.satuamal.RestAPI.payloads.CityPayload;
import com.satuamal.RestAPI.repositories.CityRepo;

@RestController
@RequestMapping("api/v1/cities")
public class CityController {

	@Autowired
	CityRepo cityRepo;

	@GetMapping
	public ResponseEntity<List<City>> read() {
		List<City> cities = cityRepo.findAll();
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody CityPayload cityPayload) {
		try {
			City city = new City(cityPayload.getCityName().toLowerCase());
			city = cityRepo.save(city);
			return new ResponseEntity<City>(city, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			Map<String, String> responseMap = new HashMap<>();
			responseMap.put("message", "Duplicate city name found in the database");
			return new ResponseEntity<>(responseMap, HttpStatus.CONFLICT);

		}
	}
}
