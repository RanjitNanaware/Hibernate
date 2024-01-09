package Hibernate_UserManagemnt.controller;

import java.util.Scanner;

import Hibernate_UserManagemnt.dao.UserDao;
import Hibernate_UserManagemnt.dto.User;

public class UserController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		User user = new User();
		
		UserDao dao = new UserDao();
		
		System.out.println("Enter the choice \n1. signUp User \n2. Login User \n3. Exit");
		
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:{
			System.out.println("Enter the id");
			int  id = scanner.nextInt();
			System.out.println("Enter the name");
			String name = scanner.next();
			System.out.println("Enter the phone");
			long phone = scanner.nextLong();
			System.out.println("Enter the email");
			String email = scanner.next();
			System.out.println("Enter the password");
			String password = scanner.next();
		
			user.setId(id);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			
			dao.saveUser(user);
		}
			break;
		case 2 :{
			System.out.println("Enter the Email");
			String email = scanner.next();
			System.out.println("Enter the password");
			String password = scanner.next();
			
			boolean result = dao.loginUser(email, password);
			
			if(result) {
				System.out.println("Login SucessFully");
				dao.displayPassword(email);
				
				System.out.println("Enter The Choice \n1.Update Passwords \n2.LogOut");
				int key = scanner.nextInt();
				 
				switch (key) {
				case 1:
					System.out.println("Enter The FaceBook Password");
					String facebook = scanner.next();
					System.out.println("Enter The WhatsApp Password");
					String whatsapp = scanner.next();
					System.out.println("Enter The Twitter Password");
					String twitter = scanner.next();
					System.out.println("Enter The SnapChat Password");
					String snapchat = scanner.next();
					System.out.println("Enter The InstaGram Password");
					String instagram = scanner.next();
					
					user.setFacebook(facebook);
					user.setWhatsapp(whatsapp);
					user.setTwitter(twitter);
					user.setSnapchat(snapchat);
					user.setInstagram(instagram);
					
					dao.updatePassword(email, user);
					dao.displayPassword(email);
					
					break;

				default:
					break;
				}
				
				
			}else {
				System.out.println("Invalid credential");
			}
			
		}
			break;
		default:
			break;
		}
		
	}
}
