package com.ktdsuniversity.edu.functional.stream.finding;

import java.util.List;
import java.util.Optional;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {

	public static void findFoodName() {
		// 메뉴에서 같은 이름을 가진 메뉴 하나를 조회한다
		// findAny
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		Optional<Dish> rice = menuList.stream()
									  .filter(dish -> dish.getName().equals("rice"))
									  .findAny();
		System.out.println(rice);
		System.out.println(rice.get()); // Dish Type
		System.out.println(rice.get().getCalories());
		
		Optional<Dish> melon = menuList.stream()
				  .filter(dish -> dish.getName().equals("melon"))
				  .findAny();
		System.out.println(melon);
		// System.out.println(melon.get()); // java.util.NoSuchElementException: No value present
		// System.out.println(melon.get().getCalories()); // java.util.NoSuchElementException: No value present
		
		System.out.println(melon.orElse(null)); // null
		System.out.println(melon.orElse(new Dish("수박", true, 400, Dish.Type.OTHER)));
		
		Dish tempDish = melon.orElse(new Dish("수박", true, 400, Dish.Type.OTHER));
		System.out.println(tempDish);
		System.out.println(tempDish.getName());
		System.out.println(tempDish.getCalories());
		System.out.println(tempDish.getType());
	}
	
	public static void findAllByType() {
		// 메뉴에서 채식요리 중 아무거나 하나 가져와 조회한다
		// findAny
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		Optional<Dish> vegetarainFood = menuList.stream()
												.filter(dish -> dish.isVegetarian())
												.findAny();
		Dish vegetarainDish = vegetarainFood.orElse(null);
		System.out.println(vegetarainDish + ", 채색요리: " + vegetarainDish.isVegetarian());
	}
	
	public static void findLowCaloryFood() {
		// 메뉴에서 칼로리가 가장 낮은 메뉴 하나를 가져와 조회한다
		// findFirst
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		// 1. 메뉴 리스트를 스트림으로 변경
		Optional<Dish> lowCaloryFood = menuList.stream()
		// 2. 칼로리를 기준으로 오름차순 정렬한다
											   .sorted((dish1, dish2) -> dish1.getCalories() - dish2.getCalories())
		// 3. findFirst 호출
											   .findFirst();
		// 4. 결과를 orElse 한다
		Dish dish = lowCaloryFood.orElse(null);
		System.out.println(dish);
		
		// 값이 있느냐?
		if (lowCaloryFood.isPresent()) {
			dish = lowCaloryFood.get();
			System.out.println(dish);
		}
	}
	
	public static void findHighCaloryFood() {
		// 메뉴에서 칼로리가 가장 높은 메뉴 하나를 가져와 조회한다
		// findFirst
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		Optional<Dish> highCaloryFood = menuList.stream()
												.sorted((dish1, dish2) -> dish2.getCalories() - dish1.getCalories())
												.findFirst();
		Dish dish = highCaloryFood.orElse(null);
		System.out.println(dish + ", 칼로리: " + dish.getCalories());
	}
	
	public static void main(String[] args) {
		findFoodName();
		System.out.println("=".repeat(44));
		findAllByType();
		System.out.println("=".repeat(44));
		findLowCaloryFood();
		System.out.println("=".repeat(44));
		findHighCaloryFood();
	}
}
