public class Game {
    private String number;
    private Comparer comparer;

    public Game(Generator generator, Comparer comparer) {
        this.number = generator.generate();
        this.comparer = comparer;
    }

    public String guess(String guessNumber) {
        return comparer.compare(number, guessNumber);
    }
}
