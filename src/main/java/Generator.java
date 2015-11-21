import java.util.List;

public class Generator {
    private List<String> historicalNumbers;

    public String generate() {
        String number;

        do {
            number = randomNumber();
        } while ((int)number.chars().distinct().count() != 4);

        return number;
    }

    private String randomNumber() {
        double randomDouble = Math.random();
        return (int)(randomDouble * 10000) + "";
    }
}
