package com.dworks.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dworks.exceptions.UnauthorizedClientException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;

@Component
public class OAuthSignerOrValidator {
	
	@Value("${oauth.consumer.key}")
	private String oauthConsumerKey;

	@Value("${oauth.consumer.secret}")
	private String oauthConsumerSecret;

	public String sign(String url) {
		OAuthConsumer consumer = new DefaultOAuthConsumer(oauthConsumerKey, oauthConsumerSecret);
		String signedUrl = url;
		consumer.setSigningStrategy(new QueryStringSigningStrategy());
		try {
			signedUrl = consumer.sign(url+".json");
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
			throw new UnauthorizedClientException("Failed to create signed url.", e);
		}
		return signedUrl;
	}
}
