package com.ktdsuniversity.edu.functional.anonymous;

@FunctionalInterface // 함수형 인터페이스인지 아닌지 검증하는 문구
public interface Printable { // 메소드가 2개라 안 됨

	public default void print() {
		// default를 삽입하면 추상메소드가 아니라 구현메소드가 되서 결국 추상메소드가 하나가 됨
		// 그래서 함수형 인터페이스가 가능함
		System.out.println("출력합니다~~");
	}
	
	public void print(String message);
}
