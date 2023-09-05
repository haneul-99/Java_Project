package com.project.ssm.login;

import java.util.Scanner;

import com.project.ssm.admin.AdminInterface;
import com.project.ssm.data.Data;
import com.project.ssm.user.User;

public class LoginService {
	
	public static String finalId = "";

	public void login() {
		
		Scanner scan = new Scanner(System.in);
			
		System.out.println();
		System.out.println("========================");
		System.out.println("        로그인");
		System.out.println("========================");
		System.out.println();

		System.out.print("▶ 아이디(학번) : ");
		String id = scan.nextLine();
		
		System.out.print("▶ 비밀번호 : ");
		String pw = scan.nextLine();
		
		if(id.equals("admin") && pw.equals("1234")) {
			
			finalId = "관리자";
			
			AdminInterface adminInterface = new AdminInterface();
			adminInterface.adminMenu();
			
		}else{
			
			boolean check = false;
			
			for(User u : Data.userList) {
				
				if(u.getId().equals(id) && u.getPw().equals(pw)) {
					
					finalId = u.getId();
					
					LoginInterface login = new LoginInterface();
					login.loginMenu();
					
					check = true;

				}
				
			}
			
			if(!check) {
				
				System.out.println();
				System.out.println("ID(학번) 혹은 비밀번호가 틀렸습니다.");
				System.out.println();
				Data.pause();
				
			}
			
			
		}
		
		
	}

}
