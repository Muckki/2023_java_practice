package com.practice.java.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==����==");
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("���� : ");
			String command = sc.nextLine();
			
			if (command.equals("exit")) {
				break;
			}
		}
		System.out.println("==��==");
		sc.close();
	}
}
