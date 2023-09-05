package com.project.ssm.board;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.ssm.data.Data;

/**
 * 게시판 검색 클래스입니다.
 * @author yangha-eun
 * 
 */
public class SearchBoard {

	/**
	 * 게시판 검색 메인화면 메소드입니다.
	 */
	public void mainInterface() {
		
		boolean loop = true;
		
		Scanner scan = new Scanner(System.in);
		
		while(loop) {
		
			System.out.println();
			System.out.println("\t\t\t\t  ============================================");
			System.out.println("\t\t\t\t                  게시판 검색");
			System.out.println("\t\t\t\t  ============================================");
			
			
			System.out.println();
	        System.out.println("\t\t\t\t  ============================================");
	        System.out.println("\t\t\t\t    1. 제목 검색           2. 작성자 검색     ");
	        System.out.println("\t\t\t\t    3. 자유게시판 검색     4. 장터게시판 검색 ");
	        System.out.println("\t\t\t\t    5. 문의게시판 검색     0. 뒤로가기        ");
	        System.out.println("\t\t\t\t  ============================================");
	        System.out.println();
			
			System.out.print("\t\t\t\t  ▶메뉴 선택 : ");
			
			String select = scan.nextLine();
			
			
			if(select.equals("1")) {
				
				//1. 제목 검색
				titleSearch();
				
			}else if(select.equals("2")) {
				
				//2. 작성자 검색
				nameSearch();
				
			}else if(select.equals("3")) {
				
				//3. 자유게시판 내용 검색
				freeContentSearch();
				
			}else if(select.equals("4")) {
				
				//4. 장터게시판 내용 검색
				marketContentSearch();
				
			}else if(select.equals("5")) {
				
				//5. 문의게시판 내용 검색
				inquiryContentSearch();
				
			}else if(select.equals("0")) {
				
				//0. 뒤로가기
				loop = false;
				
			}
			
		}
		
	}

	
	//문의게시판 내용 검색
	/**
	 * 문의게시판 내용 검색 메소드입니다.
	 */
	private void inquiryContentSearch() {
		
		ArrayList<String> searchList = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		
		boolean loop = true;
		
		while(loop) {
			
			searchList.removeAll(searchList);
			num = 1;
		
			System.out.println();
			System.out.println("========================================");
			System.out.println("             문의게시판 검색");
			System.out.println("========================================");
			System.out.println();
			
			System.out.print("▶ 키워드를 입력하세요.(0. 뒤로가기) : ");
			String select = scan.nextLine();
			
			if(!select.equals("0")) {
				
				System.out.println();
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println("                                                  키워드 : " + select);
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println();
				
				System.out.println("[번호]\t[제목]\t\t\t\t[내용]\t\t\t [작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
				System.out.println("----------------------------------------------------------"
						+ "--------------------------------------------------------------------------");
				
				for(String board : Data.inquiryBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[2].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
				
				if(searchList.isEmpty()) {
					
					System.out.println("검색 결과가 없습니다.");
					
				}else {
					
					for(String board : searchList) {
						
						//번호 제목 날짜 작성자
						//15,날씨 날씨 ,연락처 식사 학식 합격 ,2018-05-19/10:57:11,박재민,자유게시판,20116673
						//1,3,책 팔아요~,책 완전 이쁜데 팝니다!!,2018-06-16/17:27:11,손재돈,장터게시판,21750018
						
						String[] temp = board.split(",");
						
						System.out.printf("%5s\t%5s\t%20s\t\t%5s\t%5s\t%5s\t%5s\n"
								, temp[0]
								, temp[2]
								, temp[3]
								, temp[5]
								, temp[7]
								, temp[4]
								, temp[6]);
						
					}
					
					
				}
				
				System.out.println();
				System.out.print("▶ 글 선택(0. 뒤로가기) : ");
				String listSelect = scan.nextLine();
				
				if(!listSelect.equals("0")) {
					
					for(String board : searchList) {
						
						String[] temp = board.split(",");
						
						if(listSelect.equals(temp[0])) {
							
							BoardService view = new BoardService();
							view.boardView(temp[1], temp[6]);
							
						}
						
					}
					
				}
				
			}else if(select.equals("0")){
				loop = false;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
		
	}



	//장터게시판 내용 검색
	/**
	 * 장터게시판 내용 검색 메소드입니다.
	 */
	private void marketContentSearch() {
		
		ArrayList<String> searchList = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		
		boolean loop = true;
		
		while(loop) {
			
			searchList.removeAll(searchList);
			num = 1;
		
			System.out.println();
			System.out.println("========================================");
			System.out.println("             장터게시판 검색");
			System.out.println("========================================");
			System.out.println();
			
			System.out.print("▶ 키워드를 입력하세요.(0. 뒤로가기) : ");
			String select = scan.nextLine();
			
			
			if(!select.equals("0")) {
				
				System.out.println();
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println("                                                  키워드 : " + select);
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println();
				
				System.out.println("[번호]\t[제목]\t\t\t\t[내용]\t\t\t [작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
				System.out.println("----------------------------------------------------------"
						+ "--------------------------------------------------------------------------");
				
				for(String board : Data.marketBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[2].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
				
				if(searchList.isEmpty()) {
					
					System.out.println("검색 결과가 없습니다.");
					
				}else {
					
					for(String board : searchList) {
						
						//번호 제목 날짜 작성자
						//15,날씨 날씨 ,연락처 식사 학식 합격 ,2018-05-19/10:57:11,박재민,자유게시판,20116673
						//1,3,책 팔아요~,책 완전 이쁜데 팝니다!!,2018-06-16/17:27:11,손재돈,장터게시판,21750018
						
						String[] temp = board.split(",");
						
						System.out.printf("%5s\t%5s\t%20s\t\t%5s\t%5s\t%5s\t%5s\n"
								, temp[0]
								, temp[2]
								, temp[3]
								, temp[5]
								, temp[7]
								, temp[4]
								, temp[6]);
						
					}
					
					
				}
				
				System.out.println();
				System.out.print("▶ 글 선택(0. 뒤로가기) : ");
				String listSelect = scan.nextLine();
				
				if(!listSelect.equals("0")) {
					
					for(String board : searchList) {
						
						String[] temp = board.split(",");
						
						if(listSelect.equals(temp[0])) {
							
							BoardService view = new BoardService();
							view.boardView(temp[1], temp[6]);
							
						}
						
					}
					
				}
				
			}else if(select.equals("0")){
				loop = false;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
		
	}


	//자유게시판 내용 검색
	/**
	 * 자유게시판 내용 검색 메소드입니다.
	 */
	private void freeContentSearch() {
		
		ArrayList<String> searchList = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		
		boolean loop = true;
		
		while(loop) {
			
			searchList.removeAll(searchList);
			num = 1;
		
			System.out.println();
			System.out.println("========================================");
			System.out.println("             자유게시판 검색");
			System.out.println("========================================");
			System.out.println();
			
			System.out.print("▶ 키워드를 입력하세요.(0. 뒤로가기) : ");
			String select = scan.nextLine();
			
			
			
			if(!select.equals("0")) {
				
				System.out.println();
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println("                                                  키워드 : " + select);
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println();
				
				System.out.println("[번호]\t[제목]\t\t\t\t[내용]\t\t\t [작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
				System.out.println("----------------------------------------------------------"
						+ "--------------------------------------------------------------------------");
				
				for(String board : Data.freeBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[2].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
				
				if(searchList.isEmpty()) {
					
					System.out.println("검색 결과가 없습니다.");
					
				}else {
					
					for(String board : searchList) {
						
						//번호 제목 날짜 작성자
						//15,날씨 날씨 ,연락처 식사 학식 합격 ,2018-05-19/10:57:11,박재민,자유게시판,20116673
						//1,3,책 팔아요~,책 완전 이쁜데 팝니다!!,2018-06-16/17:27:11,손재돈,장터게시판,21750018
						
						String[] temp = board.split(",");
						
						System.out.printf("%5s\t%5s\t%20s\t\t%5s\t%5s\t%5s\t%5s\n"
								, temp[0]
								, temp[2]
								, temp[3]
								, temp[5]
								, temp[7]
								, temp[4]
								, temp[6]);
						
					}
					
					
				}
				
				System.out.println();
				System.out.print("▶ 글 선택(0. 뒤로가기) : ");
				String listSelect = scan.nextLine();
				
				if(!listSelect.equals("0")) {
					
					for(String board : searchList) {
						
						String[] temp = board.split(",");
						
						if(listSelect.equals(temp[0])) {
							
							BoardService view = new BoardService();
							view.boardView(temp[1], temp[6]);
							
						}
						
					}
					
				}
				
			}else if(select.equals("0")){
				loop = false;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
		
	}



	//작성자 검색
	/**
	 * 작성자 검색 메소드입니다.
	 */
	private void nameSearch() {
		
		ArrayList<String> searchList = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		
		boolean loop = true;
		
		while(loop) {
			
			searchList.removeAll(searchList);
			num = 1;
		
			System.out.println();
			System.out.println("========================================");
			System.out.println("               작성자 검색");
			System.out.println("========================================");
			System.out.println();
			
			System.out.print("▶ 키워드를 입력하세요.(0. 뒤로가기) : ");
			String select = scan.nextLine();
			
			if(!select.equals("0")) {
				
				System.out.println();
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println("                                                  키워드 : " + select);
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println();
				
				System.out.println("[번호]\t[제목]\t\t\t\t[내용]\t\t\t [작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
				System.out.println("----------------------------------------------------------"
						+ "--------------------------------------------------------------------------");
				
				for(String board : Data.freeBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[4].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
				
				for(String board : Data.marketBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[4].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
		
				for(String board : Data.inquiryBoard) {
			
					String[] temp = board.split(",");
					
					if(temp[4].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
			
				}
				
				if(searchList.isEmpty()) {
					
					System.out.println("검색 결과가 없습니다.");
					
				}else {
					
					for(String board : searchList) {
						
						//번호 제목 날짜 작성자
						//15,날씨 날씨 ,연락처 식사 학식 합격 ,2018-05-19/10:57:11,박재민,자유게시판,20116673
						//1,3,책 팔아요~,책 완전 이쁜데 팝니다!!,2018-06-16/17:27:11,손재돈,장터게시판,21750018
						
						String[] temp = board.split(",");
						
						System.out.printf("%5s\t%5s\t%20s\t\t%5s\t%5s\t%5s\t%5s\n"
								, temp[0]
								, temp[2]
								, temp[3]
								, temp[5]
								, temp[7]
								, temp[4]
								, temp[6]);
						
					}
					
					
				}
				
				System.out.println();
				System.out.print("▶글 선택(0. 뒤로가기) : ");
				String listSelect = scan.nextLine();
				
				if(!listSelect.equals("0")) {
					
					for(String board : searchList) {
						
						String[] temp = board.split(",");
						
						if(listSelect.equals(temp[0])) {
							
							BoardService view = new BoardService();
							view.boardView(temp[1], temp[6]);
							
						}
						
					}
					
				}
				
				
			}else if(select.equals("0")){
				loop = false;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
		
	}




	//제목 검색
	/**
	 * 제목 검색 메소드입니다.
	 */
	private void titleSearch() {
		
		ArrayList<String> searchList = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		
		boolean loop = true;
		
		while(loop) {
			
			searchList.removeAll(searchList);
			num = 1;
		
			System.out.println();
			System.out.println("\t\t\t\t  ========================================");
			System.out.println("\t\t\t\t                  제목 검색");
			System.out.println("\t\t\t\t  ========================================");
			System.out.println();
			
			System.out.print("\t\t\t\t  ▶ 키워드를 입력하세요.(0. 뒤로가기) : ");
			String select = scan.nextLine();
			
			
			
			if(!select.equals("0")) {
				
				System.out.println();
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println("                                                  키워드 : " + select);
				System.out.println("==========================================================="
								  + "===========================================================");
				System.out.println();
				
				System.out.println("[번호]\t[제목]\t\t\t\t[내용]\t\t\t [작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
				System.out.println("----------------------------------------------------------"
						+ "--------------------------------------------------------------------------");
			
				for(String board : Data.freeBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[2].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
				
				for(String board : Data.marketBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[2].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
					
				}
		
				for(String board : Data.inquiryBoard) {
			
					String[] temp = board.split(",");
					
					if(temp[2].contains(select)) {
						
						String data = num + "," + board;
						
						searchList.add(data);
						
						num++;
						
					}
			
				}
				
				if(searchList.isEmpty()) {
					
					System.out.println("검색 결과가 없습니다.");
					
				}else {
					
					for(String board : searchList) {
						
						//번호 제목 날짜 작성자
						//15,날씨 날씨 ,연락처 식사 학식 합격 ,2018-05-19/10:57:11,박재민,자유게시판,20116673
						//1,3,책 팔아요~,책 완전 이쁜데 팝니다!!,2018-06-16/17:27:11,손재돈,장터게시판,21750018
						
						String[] temp = board.split(",");
						
						System.out.printf("%5s\t%5s\t%20s\t\t%5s\t%5s\t%5s\t%5s\n"
								, temp[0]
								, temp[2]
								, temp[3]
								, temp[5]
								, temp[7]
								, temp[4]
								, temp[6]);
						
					}
					
					
				}
				
				System.out.println();
				System.out.print("▶ 글 선택(0. 뒤로가기) : ");
				String listSelect = scan.nextLine();
				
				if(!listSelect.equals("0")) {
					
					for(String board : searchList) {
						
						String[] temp = board.split(",");
						
						if(listSelect.equals(temp[0])) {
							
							BoardService view = new BoardService();
							view.boardView(temp[1], temp[6]);
							
						}
						
					}
					
				}
				
				
			}else if(select.equals("0")){
				loop = false;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		
		}
		
	}
	

	
}
