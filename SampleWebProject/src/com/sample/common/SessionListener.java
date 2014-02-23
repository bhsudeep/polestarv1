package com.sample.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoader;

import com.sample.security.CustomUser;
import com.sample.security.UserTracker;


public class SessionListener implements HttpSessionListener{

	private static final Logger logger = Logger
			.getLogger(SessionListener.class);
	private static final String CLASS_NAME = SessionListener.class.getName();
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent session) {
		System.out.println("session created"+session.getSession().getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent session) {
		logger.debug("Entering " + CLASS_NAME + " sessionDestroyed");
	
	
	//remove from UserTracker
	ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
	Authentication auth = SecurityContextHolder.getContext()
			.getAuthentication();
	String username = (String) session.getSession().getAttribute("userName");
	if(null != auth){
	CustomUser principal = (CustomUser) auth.getPrincipal();
	UserTracker.decrement(principal.getUsername()); 
	}else if(null != username && !"".equalsIgnoreCase(username))
	{
		UserTracker.decrement(username); 
		
	}

	//remove session attributes	
	removeSessionAttributes(session);
	
	System.out.println("session destroyed"+session.getSession().getId());
		logger.debug("Exiting " + CLASS_NAME + " sessionDestroyed");
	}

	/**
	 * @param session
	 */
	private void removeSessionAttributes(HttpSessionEvent session) {
		String resourcesCoordinatorSearch = (String) session
			.getSession().getAttribute("resourcesCoordinator");
		session.getSession().removeAttribute("resourcesCoordinator");
		if(resourcesCoordinatorSearch!=null){
			resourcesCoordinatorSearch=null;
		}
		String clientNameSearch=(String)session.getSession().getAttribute("clientName");
		session.getSession().removeAttribute("clientName");
		if(clientNameSearch!=null){
			clientNameSearch=null;
		}
		
		String enagagementCodeSearch=(String)session.getSession().getAttribute("engagementCode");
		session.getSession().removeAttribute("engagementCode");
		if(enagagementCodeSearch!=null){
			enagagementCodeSearch=null;
		}
		String createdOnSearch=(String)session.getSession().getAttribute("createdOn");
		session.getSession().removeAttribute("createdOn");
		if(createdOnSearch!=null){
			createdOnSearch=null;
		}
		Long selectedStatus=(Long)session.getSession().getAttribute("selectedStatus");
		session.getSession().removeAttribute("selectedStatus");
		if(selectedStatus!=null){
			selectedStatus=null;
		}
		Long selectedRegionsearch=(Long)(session.getSession().getAttribute("selectedRegion"));
		session.getSession().removeAttribute("selectedRegion");
		if(selectedRegionsearch!=null){
			selectedRegionsearch=null;
		}
		Long selectedSubAreaSearch=(Long)(session.getSession().getAttribute("selectedSubArea"));
		session.getSession().removeAttribute("selectedSubArea");
		if(selectedSubAreaSearch!=null)
		{
			selectedSubAreaSearch=null;
		}
		Long selectedSubServicelineSearch =(Long)(session.getSession().getAttribute("selectedSubServiceline"));
		session.getSession().removeAttribute("selectedSubServiceline");
		if(selectedSubServicelineSearch!=null){
			selectedSubServicelineSearch=null;
		}
		
		String engRequestIdSearch=(String)(session.getSession().getAttribute("engRequestId"));
		session.getSession().removeAttribute("engRequestId");
		if(engRequestIdSearch!=null){
			engRequestIdSearch=null;
		}
		
		String userName=(String)(session.getSession().getAttribute("userName"));
		session.getSession().removeAttribute("userName");
		if(null != userName){
			userName=null;
		}
		
		
	}



}
