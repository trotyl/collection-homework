import java.util.List;
import java.util.stream.Collectors;

public class CollectionsOps {

    public static List<Integer> odd(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
    }

    public static List<Integer> doubleEvens(List<Integer> numbers) {
        return numbers.stream().map(i -> i % 2 == 0? 2 * i: i).collect(Collectors.toList());
    }

    public static String tryFind(Integer toFind, List<Integer> numbers) {
        return numbers.stream().anyMatch(i -> i.equals(toFind))? "Hello, " + toFind: "Not Found";
    }
}
