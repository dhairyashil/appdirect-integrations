package com.dworks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth.provider.OAuthProcessingFilterEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dworks.security.CustomOAuthProviderProcessingFilter;
import com.dworks.security.OAuthConsumerDetailsService;
import com.dworks.security.OAuthNonceServices;

@SpringBootApplication
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Configuration
    @Order(1)
    public static class OAuthSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        private CustomOAuthProviderProcessingFilter customOAuthProvideProcessingFilter;

        @Autowired
        OAuthConsumerDetailsService oauthConsumerDetailsService;

        @Autowired
        OAuthNonceServices oauthNonceServices;

        @Autowired
        OAuthProcessingFilterEntryPoint oauthProcessingFilterEntryPoint;

        @PostConstruct
        public void init() {
            customOAuthProvideProcessingFilter =
                    new CustomOAuthProviderProcessingFilter(
                            oauthConsumerDetailsService,
                            oauthNonceServices,
                            oauthProcessingFilterEntryPoint);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	http.csrf().disable();
        	http.authorizeRequests().antMatchers("/console/**").permitAll();
        	http.headers().frameOptions().disable();

            http.antMatcher("/subscription/*")
                    .addFilterBefore(customOAuthProvideProcessingFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests().anyRequest().hasRole("USER");
        }
    }

}
