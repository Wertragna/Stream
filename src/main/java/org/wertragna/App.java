package org.wertragna;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    }


    public static String task1(List<String> names) {
        return IntStream
                .range(0, names.size())
                .filter(a -> a % 2 == 0)
                .mapToObj(a -> a + 1 + ". " + names.get(a))
                .collect(Collectors.joining(", "));
    }

    public static List<String> task2(List<String> names) {
        return names.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static void task3(String... numbers) {
        Arrays.asList(numbers)
                .stream()
                .flatMap(a -> Arrays
                        .asList(a.split(","))
                        .stream())
                .forEach(System.out::println);
    }


    public static Stream<Long> task4() {
        long seed = 7, a = 25214903917l, c = 11, m = (long) Math.pow(2, 48);
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static <T> Stream<T> zip(final Stream<T> first, final Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        List<T> list = new ArrayList<>();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            list.add(firstIterator.next());
            list.add(secondIterator.next());
            if (!secondIterator.hasNext() && firstIterator.hasNext()) {
                list.add(firstIterator.next());
            }
        }
        return list.stream();
    }

}
