package com.ktdsuniversity.edu.functional.stream.generate.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

	public static void theaterSeat() {
		Map<String, List<Boolean>> seats = new HashMap<>();
		
		char A = 'A'; // 65
		System.out.println(A  + 0); // character는 문자도 되고 숫자도 된다
		
		char Z = 'Z'; // 90
		System.out.println(Z + 0);
		
		for(char a = 'A'; a < 'Z' + 1; a++) {
			List<Boolean> emptySeats = new ArrayList<>();
			for(int i =0; i < 15; i++) {
				emptySeats.add((int)(Math.random() * 10) % 2 == 0);
			}
			
			seats.put(a + "", emptySeats);
			
		}
		
		// 1. 도전과제!
		// TODO 앉을 수 있는 자리가 5개 이상되는 열의 이름을 출력 - forEach() 최종함수 사용
		seats.entrySet()
			 .stream()
			 .filter(entry -> entry.getValue().stream()
					 						  .filter(seat -> seat.equals(true))
					 						  .count() >= 5)
			 .forEach(entry -> System.out.println(entry.getKey()));
		
		// 2. 도전과제
		// TODO 열(Row)마다 앉을 수 있는 자리 수를 출력
		/*
		 * 예> A:6 
		 * B:7
		 * C:0 
		 * D:1
		 * ...
		 */
		
		
		// D열에 남아있는 자리가 있나?
		// 객체지향으로 풀면 더더더더 심플
		boolean isEmptyDSeats = seats.get("D").contains(true);
		System.out.println(isEmptyDSeats ? "D열에 남아있는 자리가 있습니다" : "D열에 남아있는 자리가 없습니다");
		
		// 스트림으로 풀어보자
		boolean existsSeat = seats.entrySet() // set<Entry<String, List<Boolean>>>
								   .stream() // Stream<Entry<String, List<Boolean>>>
								   .filter(entry -> entry.getKey().equals("D")) // Stream<Entry<String, List<Boolean>>>
								   .map(entry -> entry.getValue()) // Stream<List<Boolean>>
								   .flatMap(seatsOfD -> seatsOfD.stream()) // Stream<Stream<Boolean>> --> Stream<Boolean>
								   .anyMatch(seat -> seat); // boolean
		
		System.out.println(existsSeat ? "D열에 남아있는 자리가 있습니다" : "D열에 남아있는 자리가 없습니다");
		// D열에 남아있는 자리 중 D5번은 비어있나?
		// Stream을 이용하는 것이 더 비효율적
		// 일반적인 코드 (객체지향) 작성
		boolean emptySeat = seats.get("D").get(4);
		System.out.println(emptySeat ? "D5번 좌석은 앉을 수 있습니다" : "D5번 좌석은 이미 예약되어 있습니다");
		
		// 2. Stream으로 풀어보자
		boolean isEmptyD5 = seats.entrySet() // Set<Entry<String, List<Boolean>>>
								  .stream() // Stream<Entry<String, List<Boolean>>>
								  .filter(entry -> entry.getKey().equals("D")) // <Stream<Entry<String, List<Boolean>>>
								  .map(entry -> entry.getValue().get(4)) // Stream<Boolean>
								  .findFirst() // Optional<Boolean>
								  .orElse(false); // boolean
		System.out.println(existsSeat ? "D열에 남아있는 자리가 있습니다" : "D열에 남아있는 자리가 없습니다");
	}
	
	public static void mapToStream() {
		Map<String, String> map = new HashMap<>();
		map.put("A", "a");
		map.put("B", "b");
		map.put("C", "c");
		map.put("D", "d");
		map.put("E", "e");
		
		// Predicate<T> -> boolean
		// Function<T, R> -> T -> R
		// Consumer<T> -> void
		
		// BiPredicate<T, R> -> (T, R) -> boolean
		// BiFunction<T, U, R> -> (T, U) -> R
		// BiConsumer<T, R> -> (T, R) -> void
		
		// Map Stream: 그냥 Consumer 필요
		// map을 스트림으로 변경하려면, map을 set으로 변경을 해야한다
		map.entrySet() // set<Entry<String, String>>
		   .stream() // Stream<Entry<String, String>>
		   .forEach(entry -> { // Param: Entry<String, String>
			   System.out.println("스트림 -> 대문자: " + entry.getKey() + ", 소문자: " + entry.getValue());
		   }); 
		
		// Lambda foreach: BiConsumer 필요
		map.forEach((key, value) -> {
			System.out.println("대문자: " + key + ", 소문자: " + value);
		});
		
		// Normal While
		String key = null;
		Iterator<String> keyset = map.keySet().iterator();
		while(keyset.hasNext()) {
			key = keyset.next();
			String value = map.get(key);
			
			System.out.println("대문자: " + key + ", 소문자: " + value);
		}
	}
	
	public static void main(String[] args) {
		mapToStream();
		theaterSeat();
	}
}
