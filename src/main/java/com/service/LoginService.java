package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.dao.UserDao;
import com.model.User;

public class LoginService {

	@Autowired
	UserDao userDao;
	
	public boolean login(ModelMap m,String username, String password) {
		User u = userDao.findById(username).get();
		if(u!=null) {
			if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)){
				m.put("user", u);
				return true;
			}
		}
		return false;
	}
	
	
	public boolean register(String name, String pass, String email, String city) {
		try{
			userDao.save(new User(name,pass,email,city));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean edit(ModelMap m,String email,String city) {
		User u = (User)m.get("user");
		if (u!=null) {
			u.setEmail(email);
			u.setCity(city);
			userDao.save(u);
			System.out.println("Update successful");
			return true;
		}else {
			System.out.println("NOT UPDATED");
			return false;
		}
	}
}
