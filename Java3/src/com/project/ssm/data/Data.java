package com.project.ssm.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.project.ssm.matching.MatchingUser;
import com.project.ssm.login.LoginService;
import com.project.ssm.rental.Rental;
import com.project.ssm.user.User;
import com.project.ssm.matching.MatchingResultInterface;
import com.project.ssm.matching.MatchingResultUser;
import com.project.ssm.matching.MatchingUser;

/**
 * 데이터 관리 클래스입니다.
 * @author yangha-eun
 *
 */
public class Data {
	
	private final static String USER_txt;
	private final static String RENTAL_txt;
	private final static String FREE_txt;
	private final static String MARKET_txt;
	private final static String INQUIRY_txt;
	private final static String SCHEDULE_txt;
	private final static String RENTALRESERVE_txt;
	private final static String MATCHINGUSER_txt;
	private final static String MATHINGRESULTUSER_txt;
	private final static String GYM_txt;
	private final static String STUDYROOM_txt;
	private final static String AUDITORIUM_txt;
	private final static String PLAYGROUND_txt;
	
	
	public static ArrayList<User> userList;
	public static ArrayList<Rental> rentalList;
	public static ArrayList<String> freeBoard;
	public static ArrayList<String> marketBoard;
	public static ArrayList<String> inquiryBoard;
	public static ArrayList<String> scheduleList;
	public static ArrayList<String> rentalReserveList;
	public static ArrayList<MatchingUser> matchingUserList;
	public static ArrayList<MatchingResultUser> matchingResultUserList;
	public static ArrayList<String> gym;
	public static ArrayList<String> studyroom;
	public static ArrayList<String> auditorium;
	public static ArrayList<String> playground;
	
	static {
		
		USER_txt = "./dat/user.txt";
		RENTAL_txt = "./dat/rental.txt";
		FREE_txt = "./dat/freeBoard.txt";
		MARKET_txt = "./dat/marketBoard.txt";
		INQUIRY_txt = "./dat/inquiryBoard.txt";
		SCHEDULE_txt = "./dat/schedule.txt";
		RENTALRESERVE_txt = "./dat/rentalReserve.txt";
		MATCHINGUSER_txt = "./dat/matchinguser.txt";
		MATHINGRESULTUSER_txt = "./dat/matchingresultuser.txt";
		GYM_txt = "./dat/gym.txt";
		STUDYROOM_txt = "./dat/studyroom.txt";
		AUDITORIUM_txt = "./dat/auditorium.txt";
		PLAYGROUND_txt = "./dat/playground.txt";
		
		userList = new ArrayList<User>();
		rentalList = new ArrayList<Rental>();
		freeBoard = new ArrayList<String>();
		marketBoard = new ArrayList<String>();
		inquiryBoard = new ArrayList<String>();
		matchingUserList = new ArrayList<MatchingUser>();
		scheduleList = new ArrayList<String>();
		matchingUserList = new ArrayList<MatchingUser>();
		matchingResultUserList = new ArrayList<MatchingResultUser>();
		gym = new ArrayList<String>(); 
		studyroom = new ArrayList<String>(); 
		auditorium = new ArrayList<String>(); 
		playground = new ArrayList<String>(); 
		
		
	}
	
