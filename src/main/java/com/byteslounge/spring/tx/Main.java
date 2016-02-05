package com.byteslounge.spring.tx;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.byteslounge.spring.tx.model.User;
import com.byteslounge.spring.tx.user.UserManager;

public class Main {
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		System.err.println("start ....");
		ctx = new ClassPathXmlApplicationContext("spring.xml");
		UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");

		User user = new User();
//		user.setUsername("johndoe");
//		user.setName("John Doe");
//		userManager.insertUser(user);

		System.out.println("User inserted!");

		user = userManager.getUser("q1");

		System.out.println("\nUser fetched by username!" + "\nId: " + user.getId() + "\nUsername: " + user.getUsername()
				+ "\nName: " + user.getName());

		user = userManager.getUserById(2);

		System.out.println("\nUser fetched by ID!" + "\nId: " + user.getId() + "\nUsername: " + user.getUsername()
				+ "\nName: " + user.getName());

		List<User> users = userManager.getUsers();

		System.out.println("\nUser list fetched!" + "\nUser count: " + users.size());
		
		for (User u : users) {
			System.out.println(u);
		}
	}
}
