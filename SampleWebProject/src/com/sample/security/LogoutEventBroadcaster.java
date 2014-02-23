package com.sample.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class LogoutEventBroadcaster.
 */
public class LogoutEventBroadcaster implements LogoutHandler, ApplicationContextAware {
	
	/** The log. */
	private Log log = LogFactory.getLog(LogoutEventBroadcaster.class);
	
	/** The application context. */
	private ApplicationContext applicationContext;

	/**
	 * Instantiates a new logout event broadcaster.
	 */
	public LogoutEventBroadcaster() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.acegisecurity.ui.logout.LogoutHandler#logout(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.acegisecurity.Authentication)
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
		if(auth != null) {
			LogoutEvent event = new LogoutEvent(auth);
			log.debug("publishing logout event: " + event);
			applicationContext.publishEvent(event);
			CustomUser principal = (CustomUser) auth.getPrincipal();
			UserTracker.decrement(principal.getUsername()); 
			request.getSession().invalidate();
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