	/**
	 * 데이터들을 로드하는 메소드입니다.
	 */
	public static void load() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(USER_txt));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				User user = new User();
				
				user.setId(temp[0]);
				user.setPw(temp[1]);
				user.setName(temp[2]);
				user.setTel(temp[3]);
				user.setMajor(temp[4]);
				user.setJumin(temp[5]);
				user.setLive(temp[6]);
				
				
				userList.add(user);
				
			}
			reader.close();
			
			
			//시설대여 로드
			reader = new BufferedReader(new FileReader(RENTAL_txt));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				Rental rental = new Rental();
				
				rental.setDate(temp[0]);
				rental.setTime(temp[1]);
				rental.setFacility(temp[2]);
				rental.setReserve(temp[3]);
				
				rentalList.add(rental);
				
			}
			reader.close();
			
			//자유게시판 로드
			reader = new BufferedReader(new FileReader(FREE_txt));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				
				freeBoard.add(line);
				
			}
			reader.close();
			
			
			//장터게시판 로드
			reader = new BufferedReader(new FileReader(MARKET_txt));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				
				marketBoard.add(line);
				
			}
			reader.close();
			
			
			//문의게시판 로드
			reader = new BufferedReader(new FileReader(INQUIRY_txt));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				
				inquiryBoard.add(line);
				
			}
			reader.close();
			
			

			reader = new BufferedReader(new FileReader(MATCHINGUSER_txt));

	         line = null;

	         while ((line = reader.readLine()) != null) {

	            String[] temp = line.split(",");

	            MatchingUser matchingUser = new MatchingUser();
	            
	            //17309303,홍길동,22,유아교육과,남자,180,60,Y,하체,2.8,파이썬
	            //17309303,홍길동,22,유아교육과,남자,180,60,Y,하체,2.8,파이썬
	            
	            matchingUser.setId(temp[0]);
	            matchingUser.setName(temp[1]);
	            matchingUser.setAge(Integer.parseInt(temp[2]));
	            matchingUser.setMajor(temp[3]);
	            matchingUser.setGender(temp[4]);
	            matchingUser.setHeight(Integer.parseInt(temp[5]));
	            matchingUser.setWeight(Integer.parseInt(temp[6]));
	            matchingUser.setCc(temp[7]);
	            matchingUser.setExercise(temp[8]);
	            matchingUser.setGrade(Double.parseDouble(temp[9]));
	            matchingUser.setStudy(temp[10]);
	            
	            matchingUserList.add(matchingUser);

	         } // while
	         
	         reader.close();
			
	         
	         
	         
	         
	         reader = new BufferedReader(new FileReader(SCHEDULE_txt));

	         line = null;

	         while ((line = reader.readLine()) != null) {
	        	 
	        	 scheduleList.add(line);
	        	 
	         }
	         reader.close();
	         
	         
	        
				
				reader = new BufferedReader(new FileReader(MATHINGRESULTUSER_txt));

				line = null;

				while ((line = reader.readLine()) != null) {

					String[] temp = line.split(",");

					MatchingResultUser matchingResultUser = new MatchingResultUser();
					
					// 1,21453024,최찬형,26,의예과,남자,19946531,손진재,25,의예과,여자,연애
					matchingResultUser.setMatchingNumber(Integer.parseInt(temp[0]));
					matchingResultUser.setMyId(temp[1]);
					matchingResultUser.setMyName(temp[2]);
					matchingResultUser.setMyAge(Integer.parseInt(temp[3]));
					matchingResultUser.setMyMajor(temp[4]);
					matchingResultUser.setMyGender(temp[5]);
					matchingResultUser.setOtherId(temp[6]);
					matchingResultUser.setOtherName(temp[7]);
					matchingResultUser.setOtherAge(Integer.parseInt(temp[8]));
					matchingResultUser.setOtherMajor(temp[9]);
					matchingResultUser.setOtherGender(temp[10]);
					matchingResultUser.setCategory(temp[11]);
					
					matchingResultUserList.add(matchingResultUser);
					
				} // while
				
				reader.close();
	         
	        
				reader = new BufferedReader(new FileReader(GYM_txt));
				
				line = null;
				
				while ((line = reader.readLine()) != null) {
					
					gym.add(line);
					
				}
				
				reader.close();
				
				reader = new BufferedReader(new FileReader(STUDYROOM_txt));
				
				line = null;
				
				while ((line = reader.readLine()) != null) {
					
					studyroom.add(line);
					
				}
				reader.close();
				
				reader = new BufferedReader(new FileReader(AUDITORIUM_txt));
				
				line = null;
				
				while ((line = reader.readLine()) != null) {
					
					auditorium.add(line);
					
				}
				reader.close();
				
				reader = new BufferedReader(new FileReader(PLAYGROUND_txt));
				
				line = null;
				
				while ((line = reader.readLine()) != null) {
					
					playground.add(line);
					
				}
				reader.close();
			
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	/**
	 * 데이터를 저장하는 메소드입니다.
	 */
	public static void save() {
		
		try {
			
			//회원 저장
			BufferedWriter writer = new BufferedWriter(new FileWriter(USER_txt));
			
			for(User u : userList) {
				
				String data = String.format("%s,%s,%s,%s,%s,%s,%s"
											, u.getId()
											, u.getPw()
											, u.getName()
											, u.getTel()
											, u.getMajor()
											, u.getJumin()
											, u.getLive());
											
				writer.write(data + "\r\n");
				
			}
			
			writer.close();
			
			
			//시설대여 저장
			writer = new BufferedWriter(new FileWriter(RENTAL_txt));
			
			for(Rental r : rentalList) {
				
				String data = String.format("%s,%s,%s,%s"
											, r.getDate()
											, r.getTime()
											, r.getFacility()
											, r.getReserve());
				
				writer.write(data + "\r\n");
				
			}
			writer.close();
			
			
			//자유게시판 저장
			writer = new BufferedWriter(new FileWriter(FREE_txt));
			
			for(String free : freeBoard) {
				
				writer.write(free + "\r\n");
				
			}
			writer.close();
			
			
			//장터게시판 저장
			writer = new BufferedWriter(new FileWriter(MARKET_txt));
			
			for(String free : marketBoard) {
				
				writer.write(free + "\r\n");
				
			}
			writer.close();
			
			
			//문의게시판 저장
			writer = new BufferedWriter(new FileWriter(INQUIRY_txt));
			
			for(String free : inquiryBoard) {
				
				writer.write(free + "\r\n");
				
			}
			writer.close();
			
			
			 writer = new BufferedWriter(new FileWriter(MATCHINGUSER_txt));
	         
	         for(MatchingUser mu : matchingUserList) {
	        	//17309303,홍길동,22,유아교육과,남자,180,60,Y,하체,2.8,파이썬
	            
	            String data = String.format("%s,%s,%d,%d,%s,%s,%.1f,%s"
	                                 , mu.getId()
	                                 , mu.getGender()
	                                 , mu.getHeight()
	                                 , mu.getWeight()
	                                 , mu.getCc()
	                                 , mu.getExercise()
	                                 , mu.getGrade()
	                                 , mu.getStudy());
	            
	            writer.write(data + "\r\n");
	            
	         }
	         
	         
	         writer.close();
	         
	         writer = new BufferedWriter(new FileWriter(MATCHINGUSER_txt));
				
				for(MatchingUser mu : matchingUserList) {
					//20937782,정형진,25,컴퓨터학과,여자,161,69,Y,상체,2.7,C언어
					
					String data = String.format("%s,%s,%d,%s,%s,%d,%d,%s,%s,%.1f,%s"
												, mu.getId()
												, mu.getName()
												, mu.getAge()
												, mu.getMajor()
												, mu.getGender()
												, mu.getHeight()
												, mu.getWeight()
												, mu.getCc()
												, mu.getExercise()
												, mu.getGrade()
												, mu.getStudy());
					
					writer.write(data + "\r\n");
					
				}
				
				
				writer.close();
				
				writer = new BufferedWriter(new FileWriter(MATHINGRESULTUSER_txt));
				
				for(MatchingResultUser mu : matchingResultUserList) {
					// 1,21453024,최찬형,26,의예과,남자,19946531,손진재,25,의예과,여자,연애
					
					String data = String.format("%d,%s,%s,%d,%s,%s,%s,%s,%d,%s,%s,%s"
												, mu.getMatchingNumber()
												, mu.getMyId()
												, mu.getMyName()
												, mu.getMyAge()
												, mu.getMyMajor()
												, mu.getMyGender()
												, mu.getOtherId()
												, mu.getOtherName()
												, mu.getOtherAge()
												, mu.getOtherMajor()
												, mu.getOtherGender()
												, mu.getCategory());
					
					writer.write(data + "\r\n");
					 
				}
				
				writer.close();
	         
				
				writer = new BufferedWriter(new FileWriter(GYM_txt));
				
				for (String gym : gym) {
					
					writer.write(gym + "\r\n");
					
				}
				writer.close();
				
				writer = new BufferedWriter(new FileWriter(STUDYROOM_txt));
				
				for (String gym : studyroom) {
					
					writer.write(gym + "\r\n");
					
				}
				writer.close();
				
				writer = new BufferedWriter(new FileWriter(AUDITORIUM_txt));
				
				for (String gym : auditorium) {
					
					writer.write(gym + "\r\n");
					
				}
				writer.close();
				
				writer = new BufferedWriter(new FileWriter(PLAYGROUND_txt));
				
				for (String gym : playground) {
					
					writer.write(gym + "\r\n");
					
				}
				writer.close();
	         
	         
			
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	public static String UserGetName() {
		
		String name = "";
		
		for(User u : Data.userList) {
			
			if(LoginService.finalId.equals(u.getId())) {
				name = u.getName();
			}
		}
		
		return name;
		
	}
	
	//일시 정지
	/**
	 * 일시 정지하는 메소드입니다.
	 */
		public static void pause() {
			
			System.out.println();
			System.out.println("계속하시려면 엔터를 입력하세요.");
			
			Scanner scan = new Scanner(System.in);
			scan.nextLine();
			
			System.out.println();
		}
	
		
		public static User getUserId(String id) {
			
			for(User user : userList) {
				
				if(user.getId().equals(id)) {
					return user;
				}
			}
			return null;
		}
		
		
		//관리자 회원삭제
		public static boolean deleteUser(String id) {
			
			for(User user : userList) {
				
				if(user.getId().equals(id)) {
					
					return userList.remove(user);
				}
			}
			
			return false;
		}
		
		
		
		//회원탈퇴
		/**
		 *  회원탈퇴 메소드입니다.
		 * @param id 회원 아이디입니다.
		 * @param pw 회원 패스워드입니다.
		 * @return 실패하면 false, 성공하면 true를 반환
		 */
		public static boolean deleterUserIdPw(String id, String pw) {
			
			for(User user : userList) {
				
				if(user.getId().equals(id) && user.getPw().equals(pw)) {
					
					return userList.remove(user);
				
				}
			}
			return false;
		}
		

		//ID(학번) 찾기
		/**
		 * ID(학번) 착기 메소드입니다.
		 * @param name 입력한 학번입니다.
		 * @param jumin 입력한 주민번호입니다.
		 * @return 리스트 반환
		 */
	    public static ArrayList<User> searchUserId(String name, String jumin) {
			
			ArrayList<User> ulist = new ArrayList<User>(); 
			
			for(User user : userList) {
				if(user.getName().equals(name) && user.getJumin().equals(jumin)) { 
					ulist.add(user);
					
				}
			}
			
			return ulist;
		}
	    
	    //pw 찾기
	    /**
	     * 패스워드 찾기 메소드입니다.
	     * @param id 입력한 학번입니다.
	     * @param jumin 입력한 주민번호입니다.
	     * @return 리스트 반환
	     */
	    public static ArrayList<User> searchUserPw(String id, String jumin) {
			
			ArrayList<User> ulist = new ArrayList<User>(); 
			
			for(User user : userList) {
				if(user.getId().equals(id) && user.getJumin().equals(jumin)) { 
					ulist.add(user);
					
				}
			}
			
			return ulist;
		}
		
		
	    /**
	       * ID(학번) 유효성 검사 메소드입니다.
	       * @param id ID(학번)을 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean idCheck(String id) {
			
			for(User user : userList) {
				
				if(user.getId().equals(id)) {
					return false;
				}
			}
			
			if(id.length() != 8) {
				return false;
			}
			
			
			for(int i=0; i<id.length(); i++) {
				char c = id.charAt(i);
				
				if((c < '0' || c > '9')) {
					return false;
				}
			}
			
			return true;
		}
		
		 /**
	       * pw 유효성 검사 메소드입니다.
	       * @param pw 비밀번호를 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean pwCheck(String pw) {
			
			if(pw.length() < 6) {
				return false;
			}
			for(int i=0; i<pw.length(); i++) {
				char c = pw.charAt(i);
				
				if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9')) {
					return false;
				}
			}
			return true;
		}
		
		/**
	       * 이름 유효성 검사메소드 입니다.
	       * @param name 이름을 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean nameCheck(String name) {
			
			if(name.length() < 2 && name.length() > 5) {
				return false;
			}
			
			for(int i=0; i<name.length(); i++) {
				char c = name.charAt(i);
				
				if((c < '가' || c > '힣')) {
					return false;
				}
			}
			return true;
		}
		
		/**
	       * 전화번호 유효성 검사 메소드입니다.
	       * @param tel 전화번호를 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean telCheck(String tel) {
			
			//010-2394-3945
			String temp = tel;
			
			tel = tel.replace("-", "");
			if(tel.length() != 11){
				return false;
			}
			
			if(tel.charAt(0) != '0' || tel.charAt(1) != '1' || tel.charAt(2) != '0') {
				return false;
			}
			
			for(int i=0;i<tel.length();i++){
					
				char c = tel.charAt(i);
					
				if(c < '0' || c > '9'){	
					return false;
				}
			}
			return temp != null;
		}
		
		 /**
	       * 주민등록번호 유효성 검사 메소드입니다.
	       * @param jumin 주민등록번호를 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean juminCheck(String jumin) {
			//990610-2749641
			String temp = jumin;
			jumin = jumin.replace("-", "");
				
			if(jumin.length() != 13) {
				return false;
			}
			
			if(jumin.charAt(6) != '1' && jumin.charAt(6) != '2' 
			        && jumin.charAt(6) != '3' && jumin.charAt(6) != '4') {
				return false;
			}
				
			for(int i=0; i<jumin.length(); i++) {
				char c = jumin.charAt(i);
					
				if(c < '0' || c > '9') {
					System.out.println("error 3");
					return false;
				}
			}
			return temp != null;
		}
		
		 /**
	       * 학과 유효성 검사 메소드입니다.
	       * @param major 학과를 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean majorCheck(String major) {
			
				for(User user : userList) {
				
				if(user.getMajor().equals(major)) {
					return true;
				}
			}
				return false;
		}
		
		/**
	       * 거주유형 유효성 검사 메소드입니다.
	       * @param live 거주유형을 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean liveCheck(String live) {
			
				for(User user : userList) {
				
				if(user.getLive().equals(live)) {
					return true;
				}
			}
				return false;
		}
		
		/**
	       * ID(학번)을 반환하는 메소드입니다.
	       * @param name 이름
	       * @return boolean 리턴
	       */
		public static User getUser(String name) {
			
			for(User user : userList) {
				
				if(user.getId().equals(name)) {
					return user;
				}
			}
			return null;
		}
		
		 /** 
	       * ID(학번) 중복확인 유효성 검사 메소드입니다.
	       * @param id ID(학번)을 입력합니다.
	       * @return boolean 리턴
	       */
		public static boolean idDuplication(String id) {
			for(User user : userList) {
				
				if(user.getId().equals(id)) {
					return false;
				}
			}
			return true;
		}
	

}
