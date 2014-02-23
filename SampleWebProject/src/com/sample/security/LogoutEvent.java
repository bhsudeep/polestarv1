
package com.sample.security;

import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.core.Authentication;

// TODO: Auto-generated Javadoc
/**
 * The Class LogoutEvent.
 */
public class LogoutEvent extends AbstractAuthenticationEvent {

    //~ Constructors ===================================================================================================

    /**
     * Instantiates a new logout event.
     * 
     * @param authentication the authentication
     */
    public LogoutEvent(Authentication authentication) {
        super(authentication);
    }
}