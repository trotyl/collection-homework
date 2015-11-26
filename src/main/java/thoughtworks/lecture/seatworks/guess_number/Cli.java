package thoughtworks.lecture.seatworks.guess_number;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Cli {
    public Cli() {

    }

    public static void main(String[] args) throws IOException {
        Game game = new Game(new Generator(new Random()), new Comparer());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        game.start(6);
        System.out.println("Welcome!");
        System.out.println();

        while (true) {
            int remaining = game.getRemaining();
            if (remaining == 0) {
                System.out.println("Game Over");
                break;
            }

            System.out.printf("Please input your number(%d):", remaining);
            String input = reader.readLine();
            System.out.println();

            if (input.chars().distinct().count() < 4) {
                System.out.println("Cannot input duplicate numbers!");
                System.out.println();
                continue;
            }

            String result = game.guess(input);
            if (result.equals("4A0B")) {
                System.out.println("Congratulations!");
                break;
            }
        }

    }
}
