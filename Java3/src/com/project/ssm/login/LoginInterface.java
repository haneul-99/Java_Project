package com.project.ssm.login;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project.ssm.board.BoardInterface;
import com.project.ssm.data.Data;
import com.project.ssm.matching.MatchingInterface;
import com.project.ssm.matching.MatchingResultUser;
import com.project.ssm.rental.RentalInterface;
import com.project.ssm.user.User;

/**
 * 회원으로 로그인 했을 때 나오는 클래스 입니다.
 * @author HaNeul
 *
 */
public class LoginInterface {

	 /**
	    * 회원 로그인 후 뜨는 화면 메소드입니다.
	    */
	public void loginMenu() {
		
		String name = "";
		
		Scanner scan = new Scanner(System.in);
		
		for(User u : Data.userList) {
			
			if(LoginService.finalId.equals(u.getId())) {
				name = u.getName();
			}
		}
		
		boolean loop = true;
		
		while(loop) {
			
			User user = new User();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t⡏⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠹");
			System.out.println("\t\t\t\t⡇⢀⣾⠛⠛⢻⣦	⢀⣾⠛⠛⢻⣦	⣿⣿⡀⠀⣼⣿⡇ ⡇");
			System.out.println("\t\t\t\t⡇ ⠻⣷⣶⣤⣀⠀	 ⠻⣷⣶⣤⣀  	⣿⠸⣇⢰⡿⢻⡇ ⡇");
			System.out.println("\t\t\t\t⡇⢠⣤⠀⠈⢹⣿	⢠⣤⠀⠈⢹⣿	⣿⠀⢿⣿⠇⢸⡇ ⡇");
		    System.out.println("\t\t\t\t⡇ ⠙⠻⠿⠛⠋ 	 ⠙⠻⠿⠛⠋		⠛⠀⠘⠛⠀⠘⡇ ⡇");
		    System.out.println("\t\t\t\t⣇⣀⣀⣀⣀⣀⣀⣄⣀⣀⣀⣀⣀⣀⣀⣀⣄⣀⣀⣀⣠⣀⣀⣄⣀⣀⣀⣠⣀⣀⣀⣰");
		    System.out.println();
			System.out.printf("\t\t\t\t\t  [%s]님 환영합니다.\n", name);
			System.out.println("\t\t\t\t\t--------------------------");
			System.out.println();
			System.out.println(" ________________________________________________         ________________________________________________\n"
							 + "╿ 　　　　　　　　　　                        　╽        ╿ 　　　　　　　　　　                        　╽\n"
							 + "╿ 　　           * 매칭 알림 *　           　 　╽        ╿ 　　             * 공지사항 *　          　 　╽\n" 
							 + "╿_______________________________________________╽        ╿_______________________________________________╽\n");
			matchingAlarmCategory();
			schedule();
			matchingAlarm();
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t  ========================================");
	        System.out.println("\t\t\t\t        1. 게시판         2. 매칭 ");
	        System.out.println("\t\t\t\t        3. 시설대여       4. My Page"); 
	        System.out.println("\t\t\t\t        0. 로그아웃");
	        System.out.println("\t\t\t\t  ========================================");
			
			
			System.out.println();
			System.out.print("\t\t\t\t  ▶ 메뉴 선택: ");
				
			String sel = scan.nextLine();
				
			if (sel.equals("1")) {
				
				//1. 게시판
				BoardInterface boardInterface = new BoardInterface();
				boardInterface.boardMain();
				
			} else if (sel.equals("2")) {
					
				//2. 매칭
				MatchingInterface matching = new MatchingInterface();
				matching.begin();
				
			} else if (sel.equals("3")) {
				
				//3. 시설 대여
				RentalInterface rentalInterface = new RentalInterface();
				rentalInterface.Rental();
				
			} else if (sel.equals("4")) {
					
				//4. My Page
				MyPageService myPageService = new MyPageService();
				myPageService.myPage();
				
			} else if (sel.equals("0")) {
					
				//5. 로그아웃
				//로그아웃을 누르면 메인화면으로 돌아감.
				loop = false;
				
			} else {
				
				//0. 종료
				loop = false;
			}
		}//while
	}//loginMenu()

	/**
	 * 매칭알람 확인 메소드입니다.
	 */
	private void matchingAlarmCategory() {
		
		boolean check = false;
		//10,1,양하은,24,의예과,여자,20176870,최나형,24,유아교육과,남자,운동
		for(int i=Data.matchingResultUserList.size()-1; i>=0; i--) {
			if(Data.matchingResultUserList.get(i).getOtherId().equals(LoginService.finalId)) {
				System.out.print("\t           🚨" + Data.matchingResultUserList.get(i).getCategory() + "🚨");
				System.out.println();
				String tel = "";
				for(User u : Data.userList) {
					if(u.getId().equals(Data.matchingResultUserList.get(i).getMyId())) {
						tel = u.getTel();
					}
				}
				
				
				
				check = true;
			}
		}
		
		if(!check) {
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println("          매칭 알람이 없습니다.");
			System.out.println("----------------------------------------");
			System.out.println();
		}
		
	}
	
	private void matchingAlarm() {
		
		boolean check = false;
		//10,1,양하은,24,의예과,여자,20176870,최나형,24,유아교육과,남자,운동
		for(int i=Data.matchingResultUserList.size()-1; i>=0; i--) {
			if(Data.matchingResultUserList.get(i).getOtherId().equals(LoginService.finalId)) {
				
				String tel = "";
				for(User u : Data.userList) {
					if(u.getId().equals(Data.matchingResultUserList.get(i).getMyId())) {
						tel = u.getTel();
					}
				}
				System.out.println("      [이름]\t[나이]\t[성별]\t[전화번호]");
				System.out.println();
				System.out.printf("      %s%6s%6s  %15s",Data.matchingResultUserList.get(i).getMyName()
												,Data.matchingResultUserList.get(i).getMyAge()
												,Data.matchingResultUserList.get(i).getMyGender()
												,tel);
				
				
				check = true;
			}
		}
		
		if(!check) {
			
		}
		
	}

	/**
	 * 스케줄 알림 메소드입니다.
	 */
	private void schedule() {
		
		ArrayList<String> scheduleTime = new ArrayList<String>();
		
		Calendar now = Calendar.getInstance();
		
		Calendar scheduleCal = Calendar.getInstance();

		for(int i=0; i<Data.scheduleList.size(); i++) {
			
			String[] temp = Data.scheduleList.get(i).split(",");
			
			String[] day = temp[0].split("/");
			
			int month = Integer.parseInt(day[0]);
			int date = Integer.parseInt(day[1]);
			
			scheduleCal.set(2022, month, date);
			
			if(Integer.parseInt(day[0]) == now.get(Calendar.MONTH)+1 && Integer.parseInt(day[1]) > now.get(Calendar.DATE)) {
		
				scheduleTime.add(Data.scheduleList.get(i));
					
			}
			else if(Integer.parseInt(day[0]) > now.get(Calendar.MONTH)+1) {
				
				scheduleTime.add(Data.scheduleList.get(i));
				
			}
			
		}
		
		
		String[] temp = scheduleTime.get(0).split(",");
		
		if(temp[0].equals(temp[1])) {
			String[] temp2 = temp[0].split("/");
			
			System.out.print("\t\t\t\t\t\t\t\t        " + "🚨" +temp2[0] + "월 " + temp2[1] + "일 " + temp[2] + "🚨");
			System.out.println();
		}	
		
	}

	private void logOut() {
		
		
	}

}
