package com.satuamal.RestAPI.payloads;

import lombok.Data;

@Data
public class CityPayload {

	private String cityName;

	public String getCityName() {
		return cityName;
	}
	
	
}
