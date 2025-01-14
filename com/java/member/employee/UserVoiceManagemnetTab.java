package com.java.member.employee;

import java.util.Scanner;

import com.java.common.LoginLogout;
import com.java.common.lostarticle.LostArticleTab;
import com.java.view.ViewAll;

/**
 * 고객의 소리 관리하는 메뉴 나타내는 클래스
 */
public final class UserVoiceManagemnetTab {
	
	/**
	 * UserVoiceManagemnetTab클래스의 기본 생성자
	 */
	public UserVoiceManagemnetTab() {
	}

	/**
	 * 고객의 소리 관리하는 메뉴 나타내는 메서드
	 */
	protected static void userVoiceManagementTab() {
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			/**
			 * 입력한 값을 저장하는 변수
			 */
			String sel = ""; // 선택한 번호
			
			//System.out.println(LoginLogout.position + " " + LoginLogout.auth + "님");
			ViewAll.vocMain();
			System.out.print("\t\t\t선택 (번호): ");
			sel = scan.nextLine();
			
			if(sel.equals("1")) {			// 1. 전체 분실물 보기
				LostArticleTab.lostArticleTab();
			} else if(sel.equals("2")) {	// 2. 직원 민원 보기
				UserVoiceSearch.userVoiceAll();
			} else if (sel.equals("")) {	//    뒤로가기
				
				// 민원 종료
				break;
					
			} else { // 이외의 숫자 입력 시
					System.out.println("\t\t\t해당 섹션이 없습니다.");
					System.out.println("\t\t\t다시 입력해주세요.");
					ViewAll.pause();
			}
			
			
		}// while루프 종료
		
	}//End of userVoiceManagementTab()
	
	
}//End of class
