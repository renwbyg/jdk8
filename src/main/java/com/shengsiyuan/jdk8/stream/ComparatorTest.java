package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
		Collections.sort(list);
		System.out.println(list);

		Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
		Collections.sort(list, Comparator.comparingInt(item -> item.length()));



	}
}
