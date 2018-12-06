package com.shengsiyuan.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("hello", "world", "welcome");
//        String[] strArray = stream.toArray(length -> new String[length]);
//        String[] strArray = stream.toArray(String[]::new);
//
//        Arrays.asList(strArray).forEach(str-> System.out.println(str));
//        Arrays.asList(strArray).forEach(System.out::println);
//
//        List<String> list = stream.collect(Collectors.toList());
        Stream<String> stream = Stream.of("hello", "world", "welcome");
        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        list.forEach(System.out::println);

    }
}
