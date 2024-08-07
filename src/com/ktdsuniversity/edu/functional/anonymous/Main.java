package com.ktdsuniversity.edu.functional.anonymous;

public class Main {

	public static void anonymousParameter() {
		// 응용 프로그램 개발 패턴
		// Windows Application
		// Linux Application
		// IOS Application
		// iPadOS Application
		// Android Application
		// Web Application (Javascript)
		
		// Event에 대응하기 위해서 익명 파라미터를 사용
		//		Callback
		
		// 파라미터로 익명클래스 인스턴스를 직접 전달
		Printer printer = new Printer();
		printer.run(new Printable() {
			
			@Override
			public void print(String message) {
				System.out.println("LG Printer: " + message);
			}
		});
	}
	
	public static void anonymousInstance() {
		// 익명클래스의 인스턴스 생성
		// 인스턴스를 파라미터로 전달 -> Printer
		
		Printable saumsungPrinter = new Printable() {
			
			@Override
			public void print(String message) {
				// 함수형 인터페이스가 될 수 있는 조건은 하얀색 삼각형이 한 개만 있어야 한다
				System.out.println("삼성 프린터가 " + message + "를 출력합니다");
			}
		};
		
		Printer printer = new Printer();
		printer.run(saumsungPrinter);
	}
	
	public static void handleButton() {
		UI button = new UI();
		
		// 버튼을 클릭한다
		// ClickEventListener() {} : 익명클래스
		button.click(new ClickEventListener() {
			@Override
			public void click() {
				System.out.println("딸각!");
			}
		});
		
		// 버튼을 더블클릭하나
		button.doubleClick(new DoubleClickEventListener () {
			@Override
			public void doubleClick() {
				System.out.println("딸깍! 딸깍!");
			}
		});
		
		// 버튼을 드래그 드랍한다
		button.dragAndDrop(new DragAndDropEventListener () {
			@Override
			public void dragAndDrop() {
				System.out.println("버튼은 드래그 드랍할 수 없습니다");
			}
		});
		
		// 버튼에서 마우스 휠을 돌린다
		button.wheel(new WheelEventListener() {
			@Override
			public void wheel() {
				System.out.println("");
			}
		});
	}
	
	public static void main(String[] args) {
		anonymousParameter();
		anonymousInstance();
	}
}
