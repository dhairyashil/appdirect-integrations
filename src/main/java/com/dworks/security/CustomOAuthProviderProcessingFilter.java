package com.dworks.security;

import org.springframework.security.oauth.provider.OAuthProcessingFilterEntryPoint;
import org.springframework.security.oauth.provider.filter.ProtectedResourceProcessingFilter;

public class CustomOAuthProviderProcessingFilter extends ProtectedResourceProcessingFilter {
	public CustomOAuthProviderProcessingFilter(
            OAuthConsumerDetailsService oAuthConsumerDetailsService,
            OAuthNonceServices oAuthNonceServices,
            OAuthProcessingFilterEntryPoint oAuthProcessingFilterEntryPoint) {
        super();
        setAuthenticationEntryPoint(oAuthProcessingFilterEntryPoint);
        setConsumerDetailsService(oAuthConsumerDetailsService);
        setNonceServices(oAuthNonceServices);
    }
}
