package com.ktdsuniversity.edu.functional.stream.flatmapping;

import java.util.Arrays;
import java.util.List;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {

	public static void flatMapTest() {
		
		// 메뉴 이름을 글자로 모두 분리해서 하나씩 출력
		// 플랫맵은 파일과 파일을 비교할 때 주로 사용
		// 파일을 스트링 => 분석 중에 다른 파일을 스트림으로 변경 => 본 스트림으로 치환하는 과정
		
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		// 배열을 스트림에서 직접 제어
		menuList.stream()
				.map(dish -> dish.getName()) // Dish -> String 변경
				.map(dishName -> dishName.split("")) // String -> String[] 변경
				.forEach(letterArray -> {
					Arrays.asList(letterArray) // String[]을 List<String>으로 변경
						  .forEach(letter -> System.out.println(letter)); // List를 반복
				});
		
		// 배열을 스트림으로 치환해서 간단 사용
		// 배열을 스트림으로 만드는 방법
		// Arrays.stream(배열) ==> Stream<T>
		menuList.stream()
				.map(dish -> dish.getName()) // Dish -> String 변경
				.map(dishName -> dishName.split("")) // String -> String[] 변경
				// .map(dishNameArray -> Arrays.stream(dishNameArray)) // String[] -> Stream<Stream<String>>
				.flatMap(dishNameArray -> Arrays.stream(dishNameArray)) /// String[] -> Stream<String> (Stream<String> 자체가 배열을 스트림으로 치환한 결과)
				.distinct()
				.forEach(letter -> System.out.println("> " + letter));
	}
	
	public static void main(String[] args) {
		flatMapTest();
	}
}
