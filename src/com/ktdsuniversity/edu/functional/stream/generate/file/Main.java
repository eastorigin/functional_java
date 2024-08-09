package com.ktdsuniversity.edu.functional.stream.generate.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

	public static void wordCounter() {
		
		// Java Exam 폴더의 data.txt 파일을 읽어서
		// 파일에 작성되어있는 단어들의 개수는 몇 개인가?
		
		File dataFile = new File("C:\\Java Exam", "data.txt");
		
		// 파일의 내용을 읽어서 Stream<String>으로 변환해준다
		Stream<String> lineStream = null;
		try {
			lineStream = Files.lines(dataFile.toPath());
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		if(lineStream != null) {
			// lineStream.parallel() // 병렬로 변경됨
			// 1. 스트림에 들어있는 한 줄의 내용을 띄어쓰기로 자른다
			long count = lineStream.parallel() // 병렬처리한다
									.flatMap(line -> Arrays.stream(line.split(" ")))
			// 2. 각 단어들 중에서 중복된 단어들은 모두 지운다
									.distinct()
									.filter(word -> word.trim().length() > 0) // 공백은 제외
									.filter(word -> word.matches("[가-힣]+$")) // 한글만 가져와서
			// 3. 중복이 제거된 단어들의 개수를 센다
									.count(); // 개수를 센다
			//		  .forEach(word -> System.out.println(word));
			System.out.println("단어의 개수는 " + count + "개 입니다");
		}
	}
	
	public static void main(String[] args) {
		wordCounter();
	}
}
