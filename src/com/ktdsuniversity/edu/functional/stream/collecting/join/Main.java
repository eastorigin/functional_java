package com.ktdsuniversity.edu.functional.stream.collecting.join;

import java.util.List;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {
	
	// 도전과제!
	// 3 채식메뉴를 아래와 같은 포멧으로 연결
	/*
	 * 이름:칼로리:타입, 이름:칼로리:타입, 이름:칼로리:타입, 이름:칼로리:타입, 이름:칼로리:타입, ...
	 */
	
	public static void printVegetarianFood(String separator) {
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		String vegetarianFood = menuList.stream()
										.filter(dish -> dish.isVegetarian())
										.map(dish -> dish.getName() + ":" + dish.getCalories() + ":" + dish.getType())
										.collect(Collectors.joining(separator));
		System.out.println(vegetarianFood);
	}

	public static void printJoinAllMenuName(String separator) {
		
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		// 모든 메뉴의 이름을 연결해서 출력한다
		String menuName = menuList.stream() // Stream<Dish>
								  .map(dish -> dish.getName()) // Stream<String>
								  .collect(Collectors.joining(separator)); // String
		System.out.println(menuName);
	}
	
	public static void main(String[] args) {
		printJoinAllMenuName("");
		printJoinAllMenuName("-");
		printJoinAllMenuName(" , ");
		printVegetarianFood(", ");
	}
}
