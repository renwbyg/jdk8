package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest2 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("hello", "world", "hello world");

//		strList.stream().filter(str -> str.length() == 5).findFirst().ifPresent(System.out::println);
//
//		strList.stream().mapToInt(str -> str.length()).filter(length -> length==5).findFirst().ifPresent(System.out::println);

		strList.stream().mapToInt(str -> {
			int length = str.length();
			System.out.println(str);
			return length;
		}).filter(item -> item == 5).findFirst().ifPresent(System.out::println);


	}
}
