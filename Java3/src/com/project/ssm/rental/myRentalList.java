package com.project.ssm.rental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;

/**
 * 나의 예약 내역 인터페이스 메소드
 */
public class myRentalList {

	private ArrayList<String> myRentalList = new ArrayList<String>();
	private ArrayList<String> myGetRentalList = new ArrayList<String>();

	public void mainInterface() {

		Scanner scan = new Scanner(System.in);

		int num = 1;

		boolean loop = true;

		while (loop) {

			myRentalList.clear();
			num = 1;

			for (String rental : Data.gym) {

				String[] temp = rental.split(",");

				if (temp[6].equals(LoginService.finalId)) {
					myRentalList.add(rental);
				}

			}
			for (String rental : Data.studyroom) {

				String[] temp = rental.split(",");

				if (temp[6].equals(LoginService.finalId)) {
					myRentalList.add(rental);
				}

			}
			for (String rental : Data.auditorium) {

				String[] temp = rental.split(",");

				if (temp[6].equals(LoginService.finalId)) {
					myRentalList.add(rental);
				}

			}
			for (String rental : Data.playground) {

				String[] temp = rental.split(",");

				if (temp[6].equals(LoginService.finalId)) {
					myRentalList.add(rental);
				}

			}
			System.out.println();
			System.out.println("				========================");
			System.out.println("  				     나의 예약 현황");
			System.out.println("				========================");
			System.out.println();

			System.out.println("번호\t예약날짜/시간\t\t\t예약자\t\t시설\t\t예약시각");
			System.out.println("-------------------------------------------------------------"
					+ "-----------------------------------------");

			if (!myRentalList.isEmpty()) {

				myGetRentalList.clear();

				for (String rental : myRentalList) {

					String[] temp = rental.split(",");

					String data = String.format("%d,%s,%s,%s,%s,%s,%s,%s", num, temp[0], temp[1], temp[2], temp[3],
							temp[6], temp[4], temp[5]);

					myGetRentalList.add(data);

					num++;

				}

				for (String frintRental : myGetRentalList) {

					String[] frinttemp = frintRental.split(",");

					System.out.printf("%4s\t%s/%s\t\t%s\t\t%s\t\t%s\n", frinttemp[0]
							, frinttemp[2]
							, frinttemp[3]
							, frinttemp[6] 
							, frinttemp[7]
							, frinttemp[4] 
					); // 내용

				}

			} else {
				System.out.println("작성한 글이 없습니다.");
			}

			System.out.println();
			System.out.print("글 선택(0.뒤로가기) : ");
			String select = scan.nextLine();

			if (!(select.equals("0"))) {

				rentalView(select);

			} else if (select.equals("0")) {

				loop = false;

			}

		}

	}

	/**
	 * 예약 내역 자세히 보기 메소드
	 */
	private void rentalView(String num) {

		Scanner scan = new Scanner(System.in);

		boolean check = false;

		for (String rental : myRentalList) {

			String[] temp = rental.split(",");

			if (temp[0].equals(num)) {

				check = true;

				System.out.println();
				System.out.println("[번호]\t[예약자]\t\t[예약 정보]\t\t\t[시설]");
				System.out.println("------------------------------------------------------------------------");
				System.out.printf(" %s\t%5s\t\t%s/%s\t\t%s\n",num,temp[4],temp[2],temp[2],temp[5]);
				System.out.println("------------------------------------------------------------------------");

				System.out.println();
				System.out.println("1. 예약 취소");
				System.out.println("0. 뒤로가기");
				System.out.println();

				System.out.print("메뉴 선택 : ");
				String select = scan.nextLine();

				if (select.equals("1")) {

					rentalCancel(num);

				} else if (select.equals("0")) {

				} else {

					System.out.println("잘못 입력하였습니다. 전 페이지로 넘어갑니다.");

				}

				break;

			}

			check = false;

		}
		if (!check) {

			System.out.println("잘못 입력하였습니다.");

		}

	}

	/**
	 * 예약취소 메소드
	 * @param num 취소 번호
	 */
	public void rentalCancel(String num) {

		// 1,2022/09/03/10:00~11:50,21729579,김현재,체육관

		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("해당 예약을 취소하시겠습니까?(Y/N) : ");
		String answer = scan.nextLine();

		answer = answer.toLowerCase();

		if (answer.equals("y")) {

			try {

				for (String rental : myRentalList) {

					String[] temp = rental.split(",");
					if (temp[0].equals(num)) {

						myGetRentalList.remove(rental);

						break;

					}

					if (temp[5].equals("체육관")) {

						for (String gym : Data.gym) {

							String[] gymtemp = gym.split(",");

							if (gymtemp[0].equals(temp[1])) {

								Data.gym.remove(gym);

								System.out.println("삭제하였습니다.");
								Data.pause();

								break;

							}

						}

					}
				}

			} catch (Exception e) {
				System.out.println("myRental.rentalCancel");
				e.printStackTrace();
			}

		} else {
			System.out.println();
			System.out.println("취소하였습니다.");
			Data.pause();
		}
	}

}
