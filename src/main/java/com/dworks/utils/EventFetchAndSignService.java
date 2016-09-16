package com.dworks.utils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dworks.dto.model.EventDTO;
import com.dworks.exceptions.JsonProcessingException;
import com.dworks.validator.OAuthSignerOrValidator;

@Service
public class EventFetchAndSignService {
	
	@Autowired
	private OAuthSignerOrValidator signerOrValidator;

	public EventDTO getEvent(String url) {
		EventDTO event = null;
		try {
			String signedUrl = signerOrValidator.sign(url);
			JSONObject jsonObject = new JSONObject(IOUtils.toString(new URL(signedUrl).openConnection().getInputStream(), StandardCharsets.UTF_8));
			event = (EventDTO) JsonUtil.deserializeJson(jsonObject.toString(), EventDTO.class);
			
		} catch (JSONException | IOException e) {
			throw new JsonProcessingException("Error in processing incoming Response");
		}
		return event;
	}
}
