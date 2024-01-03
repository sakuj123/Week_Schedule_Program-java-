package javaProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class javaProject1109 {
	private static final String FILE_PATH = "Schedule.txt";
	
	public static void main(String[] args) {
		List<String> sun = new ArrayList<>();
		List<String> mon = new ArrayList<>();
		List<String> tue = new ArrayList<>();
		List<String> wed = new ArrayList<>();
		List<String> tur = new ArrayList<>();
		List<String> fri = new ArrayList<>();
		List<String> sat = new ArrayList<>();
		
		//파일 리스트 읽기
		readListsFromFile(sun, mon, tue, wed, tur, fri, sat);
		
		Scanner sc = new Scanner(System.in);
		char c;
		
		do {
			//메뉴
			System.out.println("==========한 주 일정 스케줄=========");
			System.out.println("a. 일정 추가하기");
			System.out.println("b. 모든 일정 출력하기");
			System.out.println("c. 모든 일정 삭제하기");
			System.out.println("d. 특정 요일 일정 모두 삭제하기");
			System.out.println("e. 특정 요일 일정 삭제하기");
			System.out.println("s. 데이터 저장하기");
			System.out.println("q. 프로그램 종료하기");
			System.out.print("선택 : ");
			c = sc.next().charAt(0);
			sc.nextLine();
			
			switch(c) {
				case 'a':
					//일정 추가 - 요일
					System.out.print("{무슨 요일에 일정을 추가하실건가요?(ex: 월,mon,Mon) : ");
					int i=0;
					String selected = "";
					// 요일 확인
					while(i!=1) {
						selected = sc.nextLine().toLowerCase();
						switch(selected) {
						case "일", "sun":
							i=1;
							break;
						case "월", "mon":
							i=1;
							break;
						case "화", "tue":
							i=1;
							break;
						case "수", "wed":
							i=1;
							break;
						case "목", "tur":
							i=1;
							break;
						case "금", "fri":
							i=1;
							break;
						case "토", "sat":
							i=1;
							break;
							
						default :
							System.out.println("--<잘못 입력하셨습니다>--");
							System.out.print("{다시 입력하세요(ex: 월,mon,Mon) :");
							break;
						}
					}
					//일정 추가 - 일정
					System.out.println("{일정을 입력하고 다 입력하셨으면 end/끝을 입력해주세요.");
					String value = "";
					int j=0;
					// 일정 확인
					while(j!=1) {
						value = sc.nextLine();
						String value_check = value.toLowerCase();
						switch(value_check) {
						case "끝", "긑", "둥", "end", "rmx":
							j=1;
							break;
						
						default:
							addToList(selected, value, sun, mon, tue, wed, tur, fri, sat);
							break;
						}
					}
					break;
				case 'b':
					//모든 일정 출력
					System.out.println("\n********************************");
					printAllLists(sun, mon, tue, wed, tur, fri, sat);
					System.out.println("********************************\n");
					break;
				case 'c':
					//모든 일정 삭제
					clearAllLists(sun, mon, tue, wed, tur, fri, sat);
					System.out.println("--<모든 일정을 삭제했습니다>--\n");
					break;
				case 'd':
					//특정 요일 모든 일정 삭제
					System.out.print("{무슨 요일의 일정을 모두 삭제할까요?(ex: 월,mon,Mon) : ");
					int n=0;
					String selectedDay = "";
					// 요일 확인
					while(n!=1) {
						selectedDay = sc.nextLine().toLowerCase();
						switch(selectedDay) {
						case "일", "sun":
							n=1;
							break;
						case "월", "mon":
							n=1;
							break;
						case "화", "tue":
							n=1;
							break;
						case "수", "wed":
							n=1;
							break;
						case "목", "tur":
							n=1;
							break;
						case "금", "fri":
							n=1;
							break;
						case "토", "sat":
							n=1;
							break;
							
						default :
							System.out.println("--<잘못 입력하셨습니다>--");
							System.out.print("{다시 입력하세요(ex: 월,mon,Mon) :");
							break;
						}
					}
					clearLists(selectedDay, sun, mon, tue, wed, tur, fri, sat);
					switch(selectedDay) {
					case "일", "sun":
						selectedDay="일요일";
						break;
					case "월", "mon":
						selectedDay="월요일";
						break;
					case "화", "tue":
						selectedDay="화요일";
						break;
					case "수", "wed":
						selectedDay="수요일";
						break;
					case "목", "tur":
						selectedDay="목요일";
						break;
					case "금", "fri":
						selectedDay="금요일";
						break;
					case "토", "sat":
						selectedDay="토요일";
						break;
					}
					System.out.println("--<" + selectedDay +" 모든 일정을 삭제했습니다>--");
					break;
				case 'e':
					//특정 요일 일정 삭제(in_num)
					System.out.print("{무슨 요일의 일정을 삭제할건가요?(ex: 월,mon,Mon) : ");
					int m=0;
					String selectedDay2 = ""; //요일
					int indexToDelete = -1; //제어 변수 index
					List<String> lists = null; //요일 리스트
					// 요일 확인
					while(m!=1) {
						selectedDay2 = sc.nextLine().toLowerCase();
						switch(selectedDay2) {
						case "일", "sun":
							m=1;
							break;
						case "월", "mon":
							m=1;
							break;
						case "화", "tue":
							m=1;
							break;
						case "수", "wed":
							m=1;
							break;
						case "목", "tur":
							m=1;
							break;
						case "금", "fri":
							m=1;
							break;
						case "토", "sat":
							m=1;
							break;
							
						default :
							System.out.println("--<잘못 입력하셨습니다>--");
							System.out.print("{다시 입력하세요(ex: 월,mon,Mon) :");
							break;
						}
						System.out.print("삭제할 일정의 인덱스 값을 입력해주세요(0부터 시작) : ");
						do{
							try {
								indexToDelete = sc.nextInt();
							} catch(InputMismatchException e) {
								System.out.println("--<잘못된 자료형입니다>--");
								System.out.print("{int형으로 입력해주세요 : ");
								sc.nextLine();
							}
						}while(indexToDelete == -1);
						
						switch(selectedDay2) {
							case "일", "sun":
								lists = sun;
								break;
							case "월", "mon":
								lists = mon;
								break;
							case "화", "tue":
								lists = tue;
								break;
							case "수", "wed":
								lists = wed;
								break;
							case "목", "tur":
								lists = tur;
								break;
							case "금", "fri":
								lists = fri;
								break;
							case "토", "sat":
								lists = sat;
								break;
							}
						delValueAtIndex(selectedDay2, lists, indexToDelete);
					}
					break;
					
				case 's':
					writeListsToFile(sun, mon, tue, wed, tur, fri, sat);
					break;
					
				case 'q':
					System.out.println("--<프로그램을 종료합니다>--");
					break;
					
				default:
					System.out.println("--<잘못 입력하셨습니다.>--\n");
					break;
			}
		}while (c != 'q');

		// 프로그램 종료 전에 파일에 목록 저장
		writeListsToFile(sun, mon, tue, wed, tur, fri, sat);
		
	} //main
	
	//파일에서 리스트 읽기
	private static void readListsFromFile(List<String> sun, List<String> mon, List<String> tue, List<String> wed, List<String> tur, List<String> fri, List<String> sat){
		try {
			List<String> lines = Files.readAllLines(Paths.get(FILE_PATH)); //lines안에 메모장 데이터가 들어가있음.
			if(!lines.isEmpty()) {
				sun.addAll(List.of(lines.get(0).split(","))); //메모장 0번째 줄에 ,을 기준으로 데이터를 잘라서 list에 넣음.
				mon.addAll(List.of(lines.get(1).split(",")));
				tue.addAll(List.of(lines.get(2).split(",")));
				wed.addAll(List.of(lines.get(3).split(",")));
				tur.addAll(List.of(lines.get(4).split(",")));
				fri.addAll(List.of(lines.get(5).split(",")));
				sat.addAll(List.of(lines.get(6).split(",")));
				}
			} catch (IOException e) {
				
			}
		}
	
	//일정 추가
	private static void addToList(String selected, String value, List<String> sun, List<String> mon, List<String> tue, List<String> wed, List<String> tur, List<String> fri, List<String> sat) {
		switch(selected) {
			case "일", "sun":
				sun.add(value);
				break;
			case "월", "mon":
				mon.add(value);
				break;
			case "화", "tue":
				tue.add(value);
				break;
			case "수", "wed":
				wed.add(value);
				break;
			case "목", "tur":
				tur.add(value);
				break;
			case "금", "fri":
				fri.add(value);
				break;
			case "토", "sat":
				sat.add(value);
				break;
		}
	}
	
	//모든 일정 출력
	private static void printAllLists(List<String> sun, List<String> mon, List<String> tue, List<String> wed, List<String> tur, List<String> fri, List<String> sat) {
			System.out.println("일요일 : " + sun);
			System.out.println("월요일 : " + mon);
			System.out.println("화요일 : " + tue);
			System.out.println("수요일 : " + wed);
			System.out.println("목요일 : " + tur);
			System.out.println("금요일 : " + fri);
			System.out.println("토요일 : " + sat);
		}
	
	//모든 일정 삭제
	private static void clearAllLists(List<String> sun, List<String> mon, List<String> tue, List<String> wed, List<String> tur, List<String> fri, List<String> sat) {
		sun.clear();
		mon.clear();
		tue.clear();
		wed.clear();
		tur.clear();
		fri.clear();
		sat.clear();
	}
	
	//특정 요일 모든 일정 삭제
	private static void clearLists(String selectedDay, List<String> sun, List<String> mon, List<String> tue, List<String> wed, List<String> tur, List<String> fri, List<String> sat) {
		switch(selectedDay) {
			case "일", "sun":
				sun.clear();
				break;
			case "월", "mon":
				mon.clear();
				break;
			case "화", "tue":
				tue.clear();
				break;
			case "수", "wed":
				wed.clear();
				break;
			case "목", "tur":
				tur.clear();
				break;
			case "금", "fri":
				fri.clear();
				break;
			case "토", "sat":
				sat.clear();
				break;
		}
	}
	
	//특정 요일 일정 삭제
	private static void delValueAtIndex(String selectedDay2, List<String> lists, int indexToDelete){
		if(indexToDelete>=0 && indexToDelete < lists.size()) {
			lists.remove(indexToDelete);
			switch(selectedDay2) {
			case "일", "sun":
				selectedDay2="일요일";
				break;
			case "월", "mon":
				selectedDay2="월요일";
				break;
			case "화", "tue":
				selectedDay2="화요일";
				break;
			case "수", "wed":
				selectedDay2="수요일";
				break;
			case "목", "tur":
				selectedDay2="목요일";
				break;
			case "금", "fri":
				selectedDay2="금요일";
				break;
			case "토", "sat":
				selectedDay2="토요일";
				break;
			}
			System.out.println("--<" + selectedDay2 + " "+ indexToDelete + "번째 일정을 삭제했습니다>--");
		} else {
			System.out.println("유요하지 않은 인데스번호입니다.");
		}
	}
	
	//일정 데이터 파일에 저장
	private static void writeListsToFile(List<String> sun, List<String> mon, List<String> tue, List<String> wed, List<String> tur, List<String> fri, List<String> sat) {
		try {
			List<String> lines = new ArrayList<>();
			lines.add(String .join(",", sun));
			lines.add(String .join(",", mon));
			lines.add(String .join(",", tue));
			lines.add(String .join(",", wed));
			lines.add(String .join(",", tur));
			lines.add(String .join(",", fri));
			lines.add(String .join(",", sat));
			Files.write(Paths.get(FILE_PATH), lines, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			System.out.println("<데이터가 파일에 저장되었습니다>");
			System.out.println("<프로그램을 종료합니다>");
			System.out.println("{규칙적인 삶을 위해서 열심히 일정을 만들어요! 다음에 봐요!}");
		} catch(IOException e) {
			System.out.println("<데이터가 파일에 저장되지 않았습니다>");
			System.out.println("<프로그램을 중료합니다>");
			System.out.println("{규칙적인 삶을 위해서 열심히 일정을 만들어요! 다음에 봐요!}");
			e.printStackTrace();
		}
	}
	
}

