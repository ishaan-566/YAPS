package com.services;

import com.DAO.LoginDao;
import com.beans.User;
import com.beans.UserCredentials;

public class LoginService {
	
	LoginDao ld = new LoginDao();
	public boolean login(UserCredentials user) {
		
		boolean flag = ld.login(user);
		return flag;
		
	}
	
	public boolean signup(UserCredentials user) {
		
		
		boolean flag = ld.signup(user);
		return flag;
		
	}

	public boolean logout(String user) {
		boolean flag = ld.logout(user);
		return flag;
	}

	public boolean register(User user) {
		boolean flag = ld.register(user);
		return flag;
	}

}
