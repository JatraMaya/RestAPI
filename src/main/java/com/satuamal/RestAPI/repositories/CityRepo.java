package com.satuamal.RestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satuamal.RestAPI.models.City;

public interface CityRepo extends JpaRepository<City, Integer>{

		City findBycityName(String city);
}
