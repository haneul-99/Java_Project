package com.project.ssm.main;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.findidpw.FindId;
import com.project.ssm.findidpw.FindPw;
import com.project.ssm.login.LoginService;
import com.project.ssm.user.UserCreate;

/**
 * 메인 클래스입니다.
 * @author yangha-eun
 *
 */
public class MainInterface {
	
	public static void main(String[] args) {
		
		Data.load();
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		while(loop) {
			
			System.out.println();
			System.out.println("⡏⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠹");
			System.out.println("⡇⢀⣾⠛⠛⢻⣦	⢀⣾⠛⠛⢻⣦	⣿⣿⡀⠀⣼⣿⡇ ⡇");
			System.out.println("⡇ ⠻⣷⣶⣤⣀⠀	 ⠻⣷⣶⣤⣀  	⣿⠸⣇⢰⡿⢻⡇ ⡇");
			System.out.println("⡇⢠⣤⠀⠈⢹⣿	⢠⣤⠀⠈⢹⣿	⣿⠀⢿⣿⠇⢸⡇ ⡇");
		    System.out.println("⡇ ⠙⠻⠿⠛⠋ 	 ⠙⠻⠿⠛⠋		⠛⠀⠘⠛⠀⠘⡇ ⡇");
		    System.out.println("⣇⣀⣀⣀⣀⣀⣀⣄⣀⣀⣀⣀⣀⣀⣀⣀⣄⣀⣀⣀⣠⣀⣀⣄⣀⣀⣀⣠⣀⣀⣀⣰");
		    System.out.println();
		    System.out.println("         쌍소매(쌍용 소울 매칭)           ");
	    
			System.out.println();
		    System.out.println("===========================================");
	        System.out.println("       1. 로그인         2. 회원가입 ");
	        System.out.println("       3. ID 찾기        4. PW 찾기"); 
	        System.out.println("       0. 종료");
	        System.out.println("===========================================");
			
	        System.out.println();
			System.out.print("▶ 메뉴 선택 : ");
			String select = scan.nextLine();
			
			if(select.equals("1")) {
				
				LoginService loginService = new LoginService();
				loginService.login();
				
			}else if(select.equals("2")) {
				
				UserCreate userCreate = new UserCreate();
				userCreate.sign();
				
			}else if(select.equals("3")) {
				
				FindId findId = new FindId();
				findId.myFindId();
				
			}else if(select.equals("4")) {
				
				FindPw findPw = new FindPw();
				findPw.myFindPw();
				
			}else if(select.equals("0")) {
				
				loop = false;
				
			}
			
			
		}
		
		Data.save();
		
		System.out.println();
		System.out.println("이용해 주셔서 감사합니다.");
		
		
	}

}
