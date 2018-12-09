package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest3 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello world", "hello world hello", "hello welcome");

		List<String[]> result = list.stream().map(item -> item.split("  ")).distinct().collect(Collectors.toList());
		result.forEach(item -> Arrays.asList(item).forEach(System.out::println));
		System.out.println("-----------------");
		List<String> result2 = list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		result2.forEach(System.out::println);
	}
}
