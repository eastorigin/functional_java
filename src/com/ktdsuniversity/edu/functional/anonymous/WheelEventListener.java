package com.ktdsuniversity.edu.functional.anonymous;

// 추상 메소드가 하나만 있는 인터페이스는 무조건 람다로 변경 가능
// @FunctionalInterface의 목적은 람다로 변경 가능함을 명시적으로 알려주는 기능만 함
@FunctionalInterface
public interface WheelEventListener {

	public void wheel();

}
