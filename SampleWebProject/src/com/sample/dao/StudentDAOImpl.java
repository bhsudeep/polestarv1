package com.sample.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.domain.TbUser;

import org.apache.log4j.Logger;

@Component("studentDAO")
public class StudentDAOImpl extends BaseDAO implements StudentDAO{
	
	
	private static final Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);
	private static final String ENTRYLOGGER = "Entering " + StudentDAOImpl.class.getName();
	private static final String EXITLOGGER = "Exiting " + StudentDAOImpl.class.getName();


	public TbUser getStudentDetailsByUsername(String username) {
		
		@SuppressWarnings("unchecked")
		List<TbUser> userList = getHibernateTemplate().find("from TbUser user where user.usrStrUserName = ?",username);
		
		return userList.get(0);
		
	}

	@Override
	public void addNewUser(TbUser newUser) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(ENTRYLOGGER + " addNewUser");
		}
		
		getHibernateTemplate().save(newUser);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(EXITLOGGER + " addNewUser");
		}
	}
	
}
