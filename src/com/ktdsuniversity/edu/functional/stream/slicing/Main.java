package com.ktdsuniversity.edu.functional.stream.slicing;

import java.util.List;

import com.ktdsuniversity.edu.functional.stream.introduce.Dish;
import com.ktdsuniversity.edu.functional.stream.introduce.DishList;

public class Main {

	public static void lowCaloricMenu() {
		// 칼로리가 가장 낮은 요리 3개만 조회
		
		// 1. 메뉴리스트를 가져온다
		DishList dishList = new DishList();
		List<Dish> menuList = dishList.getDishList();
		
		// 2. 메뉴리스트를 스트림으로 변환
		menuList.stream()
		// 3. 칼로리 순으로 정렬 (오름차순)
				.sorted((firstDish, secondDish) -> firstDish.getCalories() - secondDish.getCalories())
		// 4. 칼로리가 낮은 3개만 추출
				.limit(3)
		// 4-1. 칼로리가 3번째로 작은 것만 1개 추출
				.skip(2)
		// 5. 추출된 결과를 출력 (이름만)
				.forEach(dish -> System.out.println(dish.getName()));
	}
	
	public static void main(String[] args) {
		lowCaloricMenu();
	}
}
