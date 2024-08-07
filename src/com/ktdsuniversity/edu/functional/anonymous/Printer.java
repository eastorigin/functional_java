package com.ktdsuniversity.edu.functional.anonymous;

public class Printer {

	public void run (Printable printable) {
		printable.print();
		printable.print("반갑습니다. 익명클래스");
	}
}
