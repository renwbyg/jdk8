package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MySetCollectTest<T> implements Collector<T,Set<T>, Map<T,T>> {

	@Override
	public Supplier<Set<T>> supplier() {
		System.out.println("supplier invoked!");
		return HashSet<T>::new;
	}

	@Override
	public BiConsumer<Set<T>, T> accumulator() {
		System.out.println("accumulator invoked!");
		return (set, item) -> set.add(item);
	}

	@Override
	public BinaryOperator<Set<T>> combiner() {
		System.out.println("combiner invoked!");
		return (set1,set2) -> {
			set1.addAll(set2);
			return set1;
		};
	}

	@Override
	public Function<Set<T>, Map<T, T>> finisher() {
		System.out.println("finisher invoked!");
		return set -> {
			Map<T, T> map = new HashMap<T,T>();
			set.stream().forEach(item -> map.put(item,item));
			return map;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		System.out.println("characteristics invoked!");
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello", "world", "hello world", "welcome", "a", "b", "c", "d");
		Set<String> set = new HashSet<>();
		set.addAll(list);
		System.out.println(set);
		Map<String, String> map = set.stream().collect(new MySetCollectTest<>());
		System.out.println(map);
	}
}
