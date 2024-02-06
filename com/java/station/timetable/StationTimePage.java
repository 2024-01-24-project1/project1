package com.java.station.timetable;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.common.Data;
import com.java.common.Validation;

public class StationTimePage {

	public static void stationTimePage(String line, String stationName, String weekOf) {
		
		Scanner scan = new Scanner(System.in);
		
		String set = "5";	// 보고싶은 시간표의 시간 입력받기
		
		ArrayList<String> up = new ArrayList<String>();
		ArrayList<String> down = new ArrayList<String>();
		
		
		for(StationTime time : Data.stationTimeList) {
			
			if(time.getLine().equals(line) && time.getStationName().equals(stationName)) {
				
				if(weekOf.equals("평일")) {
					
					for(String t : time.getUpNomal()) {
						
						if( t.contains(":")) {
							
							up.add(t);
							
						}else if (t.charAt(0) == '0') {
							
							up.add(t.substring(1));
							
						}
						
						
					}
					
					for(String t : time.getDownNomal()) {
						
						if( t.contains(":")) {
							
							down.add(t);
							
						}else if (t.charAt(0) == '0') {
							
							down.add(t.substring(1));
							
						}
						
						
					}
					
					// 객체 탐색 종료
					break;
					
				}else if (weekOf.equals("주말")) {
					
					for(String t : time.getUpHoliday()) {
						
						if( t.contains(":")) {
							
							up.add(t);
							
						}else if (t.charAt(0) == '0') {
							
							up.add(t.substring(1));
							
						}
						
						
					}
					
					for(String t : time.getDownHoliday()) {
						
						if( t.contains(":")) {
							
							down.add(t);
							
						}else if (t.charAt(0) == '0') {
							
							down.add(t.substring(1));
							
						}
						
						
					}
					
					// 객체 탐색 종료
					break;
				}
				
			}
				
		}
		
		while(true) {
			
			final String SETTIME = set;
			String sel = "";
			
			// View클래스 출력
			System.out.println("======================================================");
			System.out.printf("               %s %s역 %s 시간표\r\n", line, stationName, weekOf);
			System.out.println("======================================================");
			System.out.println("                시간적기");
			System.out.printf("%-10s\t%-10s\r\n", up.get(0), down.get(0));
			System.out.println("======================================================");
			
			// 첫줄
			up.stream().filter(time -> time.startsWith(SETTIME))
			 		   .limit(5)
			 		   .forEach(time -> System.out.printf("%-7s\t", time));
			
			System.out.print("|");
			
			down.stream().filter(time -> time.startsWith(SETTIME))
					   .limit(5)
					   .forEach(time -> System.out.printf("%-7s\t", time));
			System.out.println();
			
			//둘째줄
			up.stream().filter(time -> time.startsWith(SETTIME))
			   .skip(5)
	 		   .limit(5)
	 		   .forEach(time -> System.out.printf("%-7s\t", time));
	
			System.out.print("|");
	
			down.stream().filter(time -> time.startsWith(SETTIME))
			   .skip(5)
			   .limit(5)
			   .forEach(time -> System.out.printf("%-7s\t", time));
			System.out.println();
			
			//셋째줄
			up.stream().filter(time -> time.startsWith(SETTIME))
			   .skip(10)
	 		   .limit(5)
	 		   .forEach(time -> System.out.printf("%-7s\t", time));
	
			System.out.print("|");
	
			down.stream().filter(time -> time.startsWith(SETTIME))
			   .skip(10)
			   .limit(5)
			   .forEach(time -> System.out.printf("%-7s\t", time));
			System.out.println();
			
			//넷째줄
			up.stream().filter(time -> time.startsWith(SETTIME))
			   .skip(15)
	 		   .limit(5)
	 		   .forEach(time -> System.out.printf("%-7s\t", time));
	
			System.out.print("|");
	
			down.stream().filter(time -> time.startsWith(SETTIME))
			   .skip(15)
			   .limit(5)
			   .forEach(time -> System.out.printf("%-7s\t", time));
			System.out.println();
			
			// 이름, ID, 전화번호, 직급, 호선, 역이름
			System.out.print("엔터입력시 종료");
			System.out.println("7입력시 07:00 ~ 08:00");
			System.out.print("원하는 시간: ");
			sel = scan.nextLine();
			
			if(sel.equals("")) {
				break;
			}else if ( Validation.is_OperationTime(sel)) {
				set = sel;
			}else if ( Validation.is_NumString(sel) && !Validation.is_OperationTime(sel)) {
				System.out.println("입력하신 시간은 열차가 운행하지 않는 시간입니다.");
			}
			else {
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
		}//while루프 종료
		
	}//End of stationTimePage()
	
}//End of class
