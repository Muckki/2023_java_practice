package com.practice.java.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==시작==");
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("문장 : ");
			String command = sc.nextLine();
			
			if (command.equals("exit")) {
				break;
			}
		}
		System.out.println("==끝==");
		sc.close();
	}
}
