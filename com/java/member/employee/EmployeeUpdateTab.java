package com.java.member.employee;

import java.util.Scanner;

import com.java.common.Data;
import com.java.common.LoginLogout;
import com.java.common.Validation;
import com.java.member.user.User;
import com.java.view.View;

public class EmployeeUpdateTab {
	
	
	public static void employeeUpdate() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String sel = ""; // 선택한 번호
			
			// View클래스 출력
			System.out.println("=======================================");
			System.out.printf("             직원 정보 수정          ");
			System.out.println(LoginLogout.position + " " + LoginLogout.auth + "님");
			System.out.println("=======================================");
			System.out.println("           1. 근무지 변경");
			System.out.println("           2. 직급 변경");
			System.out.println("           3. 권한 부여");
			System.out.println("           4. 계정 삭제");
			System.out.println("           5. 뒤로가기");
			System.out.println("--------------------------------------");
			System.out.print("선택 (번호): ");
			sel = scan.nextLine();
			
			if(sel.equals("1")) {			//1. 근무지 변경
				update("1");
			}else if (sel.equals("2")) {	//2. 직급 변경
				update("2");
			}else if (sel.equals("3")) {	//3. 권한 부여
				update("3");
			}else if (sel.equals("4")) {	// 4. 계정삭제
				deleteAccount();
			}else if (sel.equals("5")) {	// 5. 뒤로가기
				break;
			}else {
				//다시입력
				System.out.println();
				System.out.printf("해당 섹션이 없습니다\r\n다시입력해주세요.\r\n");
				View.pause();
			}
			
			
		
		}//while루프 종료
		
	}//End of employeeUpdate()
	
	public static void update(String sel) {
		
		// View클래스에서 출력
		if(sel.equals("1")) 		System.out.println("근무지 변경");
		else if (sel.equals("2"))   System.out.println("직급 변경");
		else if (sel.equals("3"))	System.out.println("권한 부여");
		
		Scanner scan = new Scanner(System.in);
		
		// 전체 직원 리스트 보여주기
		EmployeeSearch.employeePage(Data.employeeList);
		
		// 아이디 입력받기
		System.out.println("직원의 아이디를 입력해주세요.");
		System.out.printf("아이디: ");
		String input = scan.nextLine();
		final String ID = input;
		
		// 직원계정이고 최고권한이 없는 계정만 가능
		if(Validation.is_EmployeeId(input) && (!Validation.is_Sudo(input)) ) {
			
			// 직원계정의 정보를 출력
			Data.employeeList.stream().filter(employee -> employee.getId().equals(ID))
							      .forEach(employee -> 
							System.out.printf("이름: %10s|아이디: %20s|생년월일: %6s|전화번호: %13s|직급: %2s|담당지: %s호선 %s역\r\n"
												, employee.getName()
												, employee.getId()
												, employee.getRegistration().substring(0, 6)
												, employee.getPhone()
												, employee.getPosition()
												, employee.getLine()
												, employee.getStation()));
			
			if(sel.equals("1")) 		updateWorkArea(ID);	// 근무지 변경
			else if (sel.equals("2"))   updatePosition(ID);	// 직급 변경
			else if (sel.equals("3"))	updateLevel(ID);	// 
			
		} else {
			System.out.println("없는 아이디입니다.");
			View.pause();
		}
	}//End of searchEmployeeId()
	
	
	// 직급 변경
	public static void updatePosition(String id) {
			
			Scanner scan = new Scanner(System.in);
			
			while(true) {
				String input = "";
				System.out.println("안전요원|사원|대리|과장|부장|사장");
				System.out.println("변경할 직급: ");
				input = scan.nextLine();
				
				if( Validation.is_Position(input)) {
					
					for(Employee employee : Data.employeeList) {
						
						if(employee.getId().equals(id)) {
							employee.setPosition(input);
							
							System.out.println("직급변경이 완료되었습니다.");
							
							break;	// 직원 객체 탐색 종료
						}
						
					}
					
					break;
				}else {
					System.out.println("잘못된 직급");
					View.pause();
				}
			}
		
	}//End of updatePosition()
	
	// 권한 변경
	public static void updateLevel(String id) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String input = "";
			System.out.println("권한없음 -> 2 | 권한있음 -> 3 ");
			System.out.println("변경할 권한: ");
			input = scan.nextLine();
			
			if( Validation.is_Level(input)) {
				
				for(Employee employee : Data.employeeList) {
					
					if(employee.getId().equals(id)) {
						employee.setLevel(input);;
						
						System.out.println("권한변경이 완료되었습니다.");
						
						break;	// 직원 객체 탐색 종료
					}
					
				}
				
				break;
			}else {
				System.out.println("잘못된 권한");
				View.pause();
			}
		}
		
	}//End of updateLevel()

	// 근무지 변경
	public static void updateWorkArea(String id) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			boolean check = false;
			String input = "";
			System.out.println("1호선 ~ 9호선");
			System.out.println("정확히 'N호선'입력: ");
			input = scan.nextLine();
			
			if( Validation.is_Line(input)) {
				
				input = input.charAt(0) + "";
				
				final String LINE = input;
				
				// 선택한 호선의 역이름들 보여주기
				switch (Integer.parseInt(input)) {
					
					case 1: Data.LINE1_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 2: Data.LINE2_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 3: Data.LINE3_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 4: Data.LINE4_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 5: Data.LINE5_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 6: Data.LINE6_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 7: Data.LINE7_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 8: Data.LINE8_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
					case 9: Data.LINE9_STATION_NAME.stream().forEach(name -> System.out.println(name));
							break;
						
				}
				
				System.out.println("역 이름: ");
				input = scan.nextLine();
				
				final String STATION = input;
				
				switch (Integer.parseInt(LINE)) {
				
				case 1: check = Data.LINE1_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 2: check = Data.LINE2_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 3: check = Data.LINE3_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 4: check = Data.LINE4_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 5: check = Data.LINE5_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 6: check = Data.LINE6_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 7: check = Data.LINE7_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 8: check = Data.LINE8_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
				case 9: check = Data.LINE9_STATION_NAME.stream().anyMatch(name -> name.equals(STATION));
						break;
					
				}	
				
				
				// 맞으면 해당 아이디의 호선, 역이름을 변경하고 종료
				// 틀리면 역 이름만 다시 입력받기
				
				if(check) {// 호선과 이름이 맞을경우
					
					for(Employee employee : Data.employeeList) {
						
						if(employee.getId().equals(id)) {
							
							employee.setLine(LINE);			// 호선 변경
							employee.setStation(STATION);	// 역 변경
							System.out.println("근무지 변경 완료");
							View.pause();
							break;	// 직원객체 탐색 종료
							
						}
						
					}
					
					// 호선과 역이름입력받기 종료
					break;
					
				}else {	   // 역이름이 호선과 틀릴경우
					System.out.println("잘못된 역이름 또는 호선에 맞지않는 역이름");
					View.pause();
				}
				
			}else {
				System.out.println("잘못된 호선");
				View.pause();
			}
			
		}//while루프 종료
		
	}//End of updateWorkArea()
	
	public static void deleteAccount() {
		
		boolean userCheck = false;
		boolean employeeCheck = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 계정의 아이디를 입력해주세요.");
		System.out.printf("아이디: ");
		String input = scan.nextLine();
		final String DELETE = input;
		
		userCheck = Data.userList.stream().anyMatch(user -> user.getId().equals(DELETE));
		employeeCheck = Data.employeeList.stream().anyMatch(employee -> employee.getId().equals(DELETE));
		
		
		if(userCheck) {
			System.out.println("선택된 아이디는 고객 계정입니다");
			Data.userList.stream().filter(user -> user.getId().equals(DELETE))
							      .forEach(user -> 
							System.out.printf("이름: %s\r\n아이디: %s\r\n생년월일: %s\r\n전화번호: %s\r\n정기권유무: %s\r\n정기권기간: %s\r\n"
												, user.getName()
												, user.getId()
												, user.getRegistration().substring(0, 6)
												, user.getPhone()
												, user.getPassCheck()
												, user.getPassExpiry()));
			System.out.println("해당 계정을 삭제하시겠습니까?");
			System.out.println("yes만 삭제: ");
			input = scan.nextLine();
			
			if(input.equals("yes")) {
				
				for(User user : Data.userList) {
					
					if(user.getId().equals(DELETE)) {
						Data.userList.remove(user);
						break;
					}
					
				}
				
			}else {
				System.out.println("계정삭제 취소");
			}
			
			
		}else if (employeeCheck && (!Validation.is_Sudo(DELETE)) ) {
			System.out.println("선택된 아이디는 직원 계정입니다");
			Data.employeeList.stream().filter(employee -> employee.getId().equals(DELETE))
									  .forEach(employee -> 
							System.out.printf("이름: %s\r\n아이디: %s\r\n생년월일: %s\r\n전화번호: %s\r\n직급: %s\r\n근무지: %s호선 %s역\r\n권한: %s\r\n"
												, employee.getName()
												, employee.getId()
												, employee.getRegistration().substring(0, 6)
												, employee.getPhone()
												, employee.getPosition()
												, employee.getLine()
												, employee.getStation()
												, employee.getLevel()));
			System.out.println("해당 계정을 삭제하시겠습니까?");
			System.out.println("yes만 삭제: ");
			input = scan.nextLine();
			
			if(input.equals("yes")) {
				
				for(Employee employee : Data.employeeList) {
					
					if(employee.getId().equals(DELETE)) {
						Data.employeeList.remove(employee);
						System.out.println(DELETE + "계정 삭제완료");
						View.pause();
						break;	// employee객체 탐색 중지
					}
					
				}
				
				
			}else {
				System.out.println("계정삭제 취소");
			}
			
			
		}else if (employeeCheck && (!Validation.is_Sudo(DELETE))) {
			System.out.println("최고권한 계정은 삭제할수없습니다.");
		}
		else {
			System.out.println("입력하신 계정은 존재하지 않습니다.");
		}
		
		View.pause();
		
	}//End of deleteAccount()
	
}//End of class