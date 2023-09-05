package com.project.ssm.matching;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;
import com.project.ssm.user.User;


/**
 * 매칭 결과 정보 클래스입니다.
 * @author 김경현, 김유진
 */
public class MatchingResultInterface {

	/**
	 * 매개변수로 받은 과CC 가능여부, 최소 키, 몸무게, 최대 키, 몸무게로 매칭해주는 메소드
	 * @param cc 과cc 가능여부
	 * @param minWantHeight 원하는 최소 키
	 * @param maxWantHeight 원하는 최대 키
	 * @param minWantWeight 원하는 최소 몸무게
	 * @param maxWantWeigth 원하는 최대 몸무게
	 */
	public void begin(String cc, String minWantHeight, String maxWantHeight, String minWantWeight,
			String maxWantWeigth) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<MatchingUser> matchingUser = new ArrayList<MatchingUser>();
		
		String gender = getMyGender(LoginService.finalId);

		for (MatchingUser mu : Data.matchingUserList) {

			if (cc.toUpperCase().equals("N")) { // 과CC 불가능

				if (mu.getHeight() >= Integer.parseInt(minWantHeight)
						&& mu.getHeight() <= Integer.parseInt(maxWantHeight)
						&& mu.getWeight() >= Integer.parseInt(minWantWeight)
						&& mu.getWeight() <= Integer.parseInt(maxWantWeigth)) { // 상대방 조건 만족

					if (!mu.getMajor().equals(getMyMajor(LoginService.finalId)) && !(mu.getId().equals(LoginService.finalId))) {

						if (!gender.equals(mu.getGender())) {
							matchingUser.add(mu);
						}

					}

				}

			} else if (cc.toUpperCase().equals("Y")) { // 과CC 가능

				if (mu.getHeight() >= Integer.parseInt(minWantHeight)
						&& mu.getHeight() <= Integer.parseInt(maxWantHeight)
						&& mu.getWeight() >= Integer.parseInt(minWantWeight)
						&& mu.getWeight() <= Integer.parseInt(maxWantWeigth)) { // 상대방 조건 만족

					if (mu.getMajor().equals(getMyMajor(LoginService.finalId)) && !(mu.getId().equals(LoginService.finalId))) {

						if (!gender.equals(mu.getGender())) {
							matchingUser.add(mu);

						}
					}

				}

			}
			

		}

