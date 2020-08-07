package com.apex.mongodb.bao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.apex.mongodb.dao.*;
import com.apex.mongodb.vo.User;

@Service
@Component
public class UserBOImpl {
	
	@Autowired
	UserDAO usrDAO;

	
	public User getUser(String firstname) throws Exception {
		// 2a: validation
		// 2b: db interaction
		User user = usrDAO.getUser(firstname);
		return user;
	}
	
	public User getUserbyID(String id) throws Exception {
		// 2a: validation
		// 2b: db interaction
		User user = usrDAO.findUserId(id);
		return user;
	}


	public void addUser(User user) throws Exception {
		System.out.println("Entry:  UserBOImpl:addUsr()");
		// 2a: validation
		// 2b: db interaction
		usrDAO.addUser(user);
		System.out.println("Exit:  UserBOImpl:addUsr()");
		return;
	}
	
	public void updateUser(User user) {
		
		System.out.println("Entry:  UserBOImpl:updateUsr()");
		// 2a: validation
		// 2b: db interaction
		usrDAO.updateUser(user);
		System.out.println("Exit:  UserBOImpl:updateUsr()");
		return;
		
	}
	
	public void deleteUser(String firstname) {
		
		System.out.println("Entry:  UserBOImpl:deleteUsr()");
		// 2a: validation
		// 2b: db interaction
		usrDAO.deleteUser(firstname);
		System.out.println("Exit:  UserBOImpl:deleteUsr()");
		return;
		
	}
	
	public  List getUserList() throws Exception {
		
		System.out.println("getUserList() start()");
		 List userlist = usrDAO.getAll();
		System.out.println("getUserList() end()");
		return userlist;
	}

//	public UserDAO getUsrDAO() {
//		return usrDAO;
//	}
//
//	public void setUsrDAO(UserDAO usrDAO) {
//		this.usrDAO = usrDAO;
//	}

}
