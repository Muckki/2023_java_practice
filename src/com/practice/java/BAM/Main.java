package com.practice.java.BAM;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		int 마지막번호 = 0;

		List<게시글> 게시글들 = new ArrayList<>();
		while (true) {
			System.out.printf("명령어) ");
			String command = sc.nextLine();
			if (command.equals("게시글 리스트")) {
				if (마지막번호 == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.println("번호  /  제목");
					for (int i = 0; i < 게시글들.size(); i++) {
						게시글 a게시글 = 게시글들.get(i);
						System.out.println(" " + a게시글.번호 + "  /  " + a게시글.제목);
					}
					while (true) {
						System.out.println("몇번째 글을 확인하시겠습니까?");
						System.out.println("번호 : ex)게시글 1, 게시글 2... or 뒤로가기");
						System.out.printf("명령어 ) ");
						String nextString = sc.nextLine();
						if (nextString.equals("뒤로가기")) {
							break;
						} else if(nextString.startsWith("게시글")) {
							String[] 답변 = nextString.split(" ");
							boolean find = false;
							int number = Integer.parseInt(답변[1]);
							for( int i=0; i<게시글들.size(); i++) {
								게시글 b게시글 = 게시글들.get(i);
								if(b게시글.번호 == number) {
									find = true;
									break;
								}
							}
							if(find == true) {
								게시글 b게시글 = 게시글들.get(number - 1);
								System.out.println("작성 시간 : " + b게시글.nowd + " / " + b게시글.formatedNow);
								System.out.println("내용 : " + b게시글.내용);
								continue;
							}else {
								System.out.println(number + "번째 게시글은 존재하지 않습니다.");
								continue;
							}
						}else {
							System.out.println("잘못된 명령어 입니다.");
							continue;
						}
					}
				}
			} else if (command.equals("게시글 작성")) {
				int 번호 = 마지막번호 + 1;
				System.out.printf("제목 : ");
				String 제목 = sc.nextLine();
				System.out.printf("내용 : ");
				String 내용 = sc.nextLine();
				System.out.println(번호 + "번글이 생성되었습니다.");
				
				LocalDate nowd = LocalDate.now();
				LocalTime nowt = LocalTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		        String formatedNow = nowt.format(formatter);
				
				마지막번호 = 번호;
				
				게시글 a게시글 = new 게시글(번호, 제목, 내용, nowd, formatedNow);

				게시글들.add(a게시글);
				continue;
			}else if (command.equals("게시글 삭제")) {
				if(게시글들.size() != 0) {
					while(true) {
						System.out.println("몇번째 글을 삭제할까요?");
						System.out.printf("명령어 ) ");
						String nextString = sc.nextLine();
						if(nextString.equals("뒤로가기")) {
							break;
						}else if(숫자인지_판별하기(nextString)) {
							boolean find = false;
							int number = Integer.parseInt(nextString);
							for( int i=0; i<게시글들.size(); i++) {
								게시글 b게시글 = 게시글들.get(i);
								if(b게시글.번호 == number) {
									find = true;
									break;
								}
							}
							if(find == true) {
								System.out.println("정말 삭제할까요? ex) 1(예), 2(아니요)");
								System.out.println("명령어 ) ");
								String 삭제할거니 = sc.nextLine();
								if(삭제할거니.equals("1")) {
									System.out.println(nextString + "번째 글이 삭제되었습니다.");
									게시글들.remove(number-1);
									break;
								}else if(삭제할거니.equals("2")) {
									continue;
								}
							}else {
								System.out.println(number + "번째 게시글은 존재하지 않습니다.");
								continue;
							}
						}else if(!숫자인지_판별하기(nextString)) {
							System.out.println("숫자만 입력해주세요!");
							System.out.println("잘못된 명령어 입니다. ex) 숫자 or 뒤로가기");
						}
					}
				}else {
					System.out.println("게시글이 없습니다.");
				}
				
				
			}else if (command.equals("게시글 수정")) {
				if(게시글들.size() != 0) {
					while(true) {
						System.out.println("몇번째 글을 수정할까요?");
						System.out.printf("명령어 ) ");
						String nextString = sc.nextLine();
						if(nextString.equals("뒤로가기")) {
							break;
						}else if(숫자인지_판별하기(nextString)) {
							boolean find = false;
							int number = Integer.parseInt(nextString);
							게시글 수정게시글 = null;
							for( int i=0; i<게시글들.size(); i++) {
								게시글 b게시글 = 게시글들.get(i);
								if(b게시글.번호 == number) {
									find = true;
									수정게시글 = b게시글;
									break;
								}
							}
							if(find == true) {
								System.out.println("수정할 내용을 입력해주세요!");
								
								System.out.printf("제목 : ");
								String 제목 = sc.nextLine();
								System.out.printf("내용 : ");
								String 내용 = sc.nextLine();
								System.out.println(nextString + "번글이 수정되었습니다.");
								
								LocalDate nowd = LocalDate.now();
								LocalTime nowt = LocalTime.now();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
						        String formatedNow = nowt.format(formatter);
								
						        수정게시글.제목 = 제목;
						        수정게시글.내용 = 내용;
						        수정게시글.nowd = nowd;
						        수정게시글.formatedNow = formatedNow;
						        break;
							}else {
								System.out.println(number + "번째 게시글은 존재하지 않습니다.");
								continue;
							}
						}else if(!숫자인지_판별하기(nextString)) {
							System.out.println("숫자만 입력해주세요!");
							System.out.println("잘못된 명령어 입니다. ex) 숫자 or 뒤로가기");
						}
					}
				}else {
					System.out.println("게시글이 없습니다.");
				}
			}
			
			else if (command.equals("exit")) {
				break;
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		System.out.println("==프로그램 끝==");
		sc.close();
	}

	public static boolean 숫자인지_판별하기(String s) {
		try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}

class 게시글 {
	int 번호;
	String 제목;
	String 내용;
	LocalDate nowd;
	String formatedNow;
	public 게시글(int 번호, String 제목, String 내용, LocalDate nowd, String formatedNow) {
		this.번호 = 번호;
		this.제목 = 제목;
		this.내용 = 내용;
		this.nowd = nowd;
		this.formatedNow = formatedNow;
	}
}
