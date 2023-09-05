package com.project.ssm.admin;

import java.util.Scanner;

import com.project.ssm.board.BoardService;
import com.project.ssm.board.FreeBoard;
import com.project.ssm.board.InquiryBoard;
import com.project.ssm.board.MarketBoard;

/**
 * 관리자 게시판 관리 클래스입니다.
 * @author yangha-eun
 *
 */
public class AdminBoard {

	public void adminBoardInterface() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
		
			System.out.println();
			System.out.println("========================================");
			System.out.println("             게시판 리스트");
			System.out.println("========================================");
			
			System.out.println();
	        System.out.println("========================================");
	        System.out.println("      1. 글쓰기         2. 글보기 ");
	        System.out.println("      0. 뒤로가기    ");
	        System.out.println("========================================");
	        System.out.println();
			
			System.out.println();
			System.out.print("▶ 메뉴 선택 : ");
			String select = scan.nextLine();
			
			if(select.equals("1")) {
				
				//글 쓰기
				adminWriter();
				
			}else if(select.equals("2")) {
				
				//글 보기
				adminBoardList();
				
			}else if(select.equals("0")) {
				
				loop = false;
				
			}
			
		}
		
	}

	private void adminBoardList() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
        System.out.println("========================================");
        System.out.println("  1. 자유 게시판       2. 장터 게시판 ");
        System.out.println("  3. 문의 게시판       0. 뒤로가기  ");
        System.out.println("========================================");
        System.out.println();
		
		System.out.println();
		System.out.print("▶ 메뉴 선택 : ");
		String select = scan.nextLine();
		
		if(select.equals("1")) {
			freeBoard();
		}else if(select.equals("2")) {
			marketBoard();
		}else if(select.equals("3")) {
			inqueryBoard();
		}else if(select.equals("0")) {
			
		}else {
			System.out.println("잘못 입력하였습니다.");
		}
		
	}

	private void inqueryBoard() {
		
		InquiryBoard inquiryBoard = new InquiryBoard();
		inquiryBoard.inquiryBoardList();
		
	}

	private void marketBoard() {
		
		MarketBoard marketBoard = new MarketBoard();
		marketBoard.marketBoardList();
		
	}

	private void freeBoard() {
		
		FreeBoard freeBoard = new FreeBoard();
		freeBoard.freeBoardList();
		
	}

	private void adminWriter() {
		
		BoardService boardService = new BoardService();
		boardService.creteBoard("자유게시판");
		
		
		
	}

}
