package com.satuamal.RestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satuamal.RestAPI.exception.AuthException;
import com.satuamal.RestAPI.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email) throws AuthException;
}
