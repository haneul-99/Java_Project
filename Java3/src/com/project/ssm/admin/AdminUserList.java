package com.project.ssm.admin;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.user.User;

/**
 * 관리자 회원 리스트를 보여주는 클래스입니다.
 * @author HaNeul
 * 
 */
public class AdminUserList {

	/**
	    * 회원 리스트 메소드
	    */
	public void list() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		int no = 1;
		
		System.out.println();
		System.out.println("                   ========================");
		System.out.println("                           회원 리스트");
		System.out.println("                   ========================");
		System.out.println();
	
		System.out.println("[번호]\t[ID(학번)]\t[이름]\t[학과]\t\t[전화번호]");
		System.out.println("------------------------------------------------------------");
		for(User user : Data.userList) {
			
			System.out.printf("%3d  %12s %9s  %-8s%17s\n"
					            , no
					            , user.getId()
					            , user.getName()
					            , user.getMajor()
					            , user.getTel()
					   );
			no++;
		}

		while(loop) {
		
	    System.out.println();
	    System.out.println("1. 회원조회");
	    System.out.println("2. 회원삭제");
	    System.out.println("0. 뒤로가기");
		System.out.println();
		System.out.print("메뉴 선택: ");
		
		String sel = scan.nextLine();
		
		if(sel.equals("1")) {
				nextMenu();
			} else if(sel.equals("2")) {
				delete();
				loop = false;
			} else {
				loop = false;
			}
		}
		
		//일시 정지
		Data.pause();
		
	}//list

	/**
	    * @author HaNeul
	    * 관리자가 회원을 조회하는 메소드입니다.
	    */
	private void nextMenu() {
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		while(loop) {
			System.out.println("=============================");
			System.out.print("조회할 ID(학번) 입력: ");
		    String id = scan.nextLine();
		    String checkId = "";
		    
		    for(User user : Data.userList) {
		    	if(user.getId().equals(id)) {
					checkId = user.getId();
				}
		    }
		   
		    if(id.equals(checkId)) {
				
			    User user = Data.getUserId(id);
			    System.out.println("=============================");
			    System.out.println("ID(학번): " + user.getId());
			    System.out.println("비밀번호: " + user.getPw());
			    System.out.println("이름: " + user.getName());
			    System.out.println("전화번호: " + user.getTel());
				System.out.println("학과: " + user.getMajor());
				System.out.println("주민등록번호: " + user.getJumin());
				System.out.println("거주유형: " + user.getLive());
				System.out.println("=============================");
				
				System.out.println();
				System.out.println("1. 회원조회");
			    System.out.println("2. 회원삭제");
			    System.out.println("0. 뒤로가기");
				System.out.println();
				System.out.print("메뉴 선택: ");
			
				String sel = scan.nextLine();
				if(sel.equals("1")) {
					//1. 회원조회
					nextMenu();
				} else if(sel.equals("2")) {
					//2. 회원삭제
					delete();
					loop = false;
				} else {
					//0. 뒤로가기
					loop = false;
				}
			} else {
				System.out.println("================================================");
				System.out.println("  존재하지 않는 회원입니다. 다시 입력해주세요.");
				System.out.println("================================================");
				Data.pause();
			}
		}
		Data.pause();
	}
	
	 /**
	    * 관리자가 회원을 삭제하는 메소드입니다.
	    */
	private void delete() {
		
		//1. 회원삭제하기
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.println("=============================");
		System.out.print("삭제할 ID(학번) 입력: ");
		String id = scan.nextLine();
		
		boolean result = Data.deleteUser(id); 
		
		if(result) {
			System.out.println("=============================");
			System.out.println("     회원을 삭제했습니다.");
			System.out.println("=============================");
			Data.save();
		} else {
			System.out.println("=============================");
			System.out.println("  회원 삭제에 실패했습니다.");
			System.out.println("=============================");
		}
	}
}
