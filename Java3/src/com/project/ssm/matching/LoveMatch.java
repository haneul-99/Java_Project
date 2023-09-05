package com.project.ssm.matching;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;
import com.project.ssm.user.User;

/**
 * 연애 매칭 클래스입니다.
 * @author 김경현, 김유진
 */
public class LoveMatch {

	/**
	 * 연애 매칭 화면을 출력하는 메소드
	 * @author 김경현, 김유진
	 */
	public void loveAddInfo() {
		
		boolean loop = true;

		Scanner scan = new Scanner(System.in);

		while (loop) {

			System.out.println("======================================================================");
			System.out.println("                              연애 매칭 추가입력");
			System.out.println("======================================================================");
			System.out.println();
			System.out.println("                             1. 삭제하기");
			System.out.println("                             2. 매칭하기 💘");
			System.out.println("                             0. 뒤로가기");
			System.out.println();
			System.out.println("======================================================================");
			System.out.print("                             ▶ 메뉴 선택: ");
			
			String sel = scan.nextLine();

			if (sel.equals("1")) {
				delete();
			} else if (sel.equals("2")) {
				add();
			} else if (sel.equals("0")) {
				System.out.println("이전 화면으로 돌아갑니다..");
				loop = false;
			} else {
				System.out.println("🚨 잘못된 번호를 입력했습니다.");
				Data.pause();
			}

		}
		
	}

