package com.project.ssm.board;

import java.util.Scanner;

import com.project.ssm.data.Data;

/**
 * 문의게시판 클래스입니다.
 * @author yangha-eun
 *
 */
public class InquiryBoard {
	
	/**
	 * 문의게시판 메인 화면 메소드입니다.
	 */
	public void mainInterface() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println();
			System.out.println("\t\t\t\t  ========================================");
			System.out.println("\t\t\t\t               문의 게시판");
			System.out.println("\t\t\t\t  ========================================");
			
			System.out.println();
			System.out.println("\t\t\t\t  ========================================");
	        System.out.println("\t\t\t\t       1. 글쓰기         2. 글보기 ");
	        System.out.println("\t\t\t\t       0. 뒤로가기  ");
	        System.out.println("\t\t\t\t  ========================================");
	        System.out.println();
	        
			System.out.print("\t\t\t\t  ▶ 메뉴 선택 : ");
			String select = scan.nextLine();
			
			if(select.equals("1")) {
				
				String boardCategory = "문의게시판";
				
				BoardService boardService = new BoardService();
				boardService.creteBoard(boardCategory);
				
			}else if(select.equals("2")) {
				
				inquiryBoardList();
				
			}else if(select.equals("0")){
				
				loop = false;
				
			}
		}
		
	}

	
	/**
	 * 문의게시판 전체 글 목록 보기 메소드입니다.
	 */
	public void inquiryBoardList() {
		
		System.out.println();
		
		String boardType = "inquiryBoard";
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
		
			System.out.println();
			System.out.println("==========================================================="
							  + "===========================================================");
			System.out.println("                                                    문의 게시판");
			System.out.println("==========================================================="
							  + "===========================================================");
			System.out.println();
			
			System.out.println("[번호]\t[제목]\t\t\t\t[내용]\t\t\t [작성자]\t[학번]\t\t[날짜/시간]");
			System.out.println("----------------------------------------------------------"
					+ "----------------------------------------------------------");
			
			for(String inquiryList : Data.inquiryBoard) {
				String[] free = inquiryList.split(",");
				
				System.out.printf("%5s\t%5s\t%20s\t\t%5s\t%5s\t%5s\n"
									, free[0]
									, free[1]
									, free[2]
									, free[4]
									, free[6]
									, free[3]);
				
			}
			
			System.out.println();
			System.out.print("글 번호 선택(0.뒤로가기) : ");
			String select = scan.nextLine();
			
			if(!(select.equals("0"))) {
				BoardService read = new BoardService();
				read.boardView(select, boardType);
			}else if(select.equals("0")) {
				loop = false;
			}
		
		}
		
	}

}
