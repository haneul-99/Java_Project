
package com.project.ssm.dummy;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;

import com.project.ssm.data.Data;
/**
 * 더미 클래스입니다.
 * @author yangha-eun
 *
 */
public class Dummy {

   public static void main(String[] args) {
      
	  
//      try {
//		Student();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
      
//      try {
//    	  
//    	  matchingUser();
//    	  
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
//      
//    
//      
//      try {
//		rental();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
      
      
      //board();
      
      

   }//main
   
   /**
    * 매칭유저에 대한 더미 정보를 만드는 메소드입니다.
    * @throws Exception
    */
   private static void matchingUser() throws Exception {

	   	//18100123,홍길동,010-1111-2222,컴퓨터공학과,980927-2348291,자취,175,65,Y,농구,3.8,자바
	      
	   Data.load();
	   
	      Random rnd = new Random();
	      
	      HashSet<String> studentList = new HashSet<String>();
	      
	      String data = "";
	      String gender = "";
	      
	      int maleHeight = 0;
	      int maleWeight = 0;
	      
	      // 과 CC여부
			String[] consent = {"Y", "N"};
			// 운동분야
			String[] exercise = { "농구", "축구", "하체", "상체", "배드민턴" };
			// 공부분야
			String[] study = { "자바", "JSP", "C언어", "파이썬", "C#", "DB" };
	      
	      try {
	    	  
			FileWriter writer = new FileWriter("./dat/matchinguser.txt");
			
			while(studentList.size() < 50) {
				
				
		    	  
				int i = rnd.nextInt(Data.userList.size());
				
				int age = 0;
				
				if (Data.userList.get(i).getJumin().substring(0,2).equals("96")) {
					age = 27;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("97")){
					age = 26;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("98")) {
					age = 25;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("99")) {
					age = 24;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("00")) {
					age = 23;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("01")) {
					age = 22;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("02")) {
					age = 21;
				} else if (Data.userList.get(i).getJumin().substring(0,2).equals("03")) {
					age = 20;
				}
				
				
				if(Data.userList.get(i).getJumin().substring(7, 8).equals("1") || 
						Data.userList.get(i).getJumin().substring(7, 8).equals("3")) {
					
					gender = "남자";
					maleHeight = rnd.nextInt(20) + 170;
					maleWeight = rnd.nextInt(30) + 50;
					
				}else if(Data.userList.get(i).getJumin().substring(7, 8).equals("2") || 
						Data.userList.get(i).getJumin().substring(7, 8).equals("4")) {
					
					gender = "여자";
					
					maleHeight = rnd.nextInt(20) + 150;
					maleWeight = rnd.nextInt(30) + 40;
					
				}
				
				
				
				//17309303,홍길동,22,유아교육과,남자,180,60,Y,하체,2.8,파이썬
				//17309303,홍길동,22,유아교육과,남자,180,60,Y,하체,2.8,파이썬
				data = String.format("%s,%s,%d,%s,%s,%d,%d,%s,%s,%.1f,%s"
									, Data.userList.get(i).getId()
									, Data.userList.get(i).getName()
									, age
									, Data.userList.get(i).getMajor()
									, gender
									, maleHeight
									, maleWeight
									, consent[rnd.nextInt(2)]
									, exercise[rnd.nextInt(5)]
									, (float) rnd.nextDouble() * 3 + 1.5 // 1.5 ~ 4.5
									, study[rnd.nextInt(6)]);
				
				studentList.add(data);
				
				writer.write(data + "\r\n");
				 
				 
				
		      }
			
			 writer.close();
			
		} catch (Exception e) {
			System.out.println("Dummy.matchingUser");
			e.printStackTrace();
		}
	         
	         
	       
	      
	      
	   }

   

