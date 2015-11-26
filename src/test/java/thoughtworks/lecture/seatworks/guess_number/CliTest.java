package thoughtworks.lecture.seatworks.guess_number;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


public class CliTest {
    private Cli cli;

    ByteArrayOutputStream testOut;

    @Before
    public void setUp() throws Exception {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void should_show_welcome_when_started() throws Exception {
        String input = String.join(System.getProperty("line.separator"),
                "1111", "1234", "1234", "1234", "1234", "1234", "1234");
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Cli.main(null);

        String[] outputLines = testOut.toString().split(System.getProperty("line.separator"));

        assertThat(outputLines[0], is("Welcome!"));
    }

    @Test
    public void should_prompt_duplicate_when_input_duplicated_digits() throws Exception {
        String input = String.join(System.getProperty("line.separator"),
                "1111", "1234", "1234", "1234", "1234", "1234", "1234");
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

        Cli.main(null);

        String[] outputLines = testOut.toString().split(System.getProperty("line.separator"));

        assertThat(outputLines[3], is("Cannot input duplicate numbers!"));
    }

    @Test
    public void should_have_proper_order_of_prompt() throws Exception {
        String input1 = String.join(System.getProperty("line.separator"),
                "1234", "1234", "1234", "1234", "1234", "1234");
        String input2 = String.join(System.getProperty("line.separator"),
                "1235", "1235", "1235", "1235", "1235", "1235");

        ByteArrayInputStream testIn1 = new ByteArrayInputStream(input1.getBytes());
        ByteArrayInputStream testIn2 = new ByteArrayInputStream(input2.getBytes());

        ByteArrayOutputStream testOut1 = new ByteArrayOutputStream();
        ByteArrayOutputStream testOut2 = new ByteArrayOutputStream();

        System.setIn(testIn1);
        System.setOut(new PrintStream(testOut1));
        Cli.main(null);
        String[] outputLines1 = testOut1.toString().split(System.getProperty("line.separator"));

        System.setIn(testIn2);
        System.setOut(new PrintStream(testOut2));
        Cli.main(null);
        String[] outputLines2 = testOut2.toString().split(System.getProperty("line.separator"));

        String[] outputNeeded = outputLines1[2].equals("Congratulations!")? outputLines2: outputLines1;

        assertThat(outputNeeded.length, is(9));
        assertThat(outputNeeded[0], is("Welcome!"));
        assertThat(outputNeeded[1], is(""));
        assertThat(outputNeeded[2], is("Please input your number(6):"));
        assertThat(outputNeeded[3], is("Please input your number(5):"));
        assertThat(outputNeeded[4], is("Please input your number(4):"));
        assertThat(outputNeeded[5], is("Please input your number(3):"));
        assertThat(outputNeeded[6], is("Please input your number(2):"));
        assertThat(outputNeeded[7], is("Please input your number(1):"));
        assertThat(outputNeeded[8], is("Game Over"));
    }
}
