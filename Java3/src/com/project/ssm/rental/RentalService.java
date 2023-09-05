package com.project.ssm.rental;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.project.ssm.board.BoardService;
import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;

/**
 * 예약 진행 메소드
 */
public class RentalService {

	ArrayList<String> rentalNum = new ArrayList<String>();

	String id = LoginService.finalId;
	String name = Data.UserGetName();

	/**
	 * 예약 취소 메소드
	 * @param num 취소 번호
	 * @param type 예약 시설
	 */
	public void rentalCancel(String num, String type) {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("해당 글을 삭제하시겠습니까?(Y/N) : ");
		String answer = scan.nextLine();
		System.out.println();

		answer = answer.toLowerCase();

		if (answer.equals("y")) {

			try {

				if (type.equals("freeBoard")) {

					for (String freeboard : Data.freeBoard) {

						String[] freetemp = freeboard.split(",");

						if (freetemp[0].equals(num)) {

							Data.freeBoard.remove(freeboard);
							break;

						}

					}

				} else if (type.equals("marketBoard")) {

					for (String freeboard : Data.marketBoard) {

						String[] freetemp = freeboard.split(",");

						if (freetemp[0].equals(num)) {

							Data.marketBoard.remove(freeboard);
							break;

						}

					}

				} else if (type.equals("inquiryBoard")) {

					for (String freeboard : Data.inquiryBoard) {

						String[] freetemp = freeboard.split(",");

						if (freetemp[0].equals(num)) {

							Data.inquiryBoard.remove(freeboard);
							break;

						}

					}

				}

				System.out.println("삭제하였습니다.");
				Data.pause();

			} catch (Exception e) {
				System.out.println("BoardService.boardDelete");
				e.printStackTrace();
			}

		} else {
			System.out.println();
			System.out.println("취소하였습니다.");
			Data.pause();
		}

	}