	/**
	 * 저장된 연애 매칭정보를 삭제하는 메소드
	 * @author 김경현, 김유진
	 */
	private static void add() {

		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		String height = ""; // 자신의 키
		String weight = ""; // 자신의 몸무게
		String cc = ""; 	// 과CC 가능여부
		
		String minHeight = ""; // 상대 키 최소
		String maxHeight = ""; // 상대 키 최대
		String minWeight = ""; // 상대 몸무게 최소
		String maxWeight = ""; // 상대 몸무게 최대

		boolean loop = true;

		while (loop) {
			
			// 1. 만약 이미 키/몸무게/과CC가능여부를 입력하지않았다면 실행.
			
			if (isThereValue(LoginService.finalId)) { // 1. 입력 받은 값이 없음
				
				System.out.println("※ 자신의 신체치수와 과CC 가능여부를 입력해주세요.");
				System.out.print("▶ 키(cm): ");
				height = scan.nextLine();

				System.out.print("▶ 몸무게(kg): ");
				weight = scan.nextLine();

				System.out.print("과CC 가능여부(Y/N):");
				cc = scan.nextLine();
				cc = cc.toUpperCase();
				System.out.println();
				
				System.out.print("추가 정보를 저장하시겠습니까?(Y/N): ");
				String addInfoSave = scan.nextLine();
				
				// 키/몸무게/과CC 가능여부 유효성 검사
				if(!isValidMyInfo(height, weight, cc)) {
					System.out.println("추가 입력화면으로 돌아갑니다..");
					Data.pause();
					return;
				}
				
				if (addInfoSave.toUpperCase().equals("Y")) {
					
					//매칭유저리스트에(연애) 추가
					MatchingUser u = new MatchingUser();
					for(User user : Data.userList) {
						
						if(user.getId().equals(LoginService.finalId)) {
							
							
							u.setId(user.getId());
							u.setName(user.getName());
							
							int  age = 0;
							
							if (user.getJumin().substring(0,2).equals("96")) {
								age = 27;
							} else if (user.getJumin().substring(0,2).equals("97")){
								age = 26;
							} else if (user.getJumin().substring(0,2).equals("98")) {
								age = 25;
							} else if (user.getJumin().substring(0,2).equals("99")) {
								age = 24;
							} else if (user.getJumin().substring(0,2).equals("00")) {
								age = 23;
							} else if (user.getJumin().substring(0,2).equals("01")) {
								age = 22;
							} else if (user.getJumin().substring(0,2).equals("02")) {
								age = 21;
							} else if (user.getJumin().substring(0,2).equals("03")) {
								age = 20;
							}
							
							u.setAge(age);
							u.setMajor(user.getMajor());
							
							String gender = "";
							
							if (user.getJumin().substring(7, 8).equals("1") || user.getJumin().substring(7, 8).equals("3")) {
								gender = "남자";
							}else if(user.getJumin().substring(7, 8).equals("2") || user.getJumin().substring(7, 8).equals("4")) {
								gender = "여자";
							}
							
							u.setGender(gender);
							//19679528,이정수,25,간호학과,남자,179,68,N,배드민턴,2.5,파이썬
							u.setHeight(Integer.parseInt(height));
							u.setWeight(Integer.parseInt(weight));
							u.setCc(cc);
							u.setExercise(null);
							u.setGrade(0.0);
							u.setStudy(null);
							
							boolean check = true;
							for(MatchingUser m : Data.matchingUserList) {
								if(m.getId().equals(LoginService.finalId)) {
										if(!(m.getCc().equals("null"))) {
											System.out.println();
											System.out.println(m.getCc());
											System.out.println(m.getId());
											System.out.println("이미 등록되어있습니다. 등록된 정보로 매칭합니다.");
											Data.pause();
											break;
										}else {
											m.setCc(cc);
											m.setHeight(Integer.parseInt(height));
											m.setWeight(Integer.parseInt(weight));
											System.out.println("저장되었습니다..");
											Data.pause();
											check = false;
											break;
										}
								}
							}
							if(check) {
								Data.matchingUserList.add(u);
								System.out.println("저장되었습니다..");
								break;
								
							}
							break;
						}
						
					}
					
					for (MatchingUser mu : Data.matchingUserList) { // 로그인한 유저에게 데이터 삽입
						
						if (LoginService.finalId.equals(mu.getId())) {
							
							mu.setHeight(Integer.parseInt(height));
							mu.setWeight(Integer.parseInt(weight));
							mu.setCc(cc);
							
						} 
						
					}
					
					System.out.println("저장되었습니다..");
					
					
				}  else if (addInfoSave.toUpperCase().equals("N")) {
					System.out.println("매칭 추가입력 화면으로 돌아갑니다..");
					loop = false;

				} else {
					System.out.println("잘못된 문자를 입력했습니다. 매칭 추가입력 화면을 돌아갑니다.");
					loop = false;
				}

			} else { // 2. 이미 키/몸무게/과CC가능여부를 입력했다면
				
				System.out.print("이미 입력된 정보가 있습니다. 수정하시겠습니까?(Y/N): ");
				
				String addInfoSave = scan.nextLine();
				
				if (addInfoSave.toUpperCase().equals("Y")) {

					System.out.println("※ 자신의 신체치수와 과CC 가능여부를 입력해주세요.");
					System.out.print("▶ 키(cm): ");
					height = scan.nextLine();

					System.out.print("▶ 몸무게(kg): ");
					weight = scan.nextLine();

					System.out.print("과CC 가능여부(Y/N):");
					cc = scan.nextLine();
					System.out.println();
					
					// 키/몸무게/과CC 가능여부 유효성 검사
					if(!isValidMyInfo(height, weight, cc)) {
						System.out.println("추가 입력화면으로 돌아갑니다..");
						Data.pause();
						return;
					}
					
					for (MatchingUser mu : Data.matchingUserList) { 
						
						if (LoginService.finalId.equals(mu.getId())) {
							
							mu.setHeight(Integer.parseInt(height));
							mu.setWeight(Integer.parseInt(weight));
							mu.setCc(cc);
							
						} 
						
					}
					
				} else if (addInfoSave.toUpperCase().equals("N")) {

					for (MatchingUser mu : Data.matchingUserList) {

						if (LoginService.finalId.equals(mu.getId())) {

							height = mu.getHeight() + "";
							weight = mu.getWeight() + "";
							cc = mu.getCc();

						}

					}
					
				} else {
					
					System.out.println("🚨 잘못된 문자를 입력했습니다. 추가 입력화면으로 돌아갑니다..");
					System.out.println();
					return;
					
				}

			}

			System.out.println("※ 상대의 원하는 조건을 입력해주세요.");
			System.out.println("☞ 키: 130~200(cm) ㅣ 몸무게: 30~90(kg)");
			System.out.print("▶ 최소 키(cm): ");
			minHeight = scan.nextLine();
			
			System.out.print("▶ 최대 키(cm): ");
			maxHeight = scan.nextLine();
			
			System.out.print("▶ 최소 몸무게(kg): ");
			minWeight = scan.nextLine();
			
			System.out.print("▶ 최대 몸무게(kg): ");
			maxWeight = scan.nextLine();
			
			// 키/몸무게 유효성 검사
			if(!isValidOtherInfo(minHeight, maxHeight, minWeight, maxWeight)) {
				Data.pause();
				return;
			}
			
			// 매칭결과 인터페이스로 이동
			System.out.print("♥️ 매칭이 완료되었습니다! ♥️");
			Data.pause();
			

			MatchingResultInterface matchingResultInterface = new MatchingResultInterface();
			matchingResultInterface.begin(cc, minHeight, maxHeight, minWeight, maxWeight);
			
			loop = false;

		}

	}