   /**
    * 게시판에 대한 더미 정보를 만드는 메소드입니다.
    */
   private static void board() {
	
	   Random rnd = new Random();
	   
	   Calendar boardTime = Calendar.getInstance();
	   
	   String[] freeBoard = {"강아지 ", "고양이 ", "귀여워 ", "이쁘다" , "학식 ", "저녁 ", "식사 ", "좋아요 "
			   				, "셔틀 ", "싸강" , "옆자리 ", "옷 ", "주세요 ", "합니다 ", "합격 ", "수업 "
			   				, "연락처 ", "주실 분 ", "학생 ", "장소 ", "건물 ", "날씨 ", "어때요? ", "게임 "};
	   
	   String[] marketBoard1 = {"책 ", "옷 ", "청바지 ", "치마 ", "전공책 ", "후드 ", "교재 "
			   					, "신발 ", "슬랙스 ", "가디건 "};
	   String[] marketBoard2 = {"싸게 ", "직거래로 ", "택배로 ", "완전 이쁜데 ", "중고로 ", "거의 새 책 "
			   					,"상태 좋음 ", "깨끗해요 ", "새 상품 "};
	   String[] marketBoard3 = {"팔아용", "팔아요.", "팝니다~", "팔아요~", "팝니다!!"};
	   
	   String[] inquiryBoard = {"문의", "신고", "제기", "기능", "안돼요", "있나요?", "변경", "하고싶어요."
			   					, "취소"};
	   String[] year = {"2018", "2019", "2020", "2021", "2022"};
	   
	   try {
		
		   FileWriter writer = new FileWriter("./dat/freeBoard.txt");
		   
		   int num = 1;
		   
		   for(int i=0; i<15; i++) {
			   
			   int month = Integer.parseInt(String.format("%02d", (rnd.nextInt(11) + 1)));
			   int date = Integer.parseInt(String.format("%02d", (rnd.nextInt(30) + 1)));
			   
			   boardTime.set(Integer.parseInt(year[rnd.nextInt(year.length)])
					   		 , month, date, rnd.nextInt(22) + 1, rnd.nextInt(60));
			   
			   Data.load();
			   
			   int userNum = rnd.nextInt(Data.userList.size()-1);
			   
			   String data = String.format("%d,%s,%s,%tF/%tT,%s,%s,%s"
					   						, num
					   						, freeBoard[rnd.nextInt(freeBoard.length)] + freeBoard[rnd.nextInt(freeBoard.length)]
					   						, freeBoard[rnd.nextInt(freeBoard.length)] + freeBoard[rnd.nextInt(freeBoard.length)]
					   							+ freeBoard[rnd.nextInt(freeBoard.length)] + freeBoard[rnd.nextInt(freeBoard.length)]
					   						, boardTime
					   						, boardTime
					   						, Data.userList.get(userNum).getName()
					   						, "자유게시판"
					   						, Data.userList.get(userNum).getId());
		   
			   writer.write(data + "\r\n");
			   num++;
			   
		   }
		   writer.close();
		   
		   
		   writer = new FileWriter("./dat/marketBoard.txt");
		   
		   num = 1;
		   
		   for(int i=0; i<15; i++) {
			   
			   int month = Integer.parseInt(String.format("%02d", (rnd.nextInt(11) + 1)));
			   int date = Integer.parseInt(String.format("%02d", (rnd.nextInt(30) + 1)));
			   
			   boardTime.set(Integer.parseInt(year[rnd.nextInt(year.length)])
					   		 , month, date, rnd.nextInt(22) + 1, rnd.nextInt(60));
			   
			   int product = rnd.nextInt(marketBoard1.length);
			   
			   Data.load();
			   
			   int userNum = rnd.nextInt(Data.userList.size()-1);
			   
			   String data = String.format("%d,%s,%s,%tF/%tT,%s,%s,%s"
					   						, num
					   						, marketBoard1[product] + marketBoard3[rnd.nextInt(marketBoard3.length)]
					   						, marketBoard1[product] + marketBoard2[rnd.nextInt(marketBoard2.length)]
					   							+ marketBoard3[rnd.nextInt(marketBoard3.length)]
					   						, boardTime
					   						, boardTime
					   						, Data.userList.get(userNum).getName()
					   						, "장터게시판"
					   						, Data.userList.get(userNum).getId());
		   
			   writer.write(data + "\r\n");
			   num++;
			   
		   }
		   writer.close();
		   
		   
		   writer = new FileWriter("./dat/inquiryBoard.txt");
		   
		   num = 1;
		   
		   for(int i=0; i<15; i++) {
			   
			   int month = Integer.parseInt(String.format("%02d", (rnd.nextInt(11) + 1)));
			   int date = Integer.parseInt(String.format("%02d", (rnd.nextInt(30) + 1)));
			   
			   boardTime.set(Integer.parseInt(year[rnd.nextInt(year.length)])
					   		 , month, date, rnd.nextInt(22) + 1, rnd.nextInt(60));
			   
			   Data.load();
			   
			   int userNum = rnd.nextInt(Data.userList.size()-1);
			   
			   String data = String.format("%d,%s,%s,%tF/%tT,%s,%s,%s"
					   						, num
					   						, inquiryBoard[rnd.nextInt(inquiryBoard.length)] + inquiryBoard[rnd.nextInt(inquiryBoard.length)]
					   						, inquiryBoard[rnd.nextInt(inquiryBoard.length)] + inquiryBoard[rnd.nextInt(inquiryBoard.length)]
					   							+ inquiryBoard[rnd.nextInt(inquiryBoard.length)]
					   						, boardTime
					   						, boardTime
					   						, Data.userList.get(userNum).getName()
					   						, "문의게시판"
					   						, Data.userList.get(userNum).getId());
		   
			   writer.write(data + "\r\n");
			   num++;
			   
		   }
		   writer.close();
		   
		   
		   
		   
		   
	} catch (Exception e) {
		System.out.println("Dummy.board");
		e.printStackTrace();
	}
	
   }


