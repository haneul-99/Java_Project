package com.project.ssm.admin;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.matching.MatchingUser;

/**
 * 관리자 매칭 유저 결과 리스트 클래스입니다.
 * @author yangha-eun
 *
 */
public class AdminMatchingUserList {

	public static void matchingUserList() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=======================================================================================================================");
		System.out.println("                                                 매칭 등록 리스트");
		System.out.println("=======================================================================================================================");
		System.out.println();
		System.out.println("[번호]\t[학번]\t\t[이름]\t [나이]\t     [학과]    [성별]\t [키]  [몸무게]  [과CC여부]  [운동분야]\t[학점]\t[공부분야]");
		
		int n = 1;
		
		for (MatchingUser matchingUser : Data.matchingUserList) {

			
			
			System.out.printf("%4d\t%s\t%s\t%5d\t%8s\t%2s\t%4d\t%4d\t%6s\t%10s\t%5.1f\t%6s\n"
								, n
								, matchingUser.getId()
								, matchingUser.getName()
								, matchingUser.getAge()
								, matchingUser.getMajor()
								, matchingUser.getGender()
								, matchingUser.getHeight()
								, matchingUser.getWeight()
								, matchingUser.getCc()
								, matchingUser.getExercise()
								, matchingUser.getGrade()
								, matchingUser.getStudy());
			
			n++;
		}
		System.out.println();
		
		System.out.println("==============================================================================");
		System.out.println("                                    0. 뒤로가기");
		System.out.println("==============================================================================");
		System.out.print("                                    ▶  ");
		String sel = scan.nextLine();
		

		
		if (sel.equals("0")) {
			
			System.out.println("관리자 페이지로 돌아갑니다..");
			
		}
		
	}

	
}
