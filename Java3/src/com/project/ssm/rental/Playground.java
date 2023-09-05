package com.project.ssm.rental;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project.ssm.board.BoardService;
import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;
import com.project.ssm.rental.Rental;

/**
 * 운동장 클래스입니다.
 * @author 함원진
 *
 */
public class Playground {

	String id = LoginService.finalId;
	String name = Data.UserGetName();

	/**
	 * 인터페이스 출력하는 메소드
	 */
	public void begin() {

		boolean loop = true;

		Scanner sc = new Scanner(System.in);

		while (loop) {

			System.out.println("=========================");
			System.out.println("1.운동장 예약 내역 확인하기");
			System.out.println("2.운동장 예약 하기");
			System.out.println("0. 뒤로가기");
			System.out.println("=========================");
			System.out.print("선택: ");

			String sel = sc.nextLine();

			if (sel.equals("1")) {
				// 예약 현황 보기
				RentalList();
			} else if (sel.equals("2")) {
				
				String rentalCategory = "운동장";

				RentalService rentalService = new RentalService();
				rentalService.rental(rentalCategory);
				
			} else if (sel.equals("0")) {
				loop = false;

			}
		}
	}

	/**
	 * 예약 내역 확인 메소드
	 */
	private void RentalList() {
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("================");
		System.out.println("    날짜 선택  ");
		System.out.println("================");
		System.out.println();
		System.out.print("년도 : ");
		String year = sc.nextLine();
		System.out.print("월 : ");
		String month = sc.nextLine();
			
			int lastDay = getMaxDate(Integer.parseInt(year), Integer.parseInt(month));
			int dayOfWeek = getDayOfWeek(Integer.parseInt(year), Integer.parseInt(month));  //8월 1일의 요일
			
			System.out.println("====================================================");
			System.out.printf("                    %s년 %s월 \n", year, month);
			System.out.println("====================================================");
			System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
			
			for(int i=0; i<dayOfWeek; i++) {
			System.out.print("\t");
			}
			
			for(int i=1; i<=lastDay; i++) {
				System.out.printf("%3d\t",i);
				
				//토요일마다 개행
				//if(i % 7 == 6) {
				if((i + dayOfWeek) % 7 == 0) {
					System.out.println();
				}
				
			}
			
			System.out.println();
			System.out.println();
		
		System.out.print("일 : ");
		String date = sc.nextLine();
		
		if(Integer.parseInt(date) < 10) {
			date = "0" + date;
		}
		if(Integer.parseInt(month) < 10) {
			month = "0" + month;
		}

		String day = year + "-" + month + "-" + date;
		
		sc.nextLine();

		boolean loop = true;

		while (loop) {

			System.out.println("[날짜/시간]\t\t\t[시설]\t\t[예약가능여부]");
			System.out.println("-------------------------------------------------------------");

			for (Rental r : Data.rentalList) {
				if (r.getDate().equals(day) && r.getFacility().equals("운동장")) {

					System.out.printf("%s/%s\t\t%s\t\t\t%s\n", r.getDate(), r.getTime(), r.getFacility(),
							r.getReserve());

				}

			}

			System.out.println();
			System.out.print("번호 선택(0.뒤로가기) : ");
			String select = sc.nextLine();

			if (!(select.equals("0"))) {
			} else if (select.equals("0")) {
				loop = false;
			}

		}

	}
	
	/**
	 * 달력 출력 메소드
	 */
	private static int getDayOfWeek(int year, int month) {
		
		int sum = 0;
		int date = 1;
		
		for(int i=1; i<year; i++) {
			sum+=365;
			
			if(isLeafYear(year)) {
				sum++;
			}
		}
		
		for(int i=1; i<month; i++) {
			sum += getMaxDate(year, i);
		}
		
		sum += date;
		
		return sum % 7;
	}






	/**
	 * 달력 출력 메소드
	 */
	private static boolean isLeafYear(int year) {
		
		if(year % 4 == 0) {
			
			if(year % 100 == 0) {
				
				if(year % 400 == 0) {
					
					return true;
					
				}else {
					
					return false;
					
				}
				
			}else {
				
				return true;
				
			}
			
		}else {
			
			return false;
			
		}
	}







	private static int getMaxDate(int year, int month) {
		
		switch (month) {
		case 1 : 
		case 3 : 
		case 5 : 
		case 7 : 
		case 8 : 
		case 10 : 
		case 12 : 
			return 31;
		case 4 : 
		case 6 : 
		case 9 : 
		case 11 : 
			return 30;
		case 2 :
			return isLeafYear(year) ? 29 : 28;
		}
		return 0;
		
	}

}
