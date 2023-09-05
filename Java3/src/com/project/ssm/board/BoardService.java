package com.project.ssm.board;

import java.util.Calendar;
import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginInterface;
import com.project.ssm.login.LoginService;
import com.project.ssm.main.MainInterface;

/**
 * 게시판 서비스 클래스입니다.
 * @author yangha-eun
 *
 */
public class BoardService {
	
	String id = LoginService.finalId;
	String name = Data.UserGetName();
	String title = "";
	String content = "";
	
	//게시판 글 생성
	/**
	 * 게시판 글 생성 메소드입니다.
	 * @param category 게시판 카테고리입니다.
	 */
	public void creteBoard(String category) {
		
		Scanner scan = new Scanner(System.in);
		
		Calendar c = Calendar.getInstance();
		
		System.out.println();
		
		boolean loop = true;
		
		while(loop) {
		
			System.out.print("\t\t\t\t  ▶ 제목 : ");
			title = scan.nextLine();
			
			title = textValidation(title);
			
			if(title.length() > 49 || title.length() < 3) {
				System.out.println("\t\t\t\t  --------------------------------------------");
				System.out.println("\t\t\t\t  제목은 4자 이상, 15자 이내로 입력 해주세요.");
				System.out.println("\t\t\t\t  --------------------------------------------");
				
			}else {
				loop = false;
			}
		
		}
		
		loop = true;
		
		while(loop) {
			System.out.print("\t\t\t\t  ▶ 내용 : ");
			content = scan.nextLine();
			
			content = textValidation(content);
			
			if(content.length() >= 500) {
				System.out.println("\t\t\t\t  ------------------------------------");
				System.out.println("\t\t\t\t  내용은 500자 이내로 입력 해주세요");
				System.out.println("\t\t\t\t  ------------------------------------");
			}else {
				loop = false;
			}
		}
		
		System.out.println();
		System.out.println("\t\t\t\t  1. 글 작성");
		System.out.println("\t\t\t\t  0. 뒤로가기");
		
		System.out.println();
		System.out.print("\t\t\t\t  ▶ 메뉴 선택 : ");
		String select = scan.nextLine();
		
		if(select.equals("1")) {
			
			if(category.equals("자유게시판")) {
			
				String[] lastFreeBoard = Data.freeBoard.get(Data.freeBoard.size()-1).split(",");
				String lastNum = (Integer.parseInt(lastFreeBoard[0]) + 1) + "";
				
				String data = String.format("%s,%s,%s,%tF/%tT,%s,%s,%s"
											, lastNum
											, title
											, content
											, c
											, c
											, name == "" ? "관리자" : name
											, category
											, id);
				
				Data.freeBoard.add(data);
				
			}else if(category.equals("장터게시판")) {
				
				String[] lastFreeBoard = Data.marketBoard.get(Data.marketBoard.size()-1).split(",");
				int lastNum = Integer.parseInt(lastFreeBoard[0]) + 1;
				
				String data = String.format("%d,%s,%s,%tF/%tT,%s,%s,%s"
											, lastNum
											, title
											, content
											, c
											, c
											, name
											, category
											, id);
				
				Data.marketBoard.add(data);
				
			}else if(category.equals("문의게시판")) {
				
				String[] lastFreeBoard = Data.inquiryBoard.get(Data.inquiryBoard.size()-1).split(",");
				int lastNum = Integer.parseInt(lastFreeBoard[0]) + 1;
				
				String data = String.format("%d,%s,%s,%tF/%tT,%s,%s,%s"
											, lastNum
											, title
											, content
											, c
											, c
											, name
											, category
											, id);
				
				Data.inquiryBoard.add(data);
				
			}
			
			System.out.println();
			System.out.println("\t\t\t\t  글을 추가하였습니다.");
			Data.pause();
			
		}else if(select.equals("0")){
			System.out.println();
			System.out.println("\t\t\t\t  취소하였습니다.");
			Data.pause();
		}
	}
		
		
		
