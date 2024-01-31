package mainRepo.com.java.common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.Charset;

import mainRepo.com.java.calendar.Calendar;
import mainRepo.com.java.common.log.Log;
import mainRepo.com.java.common.lostarticle.LostArticle;
import mainRepo.com.java.member.employee.Employee;
import mainRepo.com.java.member.user.User;
import mainRepo.com.java.member.user.UserVoice;

public class Exit {

	Data data = new Data();
	
	public void writeAll() {
		writeUserList();
		writeEmployeeList();
		writePassList();
		writeCalendarList();
		writeLogList();
		writeUserVoiceList();
		writeLostArticleList();
		
	}
	
	private void writeLostArticleList() {
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter
										(data.lostArticlePath, Charset.forName("UTF-8") ) );
			
			for(LostArticle article : Data.lostArticleList) {
				writer.write(article.getArticle() + ",");
				writer.write(article.getContent() + ",");
				writer.write(article.getLostStation() + ",");
				writer.write(article.getFindStation() + "\r\n");
				
			}
			
			writer.close();
			return;
			
		} catch (Exception e) {
			System.out.println("분실물 리스트 쓰기 실패");
			e.printStackTrace();
		}
		
	}//End of writeLostArticleList()

	private void writeUserVoiceList() {
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter
										(data.userVoicePath, Charset.forName("UTF-8") ) );
			
			for(UserVoice voice : Data.userVoiceList) {
				writer.write(voice.getId() + ",");
				writer.write(voice.getTitle() + ",");
				writer.write(voice.getContent() + ",");
				writer.write(voice.getIsRead() + "\r\n");
				
			}
			
			writer.close();
			return;
			
		} catch (Exception e) {
			System.out.println("민원 리스트 쓰기 실패");
			e.printStackTrace();
		}
		
		
	}//End of writeUserVoiceList()
	
	
	private void writeLogList() {
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter
										(data.logPath, Charset.forName("UTF-8") ) );
			
			for(Log log : Data.logList) {
				writer.write(log.getTime() + ",");
				writer.write(log.getId() );
					
					for(String action : log.getAction()) {
						writer.write("," + action);
					}
				writer.write("\r\n");
				
			}
			
			writer.close();
			return;
			
		} catch (Exception e) {
			System.out.println("로그 리스트 쓰기 실패");
			e.printStackTrace();
		}
	}//End of writeCalendarList()
	
	
	private void writeCalendarList() {
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter
										(data.calendarPath, Charset.forName("UTF-8") ) );
			
			for(Calendar calendar : Data.calendarList) {
				writer.write(calendar.getTime() + ",");
				writer.write(calendar.getLine() + ",");
				writer.write(calendar.getStation() + ",");
				writer.write(calendar.getSchedule() + "\r\n");
				
			}
			
			writer.close();
			return;
			
		} catch (Exception e) {
			System.out.println("정기권 코드 리스트 쓰기 실패");
			e.printStackTrace();
		}
	}//End of writeCalendarList()

	private void writePassList() {
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter
										(data.passPath, Charset.forName("UTF-8") ) );
		
			for(String pass : Data.passList) {
				writer.write(pass + "\r\n");
			
			}
		
			writer.close();
			return;
		
		} catch (Exception e) {
			System.out.println("정기권 코드 리스트 쓰기 실패");
			e.printStackTrace();
		}
	}//End of writePassList()

	private void writeEmployeeList() {
		try {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter
									(data.employeePath, Charset.forName("UTF-8") ) );
		
		for(Employee employee : Data.employeeList) {
			writer.write(employee.getName() + ",");
			writer.write(employee.getId() + ",");
			writer.write(employee.getPw() + ",");
			writer.write(employee.getRegistration() + ",");
			writer.write(employee.getPhone() + ",");
			writer.write(employee.getPosition() + ",");
			writer.write(employee.getLine() + ",");
			writer.write(employee.getStation() + ",");
			writer.write(employee.getLevel() + "\r\n");
			
		}
		
		writer.close();
		return;
		
		} catch (Exception e) {
			System.out.println("직원 리스트 쓰기 실패");
			e.printStackTrace();
		}
	}//End of writeEmployeeList()

	private void writeUserList() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter
										(data.userPath, Charset.forName("UTF-8") ) );
			
			for(User user : Data.userList) {
				writer.write(user.getName() + ",");
				writer.write(user.getId() + ",");
				writer.write(user.getPw() + ",");
				writer.write(user.getRegistration() + ",");
				writer.write(user.getPhone() + ",");
				writer.write(user.getPassCheck() + "\r\n");
				
			}
			
			writer.close();
			return;
			
		} catch (Exception e) {
			System.out.println("유저 리스트 쓰기 실패");
			e.printStackTrace();
		}
	}//End of writeUserList()
	
	
}//End of class
