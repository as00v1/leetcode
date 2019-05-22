package com.qiaohx.others;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 试验下java8的新特性Stream
 */
public class StreamDemo {

    public static void main(String[] args) {
        demo();
    }

    private static void demo(){
        String[] array = {"a", "b", "c", "d", "b", null, ""};
        Stream<String> stream = Arrays.stream(array);
        long count = stream.filter(c->Optional.ofNullable(c).isPresent()).count();
        System.out.println(count);
    }
}