		//금지어 유효성 검사
		/**
		 * 게시판 금지어 유효성 검사 메소드입니다.
		 * @param title 글쓴이가 쓴 text입니다.
		 * @return 금지어를 *로 바꾸어 리턴합니다.
		 */
		public String textValidation(String title) {
			
			String[] word = {"씨발", "시발", "ㅅㅂ", "시바", "또라이", "도라이", "또라이", "병신", "장애인"
							, "애미", "애비", "개새끼", "쉬바", "존나", "미친"}; 
			
			for(int i=0; i<word.length; i++) {
				title = title.replace(word[i], getText(word[i]));
			}
			
			return title;
		}


		public static String getText(String string) {
			
			String text = "";
			
			for(int i=0; i<string.length(); i++) {
				text += "*";
			}
			
			return text;
		}
		
		
		
		
		
		//게시판 글 자세히 보기
		/**
		 * 게시판 글 자세히 보는 메소드입니다.
		 * @param select 게시판 고유 번호입니다.
		 * @param boardType 게시판 카테고리입니다.
		 */
		public void boardView(String select, String boardType) {
			
			Scanner scan = new Scanner(System.in);
			
			if(boardType.equals("freeBoard") || boardType.equals("자유게시판")) {
			
				for(String board : Data.freeBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[0].equals(select)) {
						System.out.println();
						System.out.println("\t\t\t==================================================================");
						System.out.printf("\t\t\t%30s\n",temp[1]);
						System.out.println("\t\t\t==================================================================");
						System.out.println();
						
						System.out.println("\t\t\t[작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
						System.out.printf("\t\t\t%s\t\t%s\t%s\t%s\n", temp[4], temp[6], temp[3], temp[5]);
						
						System.out.println();
						System.out.println("\t\t\t[내용]");
						System.out.println("\t\t\t------------------------------------------------------------------");
						System.out.println();
						System.out.println("\t\t\t" + temp[2]);
						System.out.println();
						System.out.println("\t\t\t------------------------------------------------------------------");
						
					}
					
					
				}
				
				
				if(LoginService.finalId.equals("관리자")) {
					
					System.out.println();
					System.out.println("\t\t\t1. 삭제하기");
					System.out.println("\t\t\t0. 뒤로가기");
					System.out.println();
					System.out.print("\t\t\t▶ 메뉴 선택 : ");
					
					String answer = scan.nextLine();
					
					if(answer.equals("1")) {
						BoardService boardService = new BoardService();
						boardService.boardDelete(select, boardType);
					}
					
				}else {
					
					System.out.println();
					System.out.println("\t\t\t0. 뒤로가기");
					System.out.println();
					System.out.print("\t\t\t▶ 메뉴 선택 : ");
					
					String answer = scan.nextLine();
					
				}
				
				
				
			}else if(boardType.equals("marketBoard") || boardType.equals("장터게시판")) {
				
				for(String board : Data.marketBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[0].equals(select)) {
						System.out.println();
						System.out.println("\t\t\t==================================================================");
						System.out.printf("\t\t\t%30s\n",temp[1]);
						System.out.println("\t\t\t==================================================================");
						System.out.println();
						
						System.out.println("\t\t\t[작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
						System.out.printf("\t\t\t%s\t\t%s\t%s\t%s\n", temp[4], temp[6], temp[3], temp[5]);
						
						System.out.println();
						System.out.println("\t\t\t[내용]");
						System.out.println("\t\t\t------------------------------------------------------------------");
						System.out.println();
						System.out.println("\t\t\t" + temp[2]);
						System.out.println();
						System.out.println("\t\t\t------------------------------------------------------------------");
						
					}
					
					
				}
				
				
				if(LoginService.finalId.equals("관리자")) {
					
					System.out.println();
					System.out.println("\t\t\t1. 삭제하기");
					System.out.println("\t\t\t0. 뒤로가기");
					System.out.println();
					System.out.print("\t\t\t▶ 메뉴 선택 : ");
					
					String answer = scan.nextLine();
					
					if(answer.equals("1")) {
						BoardService boardService = new BoardService();
						boardService.boardDelete(select, boardType);
					}
					
				}else {
					System.out.println();
					System.out.println("\t\t\t0. 뒤로가기");
					System.out.println();
					System.out.print("\t\t\t▶ 메뉴 선택 : ");
					
					String answer = scan.nextLine();
				
				}
			
			}else if(boardType.equals("inquiryBoard") || boardType.equals("문의게시판")) {
				
				for(String board : Data.inquiryBoard) {
					
					String[] temp = board.split(",");
					
					if(temp[0].equals(select)) {
						System.out.println();
						System.out.println("\t\t\t==================================================================");
						System.out.printf("\t\t\t%30s\n",temp[1]);
						System.out.println("\t\t\t==================================================================");
						System.out.println();
						
						System.out.println("\t\t\t[작성자]\t[학번]\t\t[날짜/시간]\t\t[카테고리]");
						System.out.printf("\t\t\t%s\t\t%s\t%s\t%s\n", temp[4], temp[6], temp[3], temp[5]);
						
						System.out.println();
						System.out.println("\t\t\t[내용]");
						System.out.println("\t\t\t------------------------------------------------------------------");
						System.out.println();
						System.out.println("\t\t\t" + temp[2]);
						System.out.println();
						System.out.println("\t\t\t------------------------------------------------------------------");
						
					}
					
				
				}
				
				if(LoginService.finalId.equals("관리자")) {
					
					System.out.println();
					System.out.println("\t\t\t1. 삭제하기");
					System.out.println("\t\t\t0. 뒤로가기");
					System.out.println();
					System.out.print("\t\t\t▶ 메뉴 선택 : ");
					
					String answer = scan.nextLine();
					
					if(answer.equals("1")) {
						BoardService boardService = new BoardService();
						boardService.boardDelete(select, boardType);
					}
					
				}else {
					System.out.println();
					System.out.println("\t\t\t0. 뒤로가기");
					System.out.println();
					System.out.print("\t\t\t▶ 메뉴 선택 : ");
					
					String answer = scan.nextLine();
				
				}
				
				
			}


		
		}
		
		
		//글 삭제
		/**
		 * 게시판 글 삭제 매소드입니다.
		 * @param num 게시판 고유 번호입니다.
		 * @param type 게시판 카테고리 입니다.
		 */
		public void boardDelete(String num, String type) {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println();
			System.out.print("\t\t\t▶ 해당 글을 삭제하시겠습니까?(Y/N) : ");
			String answer = scan.nextLine();
			System.out.println();
			
			answer = answer.toLowerCase();
			
			if(answer.equals("y")) {
				
				try {
					
						
						
						if(type.equals("freeBoard")) {
							
							for(String freeboard : Data.freeBoard) {
								
								String[] freetemp = freeboard.split(",");
								
								if(freetemp[0].equals(num)) {
									
									Data.freeBoard.remove(freeboard);
									break;
									
								}
								
							}
							
						}else if (type.equals("marketBoard")){
							
							for(String freeboard : Data.marketBoard) {
								
								String[] freetemp = freeboard.split(",");
								
								if(freetemp[0].equals(num)) {
									
									Data.marketBoard.remove(freeboard);
									break;
									
								}
								
							}
							
						}else if (type.equals("inquiryBoard")){
							
							for(String freeboard : Data.inquiryBoard) {
								
								String[] freetemp = freeboard.split(",");
								
								if(freetemp[0].equals(num)) {
									
									Data.inquiryBoard.remove(freeboard);
									break;
									
								}
								
							}
							
						}
						
						System.out.println("\t\t\t삭제하였습니다.");
						Data.pause();
					
				} catch (Exception e) {
					System.out.println("BoardService.boardDelete");
					e.printStackTrace();
				}
				
			}else {
				System.out.println();
				System.out.println("\t\t\t취소하였습니다.");
				Data.pause();
			}
			
		}
			
	}
		

