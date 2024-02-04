package com.java.member.employee;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.common.Data;
import com.java.common.Validation;
import com.java.member.user.UserVoice;
import com.java.view.View;

public class UserVoiceSearch {
	
	protected static void userVoiceAll() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			String sel = "";
			
			userVoicePage(Data.userVoiceList);
			System.out.println("내용을 확인할 민원의 제목을 입력하세요");
			System.out.println("그만 확인하려면 back을 입력하세요");
			sel = scan.nextLine();
			
			if(sel.equals("back")) {
				break;
			}
			
			if( Validation.is_UserVoiceTitle(sel)) {
				System.out.println("올바른 제목");
				
				for(UserVoice voice : Data.userVoiceList) {
					
					if(voice.getTitle().equals(sel)) {
						voice.setIsRead("읽음");
						System.out.println(voice.getContent());
						View.pause();
						
						break; // 민원객체 탐색 종료
					}
					
				}
				
				
			}else {
				System.out.println("잘못된 제목");
				System.out.println("다시 입력하세요.");
				View.pause();
			}
			
			
		}//while루프 종료
		
		
		
		
	}//End of userVoiceAll()
	
	
	public static void userVoicePage(ArrayList<UserVoice> list) {
		// 리스트의 페이지수 계산
		int page = (int)(Math.ceil((double)list.size() / 10));
		
		int index = 0;		// 문자로 입력받은 숫자를 int로 변환
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			String sel = "";	// 입력받는 문자열
			
			// View클래스 출력
			System.out.println("======================================================");
			System.out.println("                  민원 리스트");
			System.out.println("======================================================");
			
			list.stream().skip(index * 10)
			 							 .limit(10)
			 							 .forEach(uservoice -> System.out.printf("%-10s|%-20s|%-3s|\r\n"
					 													, uservoice.getId()
					 													, uservoice.getTitle()
					 													, uservoice.getIsRead()));
			// 이름, ID, 전화번호, 직급, 호선, 역이름
			System.out.printf("Page| %s / %s\r\n", index + 1, page);
			System.out.print("back입력시 뒤로갑니다.");
			System.out.print("원하는 페이지: ");
			sel = scan.nextLine();
			
			if(sel.equals("back")) {
				break;
			}else if (Validation.is_NumString(sel)) {
				index = Integer.parseInt(sel) - 1;
				
				if(index < 0 || index >= page) {
					System.out.println("페이지 범위를 벗어났습니다.");
					System.out.println("다시 입력해주세요.");
					index = 0;
					
				}
				
			}else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		}//while루프 종료
		
	}//End of lostArticlePage()
	
	
	
}//End of class