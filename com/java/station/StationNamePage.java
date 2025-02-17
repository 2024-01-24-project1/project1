package com.java.station;

import java.util.ArrayList;
import java.util.Scanner;

import com.java.view.ViewAll;

/**
 * 호선을 입력받아 해당 역의 이름을 페이지로 나눠 출력하는 클래스
 */
public class StationNamePage {

	/**
	 * StationNamePage클래스의 기본 생성자
	 */
	public StationNamePage() {
	}
	
	
	/**
	 * 호선을 입력받아 해당 역의 이름을 페이지로 나눠 출력하는 메서드
	 * @param list 역 리스트
	 * @param line 호선
	 */
	public static void stationNamePage(ArrayList<String> list, String line) {
		
		line = line.replace("호선","");
		
		try { 
			if(Integer.parseInt(line)<1 || Integer.parseInt(line)>9) {
				return;
			}
			
		} catch (Exception e) {
			return;
		}
		
		/**
		 * 한 페이지에 보여줄 역의 개수를 저장하는 변수
		 */
		int pageSize = 6; // 한 페이지에 보여줄 역의 개수
		/**
		 * 전체 페이지 수를 저장하는 변수
		 */
        int totalPages = (int) Math.ceil((double) list.size() / pageSize); // 전체 페이지 수

        /**
         * 현재 페이지 번호를 저장하는 변수
         */
        int currentPage = 0; // 현재 페이지 번호
        Scanner scanner = new Scanner(System.in);
        
        if(!line.endsWith("선")) {
        	line+="호선";
        }

        while (true) {
            System.out.println("=======================================================================");
            System.out.printf("\t\t\t\t%s 역리스트\r\n", line);
            System.out.println("=======================================================================");
        	ViewAll.stationNamePageTable(line);

            // 현재 페이지에 해당하는 역 목록 출력
        	/**
        	 * 첫 페이지의 인덱스를 저장하는 변수
        	 */
            int startIndex = currentPage * pageSize;
            /**
             * 마지막 페이지의 인덱스를 저장하는 변수
             */
            int endIndex = Math.min(startIndex + pageSize, list.size());
            list.subList(startIndex, endIndex).stream().forEach(station -> {
                System.out.printf("%-18s     \t", station);
                if (list.indexOf(station) % 3 == 2 || list.indexOf(station) == endIndex - 1) // 한 줄에 역 이름을 3개씩 출력
                    System.out.println();
            });
            System.out.println();
            System.out.printf("\n\t\t\t\tPage | %d / %d\n", currentPage + 1, totalPages);
            System.out.println();
            System.out.println("\t\t\t엔터를 누르면 페이지모드 종료.");
            System.out.print("\t\t\t페이지 번호 입력: ");
            String input = scanner.nextLine();
			
            if (input.equals("")) { // 엔터 입력 시 페이지모드 종료
                break;
            } else if (input.matches("\\d+")) { // 숫자 입력 확인
                int pageNumber = Integer.parseInt(input);
                if (pageNumber > 0 && pageNumber <= totalPages) {
                    currentPage = pageNumber - 1;
                } else {
                    System.out.println("\t\t\t페이지 범위를 벗어났습니다. 다시 입력해주세요.");
                }
            } else {
                System.out.println("\t\t\t잘못된 입력입니다. 다시 입력해주세요.");
            }
			
		}//while루프 종료
		
	}//End of stationNamePage()
	
	
}//End of class