	public void rental(String category) {

		Scanner scan = new Scanner(System.in);

		Calendar c = Calendar.getInstance();
		String timeSelect = "";
		String select = "";
		System.out.println();

		System.out.println();
		System.out.println("================");
		System.out.println("    날짜 선택  ");
		System.out.println("================");
		System.out.println();
		System.out.print("년도 : ");
		String year = scan.nextLine();
		System.out.print("월 : ");
		String month = scan.nextLine();
			
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
		String date = scan.nextLine();
		
		if(Integer.parseInt(date) < 10) {
			date = "0" + date;
		}
		if(Integer.parseInt(month) < 10) {
			month = "0" + month;
		}
		

		String day = year + "-" + month + "-" + date;

		System.out.println();
		System.out.println("해당 날짜에 예약을 진행하시겠습니까?(Y/N) :");
		System.out.println("0. 뒤로가기");

		System.out.println();
		System.out.print("선택 : ");
		select = scan.nextLine();

		if (!select.equals("0") && select.toLowerCase().equals("y") && category.equals("체육관")) {

			int num = 1;

			System.out.println();
			System.out.println("체육관");
			System.out.println("--------------------------------------------------------");
			System.out.println("[번호]\t[날짜]\t\t[시간]\t\t[예약가능여부]");
			System.out.println("--------------------------------------------------------");

			for (Rental r : Data.rentalList) {

				if (r.getFacility().equals("체육관") && r.getDate().equals(day)) {

					// 2022-09-01,10:00~11:50,체육관,O

					System.out.printf("%4d\t%5s\t%5s\t%5s\n", num, r.getDate(), r.getTime(), r.getReserve());

					String text = r.getDate() + "," + r.getTime() + "," + num;
					rentalNum.add(text);

					num++;
				}

			}
			// 예약 시간 나옴
			System.out.println();
			System.out.print("번호 입력(0. 뒤로가기) : ");
			select = scan.nextLine();
			if (!(select.equals("0"))) {

				for (String s : rentalNum) {

					// 2022-09-01,10:00~11:50,1
					String[] temp = s.split(",");

					if (temp[2].equals(select)) {

						System.out.println("----------------------------------------");
						System.out.printf("%s\t%s\t%s\n", temp[0], temp[1], category);
						System.out.println("----------------------------------------");
						System.out.print("해당 시간에 예약하시겠습니까?(Y/N) : ");

						String answer = scan.nextLine();

						if (answer.toLowerCase().equals("y")) {

							rentalOk(temp[0], temp[1], category);

						} else if (answer.toLowerCase().equals("n")) {

							System.out.println("취소하였습니다.");
							Data.pause();
						} else {

							System.out.println("다시 입력해주세요.");

						}

					}

				}

			}
			if (select.equals("1")) {
				timeSelect = "10:00~11:50";
			} else if (select.equals("2")) {
				timeSelect = "12:00~13:50 ";
			} else if (select.equals("3")) {
				timeSelect = "14:00~15:50 ";
			} else if (select.equals("4")) {
				timeSelect = "16:00~17:50 ";
			} else if (select.equals("5")) {
				timeSelect = "18:00~19:50 ";
			} else if (select.equals("6")) {
				timeSelect = "20:00~21:50 ";
			} else {

			}
			
			String[] lastGym;
			String lastNum = "";

			if(!Data.gym.isEmpty()) {
				lastGym = Data.gym.get(Data.gym.size() - 1).split(",");
				lastNum = (Integer.parseInt(lastGym[0]) + 1) + "";
			}else {
				lastNum = 1 + "";
			}

			// 1,2022-09-30/10:00~11:50,2022-09-23/13:57:11,하하하,체육관,1

			String data = String.format("%s,%s,%s,%tF/%tT,%s,%s,%s", lastNum, day, timeSelect, c, c,
					name == "" ? "관리자" : name, category, id);

			Data.gym.add(data);

			System.out.println();
			System.out.println("예약에 성공했습니다.");
			Data.pause();

		} else if (!select.equals("0") && select.toLowerCase().equals("y") && category.equals("스터디룸")) {

			int num = 1;

			System.out.println();
			System.out.println("스터디룸");
			System.out.println("--------------------------------------------------------");
			System.out.println("[번호]\t[날짜]\t\t[시간]\t\t[예약가능여부]");
			System.out.println("--------------------------------------------------------");

			for (Rental r : Data.rentalList) {

				if (r.getFacility().equals("스터디룸") && r.getDate().equals(day)) {

					// 2022-09-01,10:00~11:50,체육관,O

					System.out.printf("%4d\t%5s\t%5s\t%5s\n", num, r.getDate(), r.getTime(), r.getReserve());

					String text = r.getDate() + "," + r.getTime() + "," + num;
					rentalNum.add(text);

					num++;
				}

			}
			// 예약 시간 나옴
			System.out.println();
			System.out.print("번호 입력(0. 뒤로가기) : ");
			select = scan.nextLine();
			if (!(select.equals("0"))) {

				for (String s : rentalNum) {

					// 2022-09-01,10:00~11:50,1
					String[] temp = s.split(",");

					if (temp[2].equals(select)) {

						System.out.println("----------------------------------------");
						System.out.printf("%s\t%s\t%s\n", temp[0], temp[1], category);
						System.out.println("----------------------------------------");
						System.out.print("해당 날짜에 예약하시겠습니까?(Y/N) : ");

						String answer = scan.nextLine();

						if (answer.toLowerCase().equals("y")) {

							rentalOk(temp[0], temp[1], category);

						} else if (answer.toLowerCase().equals("n")) {

							System.out.println("취소하였습니다.");
							Data.pause();
						} else {

							System.out.println("다시 입력해주세요.");

						}

					}

				}

			}
			if (select.equals("1")) {
				timeSelect = "10:00~11:50";
			} else if (select.equals("2")) {
				timeSelect = "12:00~13:50 ";
			} else if (select.equals("3")) {
				timeSelect = "14:00~15:50 ";
			} else if (select.equals("4")) {
				timeSelect = "16:00~17:50 ";
			} else if (select.equals("5")) {
				timeSelect = "18:00~19:50 ";
			} else if (select.equals("6")) {
				timeSelect = "20:00~21:50 ";
			} else {

			}

			String[] lastGym;
			String lastNum = "";

			if(!Data.gym.isEmpty()) {
				lastGym = Data.gym.get(Data.gym.size() - 1).split(",");
				lastNum = (Integer.parseInt(lastGym[0]) + 1) + "";
			}else {
				lastNum = 1 + "";
			}

			// 1,2022-09-30/10:00~11:50,2022-09-23/13:57:11,하하하,체육관,1

			String data = String.format("%s,%s,%s,%tF/%tT,%s,%s,%s", lastNum, day, timeSelect, c, c,
					name == "" ? "관리자" : name, category, id);

			Data.studyroom.add(data);

			System.out.println();
			System.out.println("예약에 성공했습니다.");
			Data.pause();

		} else if (!select.equals("0") && select.toLowerCase().equals("y") && category.equals("운동장")) {

			int num = 1;

			System.out.println();
			System.out.println("운동장");
			System.out.println("--------------------------------------------------------");
			System.out.println("[번호]\t[날짜]\t\t[시간]\t\t[예약가능여부]");
			System.out.println("--------------------------------------------------------");

			for (Rental r : Data.rentalList) {

				if (r.getFacility().equals("운동장") && r.getDate().equals(day)) {

					// 2022-09-01,10:00~11:50,체육관,O

					System.out.printf("%4d\t%5s\t%5s\t%5s\n", num, r.getDate(), r.getTime(), r.getReserve());

					String text = r.getDate() + "," + r.getTime() + "," + num;
					rentalNum.add(text);

					num++;
				}

			}
			// 예약 시간 나옴
			System.out.println();
			System.out.print("번호 입력(0. 뒤로가기) : ");
			select = scan.nextLine();
			if (!(select.equals("0"))) {

				for (String s : rentalNum) {

					// 2022-09-01,10:00~11:50,1
					String[] temp = s.split(",");

					if (temp[2].equals(select)) {

						System.out.println("----------------------------------------");
						System.out.printf("%s\t%s\t%s\n", temp[0], temp[1], category);
						System.out.println("----------------------------------------");
						System.out.print("해당 날짜에 예약하시겠습니까?(Y/N) : ");

						String answer = scan.nextLine();

						if (answer.toLowerCase().equals("y")) {

							rentalOk(temp[0], temp[1], category);

						} else if (answer.toLowerCase().equals("n")) {

							System.out.println("취소하였습니다.");
							Data.pause();
						} else {

							System.out.println("다시 입력해주세요.");

						}

					}

				}

			}
			if (select.equals("1")) {
				timeSelect = "10:00~11:50";
			} else if (select.equals("2")) {
				timeSelect = "12:00~13:50 ";
			} else if (select.equals("3")) {
				timeSelect = "14:00~15:50 ";
			} else if (select.equals("4")) {
				timeSelect = "16:00~17:50 ";
			} else if (select.equals("5")) {
				timeSelect = "18:00~19:50 ";
			} else if (select.equals("6")) {
				timeSelect = "20:00~21:50 ";
			} else {

			}

			String[] lastGym;
			String lastNum = "";

			if(!Data.gym.isEmpty()) {
				lastGym = Data.gym.get(Data.gym.size() - 1).split(",");
				lastNum = (Integer.parseInt(lastGym[0]) + 1) + "";
			}else {
				lastNum = 1 + "";
			}

			// 1,2022-09-30/10:00~11:50,2022-09-23/13:57:11,하하하,체육관,1

			String data = String.format("%s,%s,%s,%tF/%tT,%s,%s,%s", lastNum, day, timeSelect, c, c,
					name == "" ? "관리자" : name, category, id);

			Data.playground.add(data);

			System.out.println();
			System.out.println("예약에 성공했습니다.");
			Data.pause();

		}else if (!select.equals("0") && select.toLowerCase().equals("y") && category.equals("소강당")) {

			int num = 1;

			System.out.println();
			System.out.println("소강당");
			System.out.println("--------------------------------------------------------");
			System.out.println("[번호]\t[날짜]\t\t[시간]\t\t[예약가능여부]");
			System.out.println("--------------------------------------------------------");

			for (Rental r : Data.rentalList) {

				if (r.getFacility().equals("소강당") && r.getDate().equals(day)) {

					// 2022-09-01,10:00~11:50,체육관,O

					System.out.printf("%4d\t%5s\t%5s\t%5s\n", num, r.getDate(), r.getTime(), r.getReserve());

					String text = r.getDate() + "," + r.getTime() + "," + num;
					rentalNum.add(text);

					num++;
				}

			}
			// 예약 시간 나옴
			System.out.println();
			System.out.print("번호 입력(0. 뒤로가기) : ");
			select = scan.nextLine();
			if (!(select.equals("0"))) {

				for (String s : rentalNum) {

					// 2022-09-01,10:00~11:50,1
					String[] temp = s.split(",");

					if (temp[2].equals(select)) {

						System.out.println("----------------------------------------");
						System.out.printf("%s\t%s\t%s\n", temp[0], temp[1], category);
						System.out.println("----------------------------------------");
						System.out.print("해당 날짜에 예약하시겠습니까?(Y/N) : ");

						String answer = scan.nextLine();

						if (answer.toLowerCase().equals("y")) {

							rentalOk(temp[0], temp[1], category);

						} else if (answer.toLowerCase().equals("n")) {

							System.out.println("취소하였습니다.");
							Data.pause();
						} else {

							System.out.println("다시 입력해주세요.");

						}

					}

				}

			}
			if (select.equals("1")) {
				timeSelect = "10:00~11:50";
			} else if (select.equals("2")) {
				timeSelect = "12:00~13:50 ";
			} else if (select.equals("3")) {
				timeSelect = "14:00~15:50 ";
			} else if (select.equals("4")) {
				timeSelect = "16:00~17:50 ";
			} else if (select.equals("5")) {
				timeSelect = "18:00~19:50 ";
			} else if (select.equals("6")) {
				timeSelect = "20:00~21:50 ";
			} else if(select.equals("0")){
				System.out.println("취소하였습니다.");
				Data.pause();
				RentalInterface rental = new RentalInterface();
				rental.Rental();
			}

			String[] lastGym;
			String lastNum = "";

			if(!Data.gym.isEmpty()) {
				lastGym = Data.gym.get(Data.gym.size() - 1).split(",");
				lastNum = (Integer.parseInt(lastGym[0]) + 1) + "";
			}else {
				lastNum = 1 + "";
			}

			// 1,2022-09-30/10:00~11:50,2022-09-23/13:57:11,하하하,체육관,1

			String data = String.format("%s,%s,%s,%tF/%tT,%s,%s,%s", lastNum, day, timeSelect, c, c,
					name == "" ? "관리자" : name, category, id);

			Data.auditorium.add(data);

			System.out.println();
			System.out.println("예약에 성공했습니다.");
			Data.pause();

		}else if (select.equals("n")) {
			System.out.println();
			System.out.println("취소 했습니다.");
			Data.pause();

		} else {

		}
	}

	/**
	 * 예약이 진행되면 렌탈.txt에서 Reserve X로 변경 
	* */
	private void rentalOk(String day, String time, String category) {

		for (int i = 0; i < Data.rentalList.size(); i++) {

			if (Data.rentalList.get(i).getDate().equals(day) && Data.rentalList.get(i).getTime().equals(time)
					&& Data.rentalList.get(i).getFacility().equals(category)) {

				Data.rentalList.get(i).setReserve("X");

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






	/**
	 * 달력 출력 메소드
	 */
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