   /**
    * 시설대여에 관한 정보를 생성하는 메소드입니다.
    * @throws Exception
    */
private static void rental() throws Exception {
	      
	      //2022-09-27,10:00~11:50,체육관,O
	      
	      Calendar now = Calendar.getInstance();
	      
	      // 파일 기록
	      FileWriter writer = new FileWriter("./dat/rental.txt");
	      
	      for (int i = 9; i <= 12; i++) {

	         for (int j = 1; j <= now.getActualMaximum(Calendar.DAY_OF_MONTH) ; j++) {

	            now.set(2022, i - 1, j);
	            
	            String[] facility = { "체육관", "소강당", "스터디룸", "운동장" };
	            String[] time = { "10:00~11:50", "12:00~13:50", 
	                  "14:00~15:50", "16:00~17:50", "18:00~19:50", "20:00~21:50" };
	            
	            /*
	             
	            2022-12-29,10:00~11:50,운동장,O
	            2022-12-29,12:00~13:50,운동장,O
	            2022-12-29,14:00~15:50,운동장,O
	            2022-12-29,16:00~17:50,운동장,O
	            2022-12-29,18:00~19:50,운동장,O
	            2022-12-29,20:00~21:50,운동장,O
	            
	            */
	            
	            for (int k = 0; k < 4; k++) {
	               
	               for (int l = 0; l < 6; l++) {
	                  
	                  String data = "";
	                  
	                  data = String.format("%tF,%s,%s,%s"
	                                       , now
	                                       , time[l]
	                                       , facility[k]
	                                       , "O");
	                  writer.write(data + "\r\n");
	                  
	               }
	            }

	         } // 2022-09-01 ~ 2022-12-31

	      }
	      
	      writer.close();
	      
	      
	      
	   }

   
   
   

/**
 * 유저(학생)에 대한 더미 정보를 만드는 메소드입니다.
 * @throws Exception
 */
   private static void Student() throws Exception {
      
      //18100123,hello32,홍길동,010-1111-2222,컴퓨터공학과,980927-2348291,자취,175,65,Y,농구,3.8,자바
      
      Random rnd = new Random();
      
      ArrayList<String> studentList = new ArrayList<String>();
      
      int num = 1;
      
      String[] name1 = {"김","이","박","정","최","손","유"};
      String[] name2 = {"신","재","효","정","진","현","재","형","민","돈","수","나","연","찬"};
      
      String[] pw1 = {"tkrhk","java","qkqh","rnfma","dhfpswl","tkfkd","rlck","zjvl"};
      String[] pw2 = {"123","349","4902","19","391","221","119"};
      
      String[] major = {"컴퓨터학과","멀티미디어학과","간호학과","건축학과","유아교육과","경찰행정학과","식품영양학과","전자공학과","호텔경영학과","의예과"};
      
      String[] jumin1 = {"96","97","98","99","00","01","02","03"};
      String[] jumin2 = {"01","02","03","04","05","06","07","08","09","10","11","12"};
      String[] jumin3 = {"1","2"};
      String[] jumin4 = {"3", "4"};
      
    //거주유형
      String[] area = {"자취","통학","기숙사"};
      
      String juminGender = "";
      
      //과 CC여부
      String[] consent = {"Y","N"};
      
      //운동분야
      String[] exercise = {"농구","축구","하체","상체","배드민턴"};
      
      //공부분야
      String[] study = {"자바","JSP","C언어","파이썬","C#","DB"};
      
      
      
      //파일 기록
      FileWriter writer = new FileWriter("./dat/student.txt");
      
      for(int i=0; i<major.length; i++) {
         
         for(int j=0; j<50; j++) {
        	 
         int no1 = rnd.nextInt(6) + 17;
         int no2 = rnd.nextInt(899999) + 100000;
         
         String studentNum = no1 + "" + no2;
         
         for(String n : studentList) {
        	 if(n.equals(studentNum)) {
        		 j--;
        	 }
         }
        	 
         String jumin = jumin1[rnd.nextInt(jumin1.length)]
        		 		+jumin2[rnd.nextInt(jumin2.length)]
        		 		+(rnd.nextInt(20)+10)
        		 		+"-";
         
         if(jumin.substring(0, 2).equals("96") || jumin.substring(0, 2).equals("97") 
        	|| jumin.substring(0, 2).equals("98") || jumin.substring(0, 2).equals("99")) {
        	 
        	 juminGender = jumin3[rnd.nextInt(jumin3.length)];
        	 
         }else {
        	 
        	 juminGender = jumin4[rnd.nextInt(jumin4.length)];
        	 
         }
         
         jumin += juminGender + (rnd.nextInt(800000) + 100000);
         
         
         String data = String.format("%s,%s,%s,%s,%s,%s,%s"
                                      , studentNum //학번
                                      , pw1[rnd.nextInt(pw1.length)] + pw2[rnd.nextInt(pw2.length)]
                                      , name1[rnd.nextInt(name1.length)] 
                                           + name2[rnd.nextInt(name2.length)]
                                           + name2[rnd.nextInt(name2.length)]
                                      , String.format("010-%d-%d", rnd.nextInt(9000) + 1000
                                                                 , rnd.nextInt(9000) + 1000)
                                      , major[i] //학과
                                      , jumin
                                      , area[rnd.nextInt(area.length)] //거주유형
                                      );
         
         writer.write(data + "\r\n");
         
         }         
         
      }
      writer.close();
      
   }

}