package com.practice.java.BAM;

class Main {
	public static void main(String[] args) {
		int i = 로봇.get정수();
		boolean b = 로봇.get논리();
		사람 a사람 = 로봇.get사람();
		사람 a사람2 = 로봇.get사람2();
		사람 a사람3 = 로봇.get사람3();
		사람 a사람4 = 로봇.get사람4();
		사람 a사람5 = 로봇.get사람5(123, false);
		로봇.get사람6(123, false);
	}
}

class 로봇 {
	static int get정수() {
		return 3;
	}
	static boolean get논리() {
		return false;
	}
	static 사람 get사람() {
		사람 a사람 = new 사람();
		return a사람;
	}
	static 사람 get사람2() {
		사람 a사람2 = new 사람();
		return a사람2;
	}
	static 사람 get사람3() {
		사람 a사람3 = new 사람();
		return a사람3;
	}
	static 사람 get사람4() {
		사람 a사람4 = new 사람();
		return a사람4;
	}
	static 사람 get사람5(int a, boolean b) {
		return null;
	}
	static 로봇 get사람6(int a, boolean b) {
		return null;
	}
	
}
class 사람 {
	
}