package com.project.ssm.admin;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;
import com.project.ssm.user.User;

/**
 * admin으로 로그인 했을 때 나오는 클래스 입니다.
 * @author yangha-eun
 *
 */
public class AdminInterface {

	/**
	    * 관리자 로그인 후 뜨는 화면 메소드입니다.
	    */
	public void adminMenu() {
		
	    Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println();
			System.out.println("      ============================");
			System.out.println("               관리자페이지");
			System.out.println("      ============================");
			
			System.out.println();
	        System.out.println("===========================================");
	        System.out.println("  1. 게시판 리스트         2. 매칭 리스트  ");
	        System.out.println("  3. 시설 대여 리스트      4 회원 리스트   ");
	        System.out.println("  5. 매칭 회원 리스트      0. 뒤로가기     ");
	        System.out.println("===========================================");
	        System.out.println();
		
			System.out.print("메뉴 선택: ");
				
			String sel = scan.nextLine();
			
			if(sel.equals("1")) {
				
				//1. 게시판리스트
				AdminBoard adminBoard = new AdminBoard();
				adminBoard.adminBoardInterface();
				
			} else if (sel.equals("2")) {
				
				//2. 매칭 리스트
				AdminMatchingInterface matching = new AdminMatchingInterface();
				matching.matchingInterface();
				
			} else if (sel.equals("3")) {
				
				//3. 시설 대여 리스트
				
			} else if (sel.equals("4")) {
				
				//4. 회원 리스트
				AdminUserList adminUserList = new AdminUserList();
				adminUserList.list();
				
			}else if(sel.equals("5")){
				AdminMatchingUserList matchingUser = new AdminMatchingUserList();
	            matchingUser.matchingUserList();
			}else {
				//0.뒤로가기
				loop = false;
			}//if
		}//while
	}//adminMenu

}
