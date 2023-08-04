package com.practice.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Article {
	int index;
	String name;
	String aa;
	
	public Article(int index , String name , String aa) {
		this.index = index;
		this.name = name;
		this.aa = aa;
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		Scanner sc = new Scanner(System.in);
		int index = 0;
		
		List<Article> articles = new ArrayList<>();
		
		while (true){
			System.out.printf("명령어) ");
			String command = sc.nextLine().trim();
			
			if(command.length() == 0) {
				System.out.println("명령어를 입력하세요");
				continue;
			}
			
			if(command.equals("exit")) {
				break;
			}else if(command.equals("article list")) {
				if(articles.size() == 0 ) {
					System.out.println("게시글이 없습니다");
					continue;
				}else {
					for (int i = 0; i<articles.size(); i++) {
						Article article = articles.get(i);
						System.out.println(article.index + "번째 글");
						System.out.println("제목 : " + article.name);
						System.out.println("내용 : " + article.aa);
						continue;
					}
				}
			}else if(command.equals("article write")) {
				index++;
				System.out.println("제목을 입력하세요)");
				String name = sc.nextLine();
				System.out.println("내용을 입력하세요)");
				String aa = sc.nextLine();
				System.out.printf("제목 : %s%n", name);
				System.out.printf("내용 : %s%n", aa);
				System.out.printf("%d번글이 생성되었습니다.%n", index);
				
				Article article = new Article(index, name, aa);
				
				articles.add(article);
				
				continue;
			}else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
		}
		
		
		System.out.println("==프로그램 종료==");
		sc.close();
	}
}
