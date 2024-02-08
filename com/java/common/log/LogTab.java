package com.java.common.log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.common.Data;
import com.java.common.Validation;
import com.java.member.employee.Employee;
import com.java.view.ViewAll;

public class LogTab {

	public static void printLog() {

		
		ArrayList<Log> logPage = new ArrayList<>();
		logPage = Data.logList;

		logPage(logPage); // 로그 페이지 출력

		System.out.println("╬╬═════════════╬╬═════════════╬╬═════════════╬╬═════════════╬╬═════════════╬╬");
		System.out.println();
		searchLog();

		LogSave.logSave(LogSave.VIEWLOG);
		ViewAll.pause();


		
	}
	public static void logPage(ArrayList<Log> list) {
		
		// 리스트의 페이지수 계산
		int page = (int)(Math.ceil((double)list.size() / 5));
		
		int index = 0;		// 문자로 입력받은 숫자를 int로 변환
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			String sel = "";	// 입력받는 문자열
			
			// View클래스 출력
			ViewAll.logView();
			
			list.stream().skip(index * 5)
			 			 .limit(5)
			 			 .forEach(log -> System.out.printf("\t날짜   : %s\t아이디  : %s\t로그 수: %d\n" 
			 					 													,log.getTime()
			 					 													,log.getId()
			 					 													,log.getAction().size()));
					 										
					 											
			System.out.printf("\n\t\t\t  Page| %s / %s\r\n", index + 1, page);
			System.out.println("\t\t\t  엔터시 리스트보기가 종료됩니다.");
			System.out.print("\t\t\t  원하는 페이지: ");
			sel = scan.nextLine();
			
			if(sel.equals("")) {
				break;
			}else if (Validation.is_NumString(sel)) {
				index = Integer.parseInt(sel) - 1;
				
				if(index < 0 || index >= page) {
					System.out.println("\t\t\t페이지 범위를 벗어났습니다.");
					System.out.println("\t\t\t다시 입력해주세요.");
					index = 0;

				}

			}else {
				System.out.println("\t\t\t잘못된 입력입니다.");
				System.out.println("\t\t\t다시 입력해주세요.");
			}

		}//while루프 종료
	}	
	private static void searchLog() {

		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String sel = "";


			while(true) {
				
				System.out.println("\t\t\t     1. 자세히 검색");
				//System.out.println("\t\t\t    엔터를 입력 뒤로가기");
				System.out.print("\t\t\t   입력 : ");
				sel = reader.readLine();
				
				if(sel.equals("1")) {
					
					String id = "";
					String time = "";
					boolean check = false;
				
					while(true) {

						System.out.print("\t\t\t검색할 아이디     : ");
						id = reader.readLine();

						System.out.print("\t\t\t검색할 날짜(-포함): ");
						time = reader.readLine();

						check = Validation.is_existLog(id, time);

						if(check) {
							break;
						}else if(!check) {

							System.out.println("\t\t\t잘못된 입력입니다");
							System.out.println("\t\t\t다시 입력하시려면 아무키나 입력하세요");
							System.out.println("\t\t\t뒤로가시려면 엔터입력");
							System.out.printf("\t\t\t입력: ");
							sel = reader.readLine();

							if(sel.equals("")) {

								return;
							}

						}
					}
					ViewAll.logView();
					System.out.printf("     날짜         \t 아이디\t\t\t행동로그\n");
					
					for(Log log : Data.logList) {
						
						if(log.getId().equals(id) && log.getTime().equals(time)) {
							
							int index = 1;
							
							System.out.printf("  %s       \t%s \n",time,id);
							
							for(int i=0; i<log.getAction().size(); i++) {
								
								System.out.printf("\t\t\t\t      %d. %s\n",index++,log.getAction().get(i));
								
							}
							System.out.println("╬╬═════════════╬╬═════════════╬╬═════════════╬╬═════════════╬╬═════════════╬╬");
							System.out.println();
							
						}
						
						
					}
					
					
					
				}
				
				
				else if(sel.equals("")) {
					break;
				}	else {
					
					System.out.println("\t\t\t해당 섹션이 없습니다.");
					System.out.println("\t\t\t다시 입력해주세요.");
					ViewAll.pause();
					
					
				}
			}
			







	} catch (Exception e) {
		System.out.println("LogTab.printLog()");
		e.printStackTrace();
	}






}



}
