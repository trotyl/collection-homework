package thoughtworks.lecture.homeworks.collection;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CollectionsOps {

    public static List<Integer> odd(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 != 0).collect(toList());
    }

    public static List<Integer> doubleEvens(List<Integer> numbers) {
        return numbers.stream().map(i -> i % 2 == 0 ? 2 * i : i).collect(toList());
    }

    public static String tryFind(Integer toFind, List<Integer> numbers) {
//        return numbers.stream().filter(i -> i.equals(toFind)).map(integer -> "Hello, " + integer).findFirst().orElse("Not Found");
        return numbers.stream().anyMatch(i -> i.equals(toFind)) ? "Hello, " + toFind : "Not Found";
    }
}