		if (matchingUser.size() >= 1) {

			Random rnd = new Random();
			int randomNumber = rnd.nextInt(matchingUser.size() - 1);

			for (MatchingUser mu : Data.matchingUserList) {

				if (mu.getId().equals(LoginService.finalId)) {

					System.out.printf("조건에 맞는 %d명 중 1명을 매칭했습니다! ^ㅇ^\n", matchingUser.size());

					System.out.println("-매칭 성공-");
					System.out.println("[자신의 정보]");
					System.out.printf("이름: %s ㅣ 나이: %d ㅣ 연락처: %s ㅣ 성별: %s ㅣ 전공: %s ㅣ 키: %d | 몸무게: %d  ㅣ과CC가능여부: %s\n"
											, mu.getName()
											, mu.getAge()
											, getMyTel()
											, mu.getGender()
											, mu.getMajor()
											, mu.getHeight()
											, mu.getWeight()
											, mu.getCc());

				}

			}

			System.out.println("[상대방 정보]");

			System.out.printf("이름: %s ㅣ 나이: %d ㅣ 연락처: %s ㅣ 성별: %s ㅣ 전공: %s ㅣ 키: %d | 몸무게: %d  ㅣ과CC가능여부: %s\n"
					 						, matchingUser.get(randomNumber).getName()
					 						, matchingUser.get(randomNumber).getAge()
					 						, getOtherTel(matchingUser.get(randomNumber).getId())
					 						, matchingUser.get(randomNumber).getGender()
					 						, matchingUser.get(randomNumber).getMajor()
					 						, matchingUser.get(randomNumber).getHeight()
					 						, matchingUser.get(randomNumber).getWeight()
					 						, matchingUser.get(randomNumber).getCc());
			
			System.out.println();
			System.out.println("상대방에게 매칭 알람을 보내시겠습니까?");
			System.out.print("입력(Y/N) :");
			String answer = scan.nextLine().toUpperCase();
			
			if(answer.equals("Y")) {
				matchingResultUserListAdd(matchingUser, randomNumber, "연애");
				System.out.println("알람을 보냈습니다.");
				Data.pause();
			}else {
				System.out.println();
				System.out.println("취소하였습니다.");
				Data.pause();
			}


		} else {

			System.out.println("매칭 가능한 사람이 없습니다.");
			System.out.println("매칭 추가 입력 화면으로 이동합니다..");

			Data.pause();
		}

	}

	

	/**
	 * 상대방의 전화번호를 반환하는 메소드 
	 * @param id
	 * @return 상대방 전화번호
	 */
	private String getOtherTel(String id) {
		
		for (User u : Data.userList) {
			
			if (id.equals(u.getId())) {
				
				return u.getTel();
				
			}
			
		}
		
		return null;
	}



	/**
	 * 나의 전화번호를 반환하는 메소드
	 * @return 나의 전화번호
	 */
	private String getMyTel() {
		
		for (User u : Data.userList) {
			
			if (LoginService.finalId.equals(u.getId())) {
				
				return u.getTel();
			}
			
		}
		
		
		
		return null;
	}

	/**
	 * 매개변수로 받은 운동분야로 매칭해주는 메소드
	 * @param exercise 운동분야
	 */
	public void begin(String exercise) {
		
		Scanner scan = new Scanner(System.in);
		
		ArrayList<MatchingUser> matchingUser = new ArrayList<MatchingUser>();
		String gender = getMyGender(LoginService.finalId);

		for (MatchingUser mu : Data.matchingUserList) {

			if (exercise.equals(mu.getExercise()) && !(mu.getId().equals(LoginService.finalId))) { // 과CC 불가능

				matchingUser.add(mu);
			}

		}

		if (matchingUser.size() >= 1) {

			Random rnd = new Random();
			int randomNumber = rnd.nextInt(matchingUser.size() - 1);

			for (MatchingUser mu : Data.matchingUserList) {

				if (mu.getId().equals(LoginService.finalId)) {

					System.out.println();
					System.out.printf("조건에 맞는 %d명 중 1명을 매칭했습니다! ^ㅇ^\n", matchingUser.size());

					System.out.println();
					System.out.println("-매칭 성공-");
					System.out.println("[자신의 정보]");
					System.out.printf("이름: %s ㅣ 나이: %d ㅣ 연락처: %s ㅣ 성별: %s ㅣ 운동: %s \n"
										, mu.getName()
										, mu.getAge()
										, getMyTel()
										, mu.getGender()
										, mu.getExercise());

					break;
					
				}

			}

			System.out.println("[상대방 정보]");

			System.out.printf("이름: %s ㅣ나이: %d ㅣ 연락처: %s ㅣ 성별: %s ㅣ 운동: %s\n"
								, matchingUser.get(randomNumber).getName()
								, matchingUser.get(randomNumber).getAge()
								, getOtherTel(matchingUser.get(randomNumber).getId())
								, matchingUser.get(randomNumber).getGender()
								, matchingUser.get(randomNumber).getExercise());

			System.out.println();
			System.out.println("상대방에게 매칭 알람을 보내시겠습니까?");
			System.out.print("입력(Y/N) :");
			String answer = scan.nextLine().toUpperCase();
			
			if(answer.equals("Y")) {
				matchingResultUserListAdd(matchingUser, randomNumber, "운동");
				System.out.println("알람을 보냈습니다.");
				Data.pause();
			}else {
				System.out.println();
				System.out.println("취소하였습니다.");
				Data.pause();
			}
			
		
		}

	}

	/**
	 * 매개변수로 받은 학점과 공부분야로 매칭해주는 메소드
	 * @param grade 학점
	 * @param study 공부분야
	 */
	public void begin(Double grade, String study) {
		
		Scanner scan = new Scanner(System.in);

		ArrayList<MatchingUser> matchingUser = new ArrayList<MatchingUser>();

		for (MatchingUser mu : Data.matchingUserList) {

			if (study.equals(mu.getStudy()) && !(mu.getId().equals(LoginService.finalId))) {

				matchingUser.add(mu);
			}

		}
		

		if (matchingUser.size() >= 1) {

			Random rnd = new Random();
			int randomNumber = rnd.nextInt(matchingUser.size());

			
			
			for (MatchingUser mu : Data.matchingUserList) {

				if (mu.getId().equals(LoginService.finalId)) {

					System.out.printf("조건에 맞는 %d명 중 1명을 매칭했습니다! ^ㅇ^\n", matchingUser.size());

					System.out.println();
					System.out.println("-매칭 성공-");
					System.out.println("[자신의 정보]");
					System.out.printf("이름: %s ㅣ나이: %d ㅣ 연락처: %s ㅣ 성별: %s ㅣ 성적: %.1f ㅣ 공부유형: %s\n"
											, mu.getName()
											, mu.getAge()
											, getMyTel()
											, mu.getGender()
											, mu.getGrade()
											, mu.getStudy());
					break;
				}

			}

			System.out.println("[상대방 정보]");

			System.out.printf("이름: %s ㅣ나이: %d ㅣ 연락처: %s ㅣ 성별: %s ㅣ 성적: %.1f ㅣ 공부유형: %s\n"
											, matchingUser.get(randomNumber).getName()
											, matchingUser.get(randomNumber).getAge()
											, getOtherTel(matchingUser.get(randomNumber).getId())
											, matchingUser.get(randomNumber).getGender()
											, matchingUser.get(randomNumber).getGrade()
											, matchingUser.get(randomNumber).getStudy());

			System.out.println();
			System.out.println("상대방에게 매칭 알람을 보내시겠습니까?");
			System.out.print("입력(Y/N) :");
			String answer = scan.nextLine().toUpperCase();
			
			if(answer.equals("Y")) {
				matchingResultUserListAdd(matchingUser, randomNumber, "스터디");
				System.out.println("알람을 보냈습니다.");
				Data.pause();
			}else {
				System.out.println();
				System.out.println("취소하였습니다.");
				Data.pause();
			}

			
		}

	}

	/**
	 * 매개변수로 받은 MatchingUser 리스트와 랜덤 정수, 카테고리로 matchingResultUser 리스트에 추가하는 메소드
	 * @param matchingResultUser 리스트
	 * @param randomNumber 램던 정수
	 * @param category 카테고리
	 */
	public void matchingResultUserListAdd(ArrayList<MatchingUser> matchingResultUser, int randomNumber,
			String category) {
		// matchingResultUser 리스트에 기록 => matchingresultuser.txt에 기록
		MatchingResultUser result = new MatchingResultUser();

		int seq = 0;

		// 고유번호 부여 방식
		if (Data.matchingResultUserList.size() > 0) {
			seq = Data.matchingResultUserList.get(Data.matchingResultUserList.size() - 1).getMatchingNumber() + 1;
		} else {
			seq = 1;
		}

		// 7,1,김형수,22,의예과,여자,18671707,이돈정,24,전자공학과,여자,연애
		result.setMatchingNumber(seq);

		result.setMyId(LoginService.finalId);
		result.setMyName(getMyName(LoginService.finalId));
		result.setMyAge(getMyAge(LoginService.finalId));
		result.setMyMajor(getMyMajor(LoginService.finalId));
		result.setMyGender(getMyGender(LoginService.finalId));

		result.setOtherId(matchingResultUser.get(randomNumber).getId());
		result.setOtherName(matchingResultUser.get(randomNumber).getName());
		result.setOtherAge(matchingResultUser.get(randomNumber).getAge());
		result.setOtherMajor(matchingResultUser.get(randomNumber).getMajor());
		result.setOtherGender(matchingResultUser.get(randomNumber).getGender());

		result.setCategory(category);

		Data.matchingResultUserList.add(result);
		
	}// matchingResultUserListAdd
	
	/**
	 * 나의 성별을 반환하는 메소드
	 * @param finalId
	 * @return 나의 성별
	 */
	private String getMyGender(String finalId) {

		for (MatchingUser mu : Data.matchingUserList) {

			if (finalId.equals(mu.getId())) {

				return mu.getGender();

			}
		}
		return null;
	}// getMyGender

	/**
	 * 나의 이름을 반환하는 메소드
	 * @param finalId
	 * @return 나의 이름
	 */
	private String getMyName(String finalId) {

		for (MatchingUser mu : Data.matchingUserList) {

			if (finalId.equals(mu.getId())) {

				return mu.getName();

			}
		}

		return null;
	}// getMyName

	/**
	 * 나의 나이를 반환하는 메소드
	 * @param finalId
	 * @return 나의 나이
	 */
	private int getMyAge(String finalId) {

		for (MatchingUser mu : Data.matchingUserList) {

			if (finalId.equals(mu.getId())) {

				return mu.getAge();

			}
		}

		return 0;
	}// getMyAge

	
	/**
	 * 나의 전공을 반환하는 메소드
	 * @param finalId
	 * @return 나의 전공
	 */
	private String getMyMajor(String finalId) {

		for (User u : Data.userList) {

			if (finalId.equals(u.getId())) {

				return u.getMajor();

			}
		}
		return null;
	}// getMyMajor

}
