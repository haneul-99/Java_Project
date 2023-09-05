package com.project.ssm.matching;

import java.util.Scanner;

import com.project.ssm.data.Data;
import com.project.ssm.login.LoginService;
import com.project.ssm.user.User;

/**
 * 운동 매칭 클래스입니다.
 * @author 김경현, 김유진
 *
 */
public class ExerciseMatch {

	/**
	 * 운동 매칭화면을 출력하는 메소드
	 */
   public void exerciseAddInfo() {
      
      boolean loop =  true;
      
       Scanner scan = new Scanner(System.in);

         while (loop) {

            System.out.println("===================");
            System.out.println("  운동 매칭 추가입력");
            System.out.println("===================");
            System.out.println();
            System.out.println("0. 뒤로가기");
            System.out.println("1. 삭제하기");
            System.out.println("2. 입력하기");
            System.out.println();
            System.out.println("-------------------");
            
            System.out.print("메뉴 선택: ");
            String sel = scan.nextLine();

            if (sel.equals("1")) {
               delete();
            } else if (sel.equals("2")) {
               add();
            } else if (sel.equals("0")) {
               System.out.println("이전 화면으로 돌아갑니다..");
               loop = false;
            } else {
               System.out.println("잘못된 숫자를 입력받았습니다.");
               Data.pause();
            }

         }
   }

   /**
	 * 원하는 운동 분야를 저장하는 메소드
	 */
   private void add() {
      
      boolean loop = true;
      Scanner scan = new Scanner(System.in);

      while (loop) {   
         
      System.out.println("※ 원하는 운동 분야를 선택해주세요. [1.농구 2.축구 3.하체 4.상체 5.배드민턴]");
      System.out.print("▶ 운동 분야 번호: ");
      String wantExercise = scan.nextLine();
      
      System.out.print("추가 정보를 저장하시겠습니까?(Y/N): ");
      String addInfoSave = scan.nextLine();
      
      
      String exercise = "";
      
      if (wantExercise.equals("1")) {

          exercise = "농구";
          
       } else if (wantExercise.equals("2")) {

          exercise = "축구";
          
       } else if (wantExercise.equals("3")) {

          exercise = "하체";
          
       } else if (wantExercise.equals("4")) {

          exercise = "상체";
          
       } else if (wantExercise.equals("5")) {

          exercise = "배드민턴";
          
       } 
      
      if (addInfoSave.toUpperCase().equals("Y")) {
            
            for (MatchingUser mu : Data.matchingUserList) {

               if (LoginService.finalId.equals(mu.getId())) {
                  
                  if (wantExercise.equals("1")) {
                     
                     mu.setExercise("농구");
                     
                  } else if (wantExercise.equals("2")) {
                     
                     mu.setExercise("축구");
                     
                  } else if (wantExercise.equals("3")) {
                     
                     mu.setExercise("하체");
                     
                  } else if (wantExercise.equals("4")) {
                     
                     mu.setExercise("상체");
                     
                  } else if (wantExercise.equals("5")) {
                     
                     mu.setExercise("배드민턴");
                     
                  } else {
                     
                     System.out.println("잘못된 번호를 입력하셨습니다.");
                     Data.pause();
                  }
           
               }

            }

            //매칭유저리스트에(운동) 추가
			
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
					u.setHeight(0);
					u.setWeight(0);
					u.setCc(null);
					u.setExercise(exercise);
					u.setGrade(0.0);
					u.setStudy(null);
					
					
					boolean check = true;
					

					for(MatchingUser m : Data.matchingUserList) {
						
						if(m.getId().equals(LoginService.finalId)) {
							if(m.getExercise().equals("null")) {
							
								System.out.println();
								System.out.println("이미 등록되어있습니다. 등록된 정보로 매칭합니다.");
								check = false;
								Data.pause();
								break;
							}else {
								
								m.setExercise(exercise);
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
         
      // 매칭결과 인터페이스로 이동
         MatchingResultInterface matchingresultinterface = new MatchingResultInterface();
         matchingresultinterface.begin(exercise);
         
         loop = false;
         
      } else if (addInfoSave.toUpperCase().equals("N")) {
         System.out.println("매칭 추가입력 화면으로 돌아갑니다..");
         loop = false;
         
      } else {
         System.out.println("잘못된 번호입니다.");
         loop = false;
      } 
      }
      
   }
   
   /**
    * 추가정보 삭제 메소드입니다.
    */
   private void delete() {
      
      //추가 정보 삭제
      Scanner scan = new Scanner(System.in);

         System.out.print("삭제하면 입력한 추가 정보가 모두 사라집니다. 진행하시겠습니까? (Y/N): ");

         String sel = scan.nextLine();
         
         if (sel.toUpperCase().equals("Y")) {
            
            for (MatchingUser mu : Data.matchingUserList) {
               
               //데이터가 null이 아닐때 삭제
               if (LoginService.finalId.equals(mu.getId()) && !(mu.getExercise().equals("null"))) {
                  
                  
                  mu.setExercise("null");
                  
                  System.out.println("삭제가 완료됐습니다.");
                    Data.pause();
                    return;
               
                    //데이터가 null일때
               } else if (LoginService.finalId.equals(mu.getId()) && (mu.getExercise().equals("null"))) {
                  
                  System.out.println("삭제할 데이터가 존재하지 않습니다.");
                  Data.pause();
                  return;
                  
               }
               
            }
            
            //N선택시 매칭 정보 추가 화면으로 이동 
         } else if (sel.toUpperCase().equals("N")) {
            
            System.out.println("매칭 추가입력 화면으로 돌아갑니다..");
            Data.pause();
            return;
            
         } else {
            System.out.println("잘못된 문자를 입력했습니다.");
            Data.pause();
            return;
         }   
   
   }
      
}
