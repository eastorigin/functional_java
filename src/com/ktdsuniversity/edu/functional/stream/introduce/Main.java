package com.ktdsuniversity.edu.functional.stream.introduce;

import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void printLowCaloricDishes() {
		// 400칼로리 미만의 음식만 걸러와서 메뉴의 이름을 출력
		DishList dishList = new DishList();
		
		// 1. 모든 메뉴 목록을 가져옴
		List<Dish> menuList = dishList.getDishList();
		
		// 2. 메뉴 목록을 스트림으로 변경
		Stream<Dish> dishStream = menuList.stream();
		
		// 3. 메뉴 스트림에서 칼로리가 400 미만인 메뉴만 가지고 있는 스트림을 생성
		// 반환값이 true면 모든 메뉴가 스트림으로 옮겨진다
		// dishStream과 allDishes는 다른 스트림 (메모리 주소가 다르다)
		// Stream<Dish> allDishes = dishStream.filter(dish -> true);
		// 반환값이 false면 결과는 비어있다
		// Stream<Dish> emptyDishes = dishStream.filter(dish -> false);
		Stream<Dish> lowCaloricDishes = dishStream.filter(dish -> dish.getCalories() < 400);
		// 예상 결과 : rice, season fruit, prawns
		
		// 중간함수는 최종함수가 실행되기 전까지는 절대 동작하지 않음. Stream을 반환시키면 중간함수
		// System.out.println(lowCaloricDishes);
		
		// 스트림에 무엇이 들었는지 확인해보자
		// Stream<Dish> peekedStream = lowCaloricDishes.peek( dish -> System.out.println("중간점검: " + dish.getName()));
		
		// 4. lowCaloricDishes를 Stream<String>으로 변경한다
		Stream<String> dishNameStream = lowCaloricDishes.map(dish -> dish.getName());
		
		// 5. 최종 함수를 실행한다 (forEach는 최종함수). Stream이 아닌 것을 반환시키면 최종함수
		dishNameStream.forEach(dishName -> System.out.println(dishName));
	}
	
	public static void printLowCaloricDishesSimpleVersion() {
		// 400칼로리 미만의 음식만 걸러와서 메뉴의 이름을 출력
		
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		menuList.stream().filter(dish -> dish.getCalories() < 400).map(dish -> dish.getName()).forEach(dishName -> System.out.println(dishName));
		// 아이템 하나 가져와서 필터하고 맵하고 출력하고를 계속 반복 => 그래서 stream이 내부반복자
	}
	
	public static void main(String[] args) {
		printLowCaloricDishes();
		
		printLowCaloricDishesSimpleVersion();
	}
}