	/**
	 * 매개변수로 받은 유저ID의 저장된 정보가 있는 지 검사 후 반환하는 메소드
	 * @param finalId
	 * @return 저장정보 유무
	 */
	private static boolean isValidMyInfo(String height, String weight, String cc) {
		
		//  숫자, 범위 키(130~200), 몸무게(30~90)
		boolean result = true;
		String text = "";
		
		String regex = "^[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		
		if (!pattern.matcher(height+"").find() && !pattern.matcher(weight+"").find()) {
			System.out.println("❌ 키와 몸무게는 3자리 숫자로만 입력가능합니다.");
			return false;
		}
		
		if (Integer.parseInt(height) > 200 || Integer.parseInt(height) < 130) {
			text += String.format("❌ 키는 130~200(cm) 사이로 입력해주세요.\n");
			result = false;
		} 
		
		if (Integer.parseInt(weight) < 30 || Integer.parseInt(weight) > 90) {
			text += String.format("❌ 몸무게는 30~90(kg) 사이로 입력해주세요.\n");
			result = false;
		}
		
		if (!cc.equals("Y") && !cc.equals("N") && !cc.equals("y") && !cc.equals("n")) {
			text += String.format("❌ 과CC 가능여부: 잘못된 문자를 입력했습니다.\n");
			result =  false;
		} 
		
		
		System.out.println(text);
		
		return result;
		
	}

	private static boolean isValidOtherInfo(String minHeight, String maxHeight, String minWeight, String maxWeight) {
		//  숫자, 범위 키(130~200), 몸무게(30~90)
		
		boolean result = true;
		
		String text = "";
		
		String regex = "^[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		
		if (!pattern.matcher(minHeight).find() && !pattern.matcher(maxHeight).find() 
				&& !pattern.matcher(minWeight).find() && !pattern.matcher(maxWeight).find()) {
			System.out.println("❌ 키와 몸무게는 3자리 숫자로만 입력가능합니다.");
			return false;
		}
		
		if (Integer.parseInt(minHeight) >= Integer.parseInt(maxHeight)) {
			text += String.format("❌ 최대 키는 최소 키보다 높게 입력해주세요.\n");
			result = false;
		} 
		
		if (Integer.parseInt(minWeight) >= Integer.parseInt(maxWeight)) {
			text += String.format("❌ 최대 몸무게는 최소 몸무게보다 높게 입력해주세요.\n");
			result = false;
		}
		
		if (Integer.parseInt(minHeight) < 130 || Integer.parseInt(maxHeight) > 200) {
			text += String.format("❌ 키는 130~200(cm) 사이로 입력해주세요.\n");
			result =  false;
		} 
		
		if (Integer.parseInt(minWeight) < 30 || Integer.parseInt(maxWeight) > 90) {
			text += String.format("❌ 몸무게는 30~90(kg) 사이로 입력해주세요.\n");
			result = false;
		}
		
		
		
		System.out.println(text);
		
		return result;
		
	}

	private static boolean isThereValue(String finalId) {
		
		for (MatchingUser mu : Data.matchingUserList) {
			
			if (finalId.equals(mu.getId())) {
				
				if (mu.getHeight() == 0 || mu.getWeight() == 0 || mu.getCc() == "null") {
					return true;
				}
				
			}
			
		}
		
		return false;
	}

	private void delete() {
		
		System.out.println();
		Scanner scan = new Scanner(System.in);

		System.out.print("🚨 삭제하면 입력한 추가 정보가 모두 사라집니다. 진행하시겠습니까? (Y/N): ");

		String sel = scan.nextLine();

		if (sel.toUpperCase().equals("Y")) { 

			for (MatchingUser mu : Data.matchingUserList) {	
				
				if ((LoginService.finalId.equals(mu.getId()) && mu.getHeight() != 0)) { // 회원의 추가 정보 데이터가 존재
					
					mu.setHeight(0);
					mu.setWeight(0);
					mu.setCc("null");
					
					System.out.println("🚨 삭제가 완료됐습니다.");
					Data.pause();
					return;

				} else if ((LoginService.finalId.equals(mu.getId()) && mu.getHeight() == 0)) { // 회원의 추가 정보 데이터가 존재 X

					System.out.println("🚨 삭제할 데이터가 존재하지않습니다.");
					Data.pause();
					return;
					
				} else {
					
				}

			}

		} else if (sel.toUpperCase().equals("N")) {

			System.out.println("매칭 추가입력 화면으로 돌아갑니다..");
			Data.pause();
			return;

		} else {
			System.out.println("🚨 잘못된 문자를 입력했습니다.");
			Data.pause();
			return;
		}
	}

}
