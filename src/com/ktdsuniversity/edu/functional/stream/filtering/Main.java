package com.ktdsuniversity.edu.functional.stream.filtering;

import java.util.Arrays;
import java.util.List;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {
	
	public static void vegetarianFood() {
		
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		// 채식 요리의 이름만 출력
		// 1. menuList를 스트림으로 변경
		menuList.stream()
				.peek(dish -> {
					// 모든 요리가 출력
					System.out.println("1. 요리명: " + dish.getName());
					System.out.println("1. 채식요리 여부: " + dish.isVegetarian());
				})
		// 2. menuList스트림에서 채식요리만 추출
				.filter(dish -> dish.isVegetarian())
				.peek(dish -> {
					// 여기에서는 isVegetarian의 결과가 true인 것만 출력
					System.out.println("2. 요리명: " + dish.getName());
					System.out.println("2. 채식요리 여부: " + dish.isVegetarian());
				})
		// 3. 요리의 이름만 출력
				.forEach(dish -> System.out.println(dish.getName()));
		
		// 실습:
		// 채식요리가 아닌 것 중에 칼로리가 400 이상인 요리명만 출력 (filter를 두 번 사용)
		// peek을 이용해서 과정을 검증해보자.
		
		System.out.println("=".repeat(44));
		
		menuList.stream()
//				.peek(dish -> {
//					System.out.println("1. 요리명: " + dish.getName());
//					System.out.println("1. 채식요리 여부: " + dish.isVegetarian());
//					System.out.println("1. 칼로리: " + dish.getCalories());
//				})
				.filter(dish -> !dish.isVegetarian())
//				.peek(dish -> {
//					System.out.println("2. 요리명: " + dish.getName());
//					System.out.println("2. 채식요리 여부: " + dish.isVegetarian());
//					System.out.println("2. 칼로리: " + dish.getCalories());
//				})
				.filter(dish -> dish.getCalories() >= 400)
//				.peek(dish -> {
//					System.out.println("3. 요리명: " + dish.getName());
//					System.out.println("3. 채식요리 여부: " + dish.isVegetarian());
//					System.out.println("3. 칼로리: " + dish.getCalories());
//				})
				.forEach(dish -> System.out.println(dish.getName()));
		
	}
	
	public static void evenNumbers() {
		// int [] numberArray = {15615,56,486,4,4,532,1,654,6,132,1,564,3,103,15,4156,1032,1,564,651,35,165,41,648,64,51,61,65,16,165,741,354689,65,416,5164,1651,51};
		// 배열은 스트림을 사용할 수 없음
		
		// 스트림을 사용할 수 있는 것은 Collection (List, Map, Set)
		// 1. 배열을 리스트로 변경
		List<Integer> numberList = Arrays.asList(15615,56,486,4,4,532,1,654,6,132,1,564,3,103,15,4156,1032,1,564,651,35,165,41,648,64,51,61,65,16,165,741,354689,65,416,5164,1651,51);
		
		// 2. 리스트를 스트림으로 변경
		numberList.stream()
		// 3. 스트림에서 짝수만 필터링하자
				  .filter(num -> num % 2 == 0)
		// 4. 중복된 숫자가 있다면 걸러내자
				  .distinct()
				  .sorted() // 정렬 (오름차순)
		// 5. 출력
				  .forEach(num -> System.out.println(num));
	}

	public static void main(String[] args) {
		vegetarianFood();
		evenNumbers();
	}
}
