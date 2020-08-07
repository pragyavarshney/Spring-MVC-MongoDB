package com.apex.mongodb.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apex.mongodb.bao.*;
import com.apex.mongodb.vo.*;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserBOImpl userBO;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	// GetUser
	@RequestMapping("/userEntry.do")
	public String entryGetUser(@ModelAttribute User user) {
		return "getuser";

	}

	@RequestMapping("/processUser.do")
	public String processGetUser(@RequestParam("personname") String name, Model model)
			throws NumberFormatException, Exception {
		System.out.println("UserController:processGetUser():start()");
		// Step1: get the vo
		System.out.println("User's Name:" + name);
		User user = new User();

		// step2
		// call the business object
		try {
			user = userBO.getUser(name);
			System.out.println("data recieved");
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Step 3: return view
		//System.out.println(userBO.getUser(name).getFirstName());
		System.out.println("UserController:processGetUser():end()");

		model.addAttribute("user", user);
		return "viewsuccess";

	}
	
	@RequestMapping("/processUserId.do")
	public String processGetUserId(@RequestParam("personid") String id, Model model)
			throws NumberFormatException, Exception {
		System.out.println("UserController:processGetUser():start()");
		// Step1: get the vo
		System.out.println("User's ID:" + id);
		User user = new User();

		// step2
		// call the business object
		try {
			user = userBO.getUserbyID(id);
			System.out.println("data recieved");
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Step 3: return view
		System.out.println("UserController:processGetUser():end()");

		model.addAttribute("user", user);
		return "viewsuccess";

	}

	// GetAll
	@RequestMapping("/processViewAll.do")
	public String processViewAll(Model model) throws SQLException {

		System.out.println("userController: processViewAll():start()");
		// Step 1: get the value OBJ
		 List user = null;

		// Step2: call the BO

		try {

			user = userBO.getUserList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Step3: return the view
		model.addAttribute("pinfo", user);
		System.out.println("userController: processViewAll():end()");
		return "viewall";
	}

	// AddUser
	@RequestMapping("/userAdd.do")
	public String entryAddUser(@ModelAttribute User user) {
		return "adduser";

	}

	@RequestMapping("/processAddUser.do")
	public String processAddUser(@ModelAttribute("user") User user) {

		System.out.println("userController: processAddUser():start()");
		// Step 1: get the value OBJ
		System.out.println("First Name: " + user.getFirstName());

		// Step2: call the BO
		try {
			userBO.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Step3: return the view
		System.out.println("userController: processAddUser:end()");
		return "home";

	}

	// DeleteUser

	@RequestMapping("/deleteEntry.do")
	public String entryDeleteUser(@ModelAttribute User user) {
		return "delete";

	}

	@RequestMapping("/deleteUser.do")
	public String processDeleteUser(@RequestParam("personid") String name, Model model)
			throws NumberFormatException, Exception {
		System.out.println("UserController:pprocessDeleteUser():start()");
		// Step1: get the vo
		System.out.println("User's Name:" + name);

		// step2
		// call the business object
		try {
			userBO.deleteUser(name);
			System.out.println("data deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Step 3: return view

		System.out.println("UserController:processDeleteUser():end()");
		return "home";

	}

	// UpdateUser

	@RequestMapping("/modifyEntry.do")
	public String entryUpdateUser(@ModelAttribute User user) {
		return "update";

	}

	@RequestMapping("/processupdateUser.do")
	public String processUpdateUser(@RequestParam("personid") String name, Model model)
			throws NumberFormatException, Exception {
		System.out.println("UserController:processUpdateUser():start()");
		// Step1: get the vo
		System.out.println("User's Name:" + name);
		User user = new User();
		// step2
		// call the business object
		try {
			user = userBO.getUser(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Step 3: return view
		model.addAttribute("user", user);
		System.out.println("UserController:processUpdateUser():end()");
		return "updateedit";
	}

	@RequestMapping("/updateUser.do")
	public String UpdateUser(@ModelAttribute("user") User user) throws NumberFormatException, Exception {
		System.out.println("UserController:UpdateUser():start()");
		// Step1: get the vo

		// step2
		// call the business object
		try {
			userBO.updateUser(user);
			System.out.println("data update");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Step 3: return view

		System.out.println("UserController:UpdateUser():end()");
		return "home";

	}
}
