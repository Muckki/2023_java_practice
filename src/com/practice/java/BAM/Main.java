package com.practice.java.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CorrectAnswer {
	String answer;
	String answer1;
	String answer2;
	
	public CorrectAnswer(String answer, String answer1, String answer2) {
		this.answer = answer;
		this.answer1 = answer1;
		this.answer2 = answer2;		
	}
}
public class Main {
	public static void main(String[] args) {
//		계모 콩쥐 팥쥐 세 인물의 정보 저장하고 비교하는 CRUD 연습 #나홀로안보고
		Scanner sc = new Scanner(System.in);
		while(true) {
			String controller = "a";
			System.out.printf("==콩쥐팥쥐 인물맞추기!==%n콩쥐팥쥐 등장인물 중 엄마는?%n정답 : ");
			String answer = sc.nextLine();
			System.out.printf("언니의 이름은?%n정답 : ");
			String answer1 = sc.nextLine();
			System.out.printf("동생의 이름은?%n정답 : ");
			String answer2 = sc.nextLine();
			
			List<CorrectAnswer> answers = new ArrayList<>();
			
			CorrectAnswer usersAnswers = new CorrectAnswer(answer, answer1, answer2);
			answers.add(usersAnswers);
			CorrectAnswer correct = answers.get(0);
			
			int wrongIndex = 0;
			if(!correct.answer.equals("계모") || !correct.answer1.equals("팥쥐") || !correct.answer2.equals("콩쥐")) {
				if(!correct.answer.equals("계모")) {
					System.out.printf("입력한 %s는 오답 ! 정답은 : 계모%n", answer);
					wrongIndex++;					
				}
				if(!correct.answer1.equals("팥쥐")) {
					System.out.printf("입력한 %s는 오답 ! 정답은 : 팥쥐%n", answer1);
					wrongIndex++;
				}
				if(!correct.answer2.equals("콩쥐")) {
					System.out.printf("입력한 %s는 오답 ! 정답은 : 콩쥐%n", answer2);
					wrongIndex++;
				}
				System.out.printf("오답 수 : %d%n", wrongIndex);	
			}else {
				while(true) {
					System.out.println("축하합니다 백점이에요!");
					System.out.printf("다시 풀어볼까요? 예(y),아니요(n)%n명령어 ) ");
					String command = sc.nextLine().trim();
					if(command.equals("y")) {
						break;
					}else if(command.equals("n")){
						System.out.println("==종료==");
						controller = "end";
						break;
					}else {
						System.out.printf("정확한 값을 입력해주세요!%n%n");
					}
				}
				if (controller.equals("end")) {
					break;
				}
			}
			
			if(wrongIndex != 0) {
				while(true) {
					System.out.printf("다시 풀어볼까요? ㅠㅠ 예(y),아니요(n)%n명령어 )");
					String command = sc.nextLine().trim();
					if(command.equals("y")) {
						break;
					}else if(command.equals("n")){
						System.out.println("==종료==");
						controller = "end";
						break;
					}else {
						System.out.printf("정확한 값을 입력해주세요!%n%n");
					}
				}
				if(controller.equals("end")) {
					break;
				}
			}
		}
	}
}
