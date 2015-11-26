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
    public void should_show_welcome_when_started() {
        String input = String.join(System.getProperty("line.separator"),
                "1111", "1111", "1111", "1111", "1111", "1111");
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());

        Cli.main(null);

        String[] outputLines = testOut.toString().split(System.getProperty("line.separator"));

        assertThat(outputLines[0], is("Welcome!"));
    }
}
