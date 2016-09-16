package com.dworks.security;

import org.springframework.security.oauth.provider.nonce.InMemoryNonceServices;
import org.springframework.stereotype.Component;

@Component
public class OAuthNonceServices extends InMemoryNonceServices {
	@Override
    public long getValidityWindowSeconds() {
        return 2000;
    }
}
