package com.dworks.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth.common.OAuthException;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.provider.BaseConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetailsService;
import org.springframework.stereotype.Component;

@Component
public class OAuthConsumerDetailsService implements ConsumerDetailsService {

	final static Logger log = LoggerFactory.getLogger(OAuthConsumerDetailsService.class);

    @Value("${oauth.consumer.key}")
    private String oauthConsumerKey;

    @Value("${oauth.consumer.secret}")
    private String oauthConsumerSecret;

    @Override
    public ConsumerDetails loadConsumerByConsumerKey(String consumerKey) throws OAuthException {
        BaseConsumerDetails cd;
        if (oauthConsumerKey.equals(consumerKey)) {
            cd = new BaseConsumerDetails();
            cd.setConsumerKey(consumerKey);
            cd.setSignatureSecret(new SharedConsumerSecretImpl(oauthConsumerSecret));
            cd.setRequiredToObtainAuthenticatedToken(false);
            cd.getAuthorities().add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new OAuthException("oauth keys are not matching");
        }
        return cd;
    }


}
