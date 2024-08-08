package com.ktdsuniversity.edu.functional.stream.mapping;

import java.util.List;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {

	public static void printMenuNameWithCalory() {
		// 모든 메뉴의 이름과 칼로리를 출력하자
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		// 1. forEach로만 출력
		menuList.forEach(dish -> System.out.println(dish.getName() + " " + dish.getCalories()));
		
		// 2. mapping으로 출력
		// 2-1. 메뉴리스트를 스트림으로 변경
		menuList.stream()
		// 2-2. 메뉴리스트의 제네릭을 디쉬에서 스트링으로 변경 (메뉴명 + 칼로리)
				// map 함수는 스트림의 데이터를 변경시키는 함수다
				// 변경되는 결과에 따라서 스트림의 제네릭이 변경될 수 있다
				.map(dish -> dish.getName() + " --> " + dish.getCalories())
		// 2-3. 스트링 스트림을 출력
				.forEach(str -> System.out.println(str));
	}
	
	public static void printFirstAndSecondLetter() {
		// map 함수를 이용해서 모든 요리의 두 번째 글자까지만 출력
		// stream(), map(), forEach();
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		menuList.stream()
				.map(dish -> dish.getName().substring(0, 2))
				.forEach(str -> System.out.println(str));
	}
	
	public static void printMenuList() {
		// 모든 메뉴 목록을 아래와 같은 형태로 출력
		// 육류메뉴: pork, 칼로리: 800
		// 육류메뉴: beef, 칼로리: 700
		// ...
		// 기타메뉴: french fries, 칼로리: 530
		// ...
		// 어류메뉴: salmon, 칼로리: 450
		
		// stream, map, forEach
		
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		menuList.stream()
//				.map(dish ->  {
//					if(dish.getType() == Dish.Type.MEAT) {
//						return "육류메뉴: " + dish.getName() + ", 칼로리: " + dish.getCalories();
//					}else if(dish.getType() == Dish.Type.FISH) {
//						return "생선메뉴: " + dish.getName() + ", 칼로리: " + dish.getCalories();
//					}else {
//						return "기타메뉴: " + dish.getName() + ", 칼로리: " + dish.getCalories();
//					}
//				})
				.map(dish -> {
					String menuType = "";
					if(dish.getType() == Dish.Type.MEAT) {
						menuType = "육류메뉴";
					}else if(dish.getType() == Dish.Type.OTHER) {
						menuType = "기타메뉴";
					}else if(dish.getType() == Dish.Type.FISH) {
						menuType = "어류메뉴";
					}
					return menuType + ": " + dish.getName() + ", 칼로리: " + dish.getCalories();
				})
				.forEach(str -> System.out.println(str));
	}
	
	public static void main(String[] args) {
		printMenuNameWithCalory();
		printFirstAndSecondLetter();
		printMenuList();
	}
}
