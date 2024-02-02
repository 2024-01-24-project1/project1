package com.java.common;

import java.util.ArrayList;
//import com.java.calendar.Calendar;
//import com.java.common.log.Log;
//import com.java.common.lostarticle.LostArticle;
//import com.java.member.employee.Employee;
//import com.java.member.user.User;
//import com.java.member.user.UserVoice;
//import com.java.station.PassengerCounting;
//import com.java.station.timetable.StationTime;
//import java.util.Calendar;
//import java.util.Calendar;

import com.java.busy.Busy;
import com.java.common.log.Log;
import com.java.member.employee.EmployeeManagement;
import com.java.station.PassengerCounting;
import com.java.station.timetable.StationTime;

// 모든 경로, csv파일, 정적데이터 클래스
public final class Data {
	
	// 경로
	protected final String PASSPATH = ".\\src\\data\\pass.csv";				  //정기권
	protected final String USERPATH = ".\\src\\data\\user.csv";				  //고객정보
	protected final String EMPLOYEEPATH = ".\\src\\data\\employee.csv";		  //직원정보
	protected final String CALENDARPATH = ".\\src\\data\\calendar.csv";		  //일정
	protected final String LOGPATH = ".\\src\\data\\log.csv";				  //로그
	protected final String LOSTARTICLEPATH = ".\\src\\data\\lostarticle.csv"; //분실물
	protected final String STATIONTIMEPATH = ".\\src\\data\\stationtime.csv"; //역별 시간표
	protected final String BUSYPATH = ".\\src\\data\\busy.csv";				  //혼잡도
	protected final String USERVOICEPATH = ".\\src\\data\\uservoice.csv";	  //민원
	protected final String STATIONNAMEPATH = ".\\src\\data\\stationname.csv"; //역이름
	protected final String REQUIREDTIMEPATH = ".\\data\\requiredTime.csv";    //역간 소요시간
	
	protected final String ALL_LINE_NAME_PATH = ".\\data\\호선별역이름\\모든역이름.csv";
	protected static String line_NamePath = ".\\data\\호선별역이름\\";
	protected static String passengerCountPath = ".\\data\\월간_역별_승하차_인원_정보\\";
	
	protected static String station_TimeTablePath = ".\\data\\지하철호선별_역시간표\\";
	
	//End of 경로
	
	//cvs파일을 읽어만 오고 쓰지는 않는 리스트
	public static ArrayList<StationTime> stationTimeList = new ArrayList<>();
	public static ArrayList<PassengerCounting> passengerCountingList = new ArrayList<>();
	
	// csv파일을 읽어와서 변경되지 않는 역 리스트
	public static final ArrayList<String> ALL_STATION_NAME = new ArrayList<>();
	public static final ArrayList<String> LINE1_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE2_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE3_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE4_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE5_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE6_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE7_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE8_STATION_NAME = new ArrayList<String>();
	public static final ArrayList<String> LINE9_STATION_NAME = new ArrayList<String>();
	
	//역간 걸리는 시간 저장하는 리스트
	public static final ArrayList<RequiredTime> requiredTimeList = new ArrayList<>();
	
	// csv파일 읽어와서 변경되면 종료시 csv파일에 쓰는 리스트
	public static ArrayList<String> passList = new ArrayList<>();
//	public static ArrayList<User> userList = new ArrayList<>();
	public static ArrayList<EmployeeManagement> employeeList = new ArrayList<>();
//	public static ArrayList<Calendar> calendarList = new ArrayList<>();
	public static ArrayList<Log> logList = new ArrayList<>();
//	public static ArrayList<UserVoice> userVoiceList = new ArrayList<>();
//	public static ArrayList<LostArticle> lostArticleList = new ArrayList<>();
	
	//혼잡도 저장하는 리스트
	public static ArrayList<Busy> busyList = new ArrayList<>();
	
	//검색어 저장하는 리스트
	public static ArrayList<EmployeeManagement> searchList = new ArrayList<>();
	

	
	
	// 직원 가입 코드
	public final static String EMPLOYEECODE = "DAVSGDVASDASDFR35351";	// 예시
	
	
}//End of class