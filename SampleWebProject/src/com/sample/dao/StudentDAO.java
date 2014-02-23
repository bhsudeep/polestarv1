package com.sample.dao;

import com.sample.domain.TbUser;

public interface StudentDAO {

	TbUser getStudentDetailsByUsername(String username);

	void addNewUser(TbUser newUser);

}
