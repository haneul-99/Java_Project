package com.project.ssm.login;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.main.MainInterface;
import com.project.ssm.user.User;

/**
 * 회원 자신의 정보를 확인 할 수 있는 클래스입니다.
 * @author HaNeul
 *
 */
public class MyPageService {

	 /**
	    * 회원 정보를 확인하는 메소드입니다.
	    */
	public void myPage() {
		
		String name = "";
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		for(User u : Data.userList) {
			
			if(LoginService.finalId.equals(u.getId())) {
				name = u.getName();
			}
		}
		
		while(loop) {
			
			System.out.println();
			System.out.println("      ===============================");
			System.out.printf("              [%s]님 My Page\n", name);
			System.out.println("      ===============================");
			System.out.println();
			
			System.out.println();
			System.out.println("⡇⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⡇");
			System.out.println("⡇   1. 회원정보수정   ⡇   2. 회원탈퇴         ⡇");
			System.out.println("⡇⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⡇");
			System.out.println("⡇               0. 뒤로가기                   ⡇");
			System.out.println("⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉");
			System.out.println();
			
			System.out.print("메뉴 선택: ");
			
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {
				
				//1. 회원정보수정
				edit();
			
			} else if (sel.equals("2")){
				
				//2. 회원탈퇴
				delete();
				loop = false;
			} else {
				loop = false;
			}
			Data.pause();
		}
	}

	 /**
	    * 회원 정보를 수정하는 메소드입니다.
	    */
	private void edit() {
		
		//1. 회원정보수정
		System.out.println();
		String name = "";
		Scanner scan = new Scanner(System.in);
		

		
		boolean loop = true;
		
		for(User u : Data.userList) {
			
			if(LoginService.finalId.equals(u.getId())) {
		
		System.out.println("====================================");
		System.out.printf("      [%s]님 회원 정보 수정\n", u.getName());
		System.out.println("====================================");
		System.out.println();
		
		
		
				System.out.println("===============================");
				System.out.println("     아이디(학번): " + u.getId());
				System.out.println("     비밀번호: " + u.getPw());
				System.out.println("     이름: " + u.getName());
				System.out.println("     전화번호: " + u.getTel());
				System.out.println("     학과: " + u.getMajor());
				System.out.println("     주민등록번호: " + u.getJumin());
				System.out.println("     거주유형: " + u.getLive());
				System.out.println("===============================");
				System.out.println();
			
		
		System.out.println("===============================");
		System.out.print("     1. 비밀번호: ");
		String pw = scan.nextLine();
		
		System.out.print("     2. 이름: ");
	    name = scan.nextLine();

		System.out.print("     3. 전화번호: ");
		String tel = scan.nextLine();
		
		System.out.print("     4. 학과: ");
		String major = scan.nextLine();
		
		System.out.print("     5. 거주유형: ");
		String live = scan.nextLine();
		System.out.println("===============================");
		
		System.out.println();
		System.out.print("  정말 회원 정보 수정을 하시겠습니까?(Y/N): ");
		
		String line = scan.nextLine();
		
		if(line.toLowerCase().equals("y")) {
			while(loop) {
				System.out.println("======================================");
				System.out.println("8. 저장하기");
				System.out.println("0. 취소하기");
				System.out.println();
				
				System.out.print("메뉴 선택: ");
					
				String sel = scan.nextLine();
					
				if (sel.equals("8")) {
					//8. 저장하기
					
					if(!pw.equals("")) {
						u.setPw(pw); 
					}
					
					if(!name.equals("")) {
						u.setName(name); 
					}
					
					if(!tel.equals("")) {
						u.setTel(tel); 
					}
					
					if(!major.equals("")) {
						u.setMajor(major); 
					}
					
					if(!live.equals("")) {
						u.setLive(live); 
					}
					
					Data.save();
					System.out.println();
					System.out.println("=====================================");
					System.out.println("    회원 정보 수정을 완료했습니다.");
					System.out.println("=====================================");
					Data.pause();
					} else {
						//0. 취소하기
						loop = false;
					}
				
			} 
		} else if(line.toLowerCase().equals("n")) {
			System.out.println();
			System.out.println("===============================");
			System.out.println("    회원정보 수정을 취소합니다.");
			System.out.println("===============================");
		} else {
			System.out.println("=====================================");
			System.out.println("    (Y/N) 중 하나를 입력해주세요.");
			System.out.println("=====================================");
			Data.pause();
		}
			}
		}
			
	}
		

	/**
	    * 회원 정보를 탈퇴하는 메소드입니다.
	    */
	private void delete() {
		
		//2. 회원탈퇴
		
		
		
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=================================");
		System.out.print("     ID(학번): ");
		String id = scan.nextLine();
			
		System.out.print("     비밀번호: ");
		String pw = scan.nextLine();
		System.out.println();
		System.out.print("정말 회원 탈퇴를 하시겠습니까?(Y/N): ");
		
		if(scan.nextLine().toUpperCase().equals("Y")) {
			boolean result = Data.deleterUserIdPw(id,pw); 
			if(result) {
				System.out.println("====================================");
				System.out.println("     회원 탈퇴가 완료되었습니다.");
				System.out.println("====================================");
				Data.save();
				
				Data.pause();
				
				MainInterface.main(null);
				
			} else {
				System.out.println("====================================");
				System.out.println("     회원 탈퇴에 실패했습니다.");
				System.out.println("====================================");
			}
		} else if(scan.nextLine().toUpperCase().equals("N")){
			System.out.println("====================================");
			System.out.println("    회원 탈퇴를 하지 않았습니다.");
			System.out.println("====================================");
		} else {
			System.out.println("====================================");
			System.out.println("    (Y/N) 중 하나를 입력해주세요.");
			System.out.println("====================================");
		}
	}
}
