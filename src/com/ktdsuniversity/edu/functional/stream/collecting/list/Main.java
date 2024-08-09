package com.ktdsuniversity.edu.functional.stream.collecting.list;

import java.util.List;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {
	
	// 도전과제
	// 4. 전체 메뉴 중에서 칼로리가 높은 순서대로 정렬한 이후에 상위 5개만 별도의 리스트로 할당
	// 리스트를 출력
	
	public static void topFiveCaloryFood() {
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		List<Dish> topFiveCaloryFood = menuList.stream()
											   .sorted((firstDish, secondDish) -> secondDish.getCalories() - firstDish.getCalories())
											   .limit(5)
											   .toList();
		topFiveCaloryFood.forEach(dish -> System.out.println(dish));
	}
	
	// 5. 메뉴의 이름이 띄어쓰기 없이 5글자 이상인 메뉴들 중 칼로리가 낮은 순서대로 상위 3개만 별도의 리스트로 할당
	// 그 리스트를 출력
	
	public static void printFiveLetterMenu() {
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		List<Dish> moreThanFiveLetterMenu = menuList.stream()
													.filter(dish -> !dish.getName().contains(" "))
													.filter(dish -> dish.getName().length() >= 5)
													.sorted((firstDish, secondDish) -> firstDish.getCalories() - secondDish.getCalories())
													.limit(3)
													.toList();
		moreThanFiveLetterMenu.forEach(dish -> System.out.println(dish));
	}

	public static void streamToList() {
		// 전체 메뉴에서 육식메뉴이거나 칼로리가 400미만인 요리만 추출해서 리스트로 저장
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		List<Dish> specialFood = menuList.stream() // Stream<Dish>
										 .filter(dish -> dish.getType() == Dish.Type.MEAT || dish.getCalories() < 400) // Stream<Dish>
										 // .collect(Collectors.toList()); // List<Dish>, Since ver. Java 1.8
										 .toList(); // List<Dish> Since ver. Java 16
		specialFood.forEach(dish -> System.out.println(dish));
	}
	
	public static void main(String[] args) {
		System.out.println("====도전과제 4====");
		topFiveCaloryFood();
		System.out.println("=====도전과제 5=====");
		printFiveLetterMenu();
		System.out.println("=".repeat(44));
		streamToList();
	}
}
