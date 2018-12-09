package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest5 {
	public static void main(String[] args) {
		Student s1 = new Student("zhangsan", 20, 100);
		Student s2 = new Student("lisi", 20, 90);
		Student s3 = new Student("wangwu", 30, 80);
		Student s4 = new Student("zhangsan", 20, 90);

		List<Student> students = Arrays.asList(s1, s2, s3, s4);
//		Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(s -> s.getName()));

//		Map<Integer, Long> map = students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.counting()));
		Map<String, Double> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));



		System.out.println(map);
	}
}
