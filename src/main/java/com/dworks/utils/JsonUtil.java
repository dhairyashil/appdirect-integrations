package com.dworks.utils;

import java.io.IOException;

import com.dworks.exceptions.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object deserializeJson(final String json, Class clazz) {
		try {
			return OBJECT_MAPPER.readValue(json, clazz);
		} catch (IOException e) {
			throw new JsonProcessingException("Error while parsing json");
		}
	}

	
}
