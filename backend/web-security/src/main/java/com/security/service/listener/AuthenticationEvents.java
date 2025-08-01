package com.security.service.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationEvents {
	
	@EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
		log.info(" Login success name: {} ", success.getAuthentication().getName());
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failures) {
    	log.info(" Login failure name: {}, exception: {} ", failures.getAuthentication().getName(), failures.getException().getMessage());
    }

}
