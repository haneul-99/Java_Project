package com.project.ssm.rental;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;
import com.project.ssm.user.User;
import com.project.ssm.rental.RentalInterface;

/**
 * 시설 대여 인터페이스입니다.
 * @author yangha-eun
 *
 */
public class RentalInterface {

	//public static String finalId = "";

	/*
	시설 예약 인터페이스 
	*/
	public void Rental() {

		String name = "";

		Scanner sc = new Scanner(System.in);

		for (User u : Data.userList) {

			if (LoginService.finalId.equals(u.getId())) {
				name = u.getName();
			}
		}
		
		User user = new User();
		
		System.out.println("===============================");
		System.out.printf("    [%s]님의 시설 대여\n", name);
		System.out.println("===============================");

		boolean loop = true;

		while (loop) {
			
			System.out.println();
			System.out.println("⡇⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⡇");
			System.out.println("⡇    1. 체육관     ⡇    2. 스터디룸    ⡇");
		    System.out.println("⡇⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⡇");
		    System.out.println("⡇    3. 소강당     ⡇    4. 운동장      ⡇");
		    System.out.println("⡇⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⡇");
		    System.out.println("⡇5. 나의 예약 현황 ⡇  0. 뒤로가기      ⡇");
		    System.out.println("⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉");
			
			System.out.println();
			System.out.print("메뉴 선택: ");

			String sel = sc.nextLine();

			if (sel.equals("1")) {
				// 체육관
				gym gym = new gym();
				gym.begin();
				
			} else if (sel.equals("2")) {
				// 스터디룸
				studyroom studyroom = new studyroom();
				studyroom.begin();
			} else if (sel.equals("3")) {
				// 소강당
				auditorium auditoriumService = new auditorium();
				auditoriumService.begin();
			} else if (sel.equals("4")) {
				// 운동장
				Playground PlaygroundService = new Playground();
				PlaygroundService.begin();
			} else if (sel.equals("5")) {
				// 나의 예약 현황
				myRentalList myRentalService = new myRentalList();
				myRentalService.mainInterface();

			} else if (sel.equals("0")) {
				loop = false;
			}
		}

		// Data.save();

	}

}
