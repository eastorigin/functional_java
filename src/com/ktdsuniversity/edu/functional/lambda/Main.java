package com.ktdsuniversity.edu.functional.lambda;

import com.ktdsuniversity.edu.functional.anonymous.Printer;
import com.ktdsuniversity.edu.functional.anonymous.UI;

public class Main {

	public static void samsumgPrinter() {
		Printer samsung = new Printer();
		samsung.run((message) -> {System.out.println(message + "~~~~~~");});
		
		samsung.run(message -> System.out.println(message + "!"));
		// 람다 파라미터가 한 개일 때는 소괄호를 안 적어도 된다
		// println은 void를 반환시킨다 + public void print는 void를 반환시킨다
		// ==> 2개 모두 void를 반환시키므로 중괄호가 생략 가능하다
		// 즉 람다 바디와 람다가 구현한 메소드가 반환되는 것이 같아야 한다
		
	}
	
	public static void lgPrinter() {
		Printer lg = new Printer();
		lg.run(message -> {});
		System.out.println("============");
		lg.run(message -> System.out.println("test"));
	}
	
	public static void handleButton() {
		UI button = new UI();
		button.click(() -> System.out.println("딸깍!"));
		button.doubleClick(() -> System.out.println("딸깍! 딸깍!"));
		button.dragAndDrop(() -> System.out.println("버튼의 기능이 아님"));
		button.wheel(() -> System.out.println("버튼은 휠이 없음"));
	}
	
	public static void main(String[] args) {
		samsumgPrinter();
		lgPrinter();
		handleButton();
	}
}
