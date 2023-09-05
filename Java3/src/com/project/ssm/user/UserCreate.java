package com.project.ssm.user;

import java.util.Scanner;

import com.project.ssm.data.Data;

/**
 * @author HaNeul
 * 회원가입 클래스입니다.
 */
public class UserCreate {

	public void sign() {
		
		String id = "";
		String pw = "";
		String name = "";
		String tel = "";
		String major = "";
		String jumin = "";
		String live = "";
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println();
			System.out.println("=================================================");
			System.out.println("                     회원가입" );
			System.out.println();
			System.out.println("- ID(학번)는 8자리로 입력해주세요.");
			System.out.println("- 비밀번호는 영문자+숫자 조합으로 6자리 이상으로 입력해주세요.");
			System.out.println();
				
			
			while(loop) {	
				
				System.out.println("===============================");
				System.out.print("아이디(학번): ");
				id = scan.nextLine();
				if(Data.idDuplication(id)) {
					if(Data.idCheck(id)) {
						break;
					} else {
						System.out.println("==================================");
						System.out.println("ID(학번)는 8자리로 입력해주세요.");
						Data.pause();
					}
					
				} else {
					System.out.println("===============================");
					System.out.println("중복된 아이디입니다.");
					Data.pause();
				}
				
			}
			
			while(loop) {
				System.out.println("===============================");
				System.out.print("비밀번호: ");
			    pw = scan.nextLine();
				if(Data.pwCheck(pw)) {
				
					break;
					
				} else {
					
					System.out.println("=============================================================");
					System.out.println("비밀번호는 영문자+숫자 조합으로 6자리 이상으로 입력해주세요.");
					Data.pause();
				}
			}
			while(loop) {
				System.out.println("===============================");
				System.out.print("이름: ");
				name = scan.nextLine();
				if(Data.nameCheck(name)) {
					
					break;
					
				} else {
					System.out.println("============================================");
					System.out.println("이름은 한글 조합으로 2~5자리로 입력해주세요.");
				}
			}
			while(loop) {
				System.out.println("===============================");
				System.out.print("전화번호: ");
				tel  = scan.nextLine();
				if(Data.telCheck(tel)) {
					
					break;
					
				} else {
					System.out.println("======================================");
					System.out.println("전화번호를 다시 입력해주세요.");
				}
			}
			
			while(loop) {
				System.out.println("==============================================");
				System.out.println("(컴퓨터학과, "
						+ "멀티미디어학과, "
						+ "간호학과, "
						+ "건축학과, "
						+ "유아교육과, \n"
						+ "경찰행정학과, "
						+ "식품영양학과, "
						+ "전자공학과, "
						+ "호텔경영학과, "
						+ "의예과 중 하나 선택)");
				System.out.println();
				System.out.print("학과: ");
				major = scan.nextLine();
				if(Data.majorCheck(major)) {
					
					break;
					
				} else {
					System.out.println();
					System.out.println("학교에 존재하지 않는 학과 입니다. 다시 입력해주세요.");	
				}
			}
		
			while(loop) {
				System.out.println("===============================");
				System.out.print("주민등록번호: ");
				jumin  = scan.nextLine();
				if(Data.juminCheck(jumin)) {
					
					break;
					
				} else {
					System.out.println("==================================");
					System.out.println("주민등록번호를 다시 입력해주세요.");
				}
			}
			
			while (loop) {
				System.out.println("====================================");
				System.out.print("거주유형(자취, 통학, 기숙사 중 선택): ");
			    live  = scan.nextLine();
			    if(Data.liveCheck(live)) {
			    	
			    	break;
			    	
			    } else {
			    	System.out.println("===============================");
			    	System.out.println("거주유형을 다시 입력해주세요.");
			    }
			}
			
			System.out.println();
			System.out.println("===============================");
			System.out.print("회원가입을 하시겠습니까?(Y/N): ");
			
			if(scan.nextLine().toLowerCase().equals("y")) {
				User user = new User();
				
				user.setId(id);
				user.setPw(pw);
				user.setName(name);
				user.setTel(tel);
				user.setMajor(major);
				user.setJumin(jumin);
				user.setLive(live);
					
				Data.userList.add(user);
				
				Data.save();
				
				System.out.println("===============================");
				System.out.println("회원이 되신 걸 축하드립니다.");
				System.out.println("===============================");
				loop = false;
				
				} else {
					System.out.println("===============================");
					System.out.println("회원가입을 취소합니다.");
					System.out.println("===============================");
					loop = false;
				}
			Data.pause();
			
		}
	}
}

