package com.ktdsuniversity.edu.functional.stream.matching;

import java.util.List;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {

	public static void isExistsVegetarain() {
		// 메뉴리스트에 채식요리가 하나라도 존재하는가?
		// anyMatch
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		boolean isExistsVegetarain = menuList.stream()
											  .anyMatch(dish -> dish.isVegetarian());
		System.out.println(isExistsVegetarain);
		System.out.println(isExistsVegetarain ? "채식요리가 준비되어 있습니다" : "채식요리는 없습니다");
	}
	
	public static void isAllVegetarian() {
		// 모든 메뉴가 채식요리인가?
		// allMatch
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		boolean isAllVegetarian = menuList.stream()
										   .allMatch(dish -> dish.isVegetarian());
		System.out.println(isAllVegetarian);
		System.out.println(isAllVegetarian ? "모든 요리가 채식요리입니다" : "채식요리가 아닌게 존재합니다");
	}
	
	public static void isNotSuperFatFood() {
		// 모든 요리의 각 칼로리가 1000 미만이 아닌가
		// noneMatch, allMatch
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		boolean isNotSuperFatFood = menuList.stream()
											 .noneMatch(dish -> dish.getCalories() < 1000);
		System.out.println(isNotSuperFatFood);
		System.out.println(isNotSuperFatFood ? "1000 칼로리 미만인 음식은 없습니다" : "1000 칼로리 미만인 요리만 있습니다");
		
		isNotSuperFatFood = menuList.stream()
									.allMatch(dish -> dish.getCalories() < 1000);
		System.out.println(isNotSuperFatFood);
		System.out.println(isNotSuperFatFood ? "모든 요리 칼로리가 1000 미만입니다" : "칼로리가 1000 이상인 요리가 존재합니다");
	}
	
	public static void main(String[] args) {
		isExistsVegetarain();
		isAllVegetarian();
		isNotSuperFatFood();
	}
}
