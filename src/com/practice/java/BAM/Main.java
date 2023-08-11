package com.practice.java.BAM;

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
						System.out.println("번호 : ex)1 or 2 or 뒤로가기");
						String nextString = sc.nextLine();
						if (nextString.equals("뒤로가기")) {
							break;
						} else {
							int number = Integer.parseInt(nextString);
							게시글 b게시글 = 게시글들.get(number - 1);
							System.out.println("내용 : " + b게시글.내용);
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
				마지막번호 = 번호;
				게시글 a게시글 = new 게시글(번호, 제목, 내용);

				게시글들.add(a게시글);
				continue;
			} else if (command.equals("exit")) {
				break;
			} else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		System.out.println("==프로그램 끝==");
		sc.close();
	}
}

class 게시글 {
	int 번호;
	String 제목;
	String 내용;

	public 게시글(int 번호, String 제목, String 내용) {
		this.번호 = 번호;
		this.제목 = 제목;
		this.내용 = 내용;
	}
}