package thoughtworks.lecture.seatworks.guess_number;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        Random mockedRandom = mock(Random.class);
        when(mockedRandom.nextInt(9877)).thenReturn(1234);

        game = new Game(new Generator(mockedRandom), new Comparer());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void guess_should_get_right_result_for_certain_input() throws Exception {
        game.start(6);

        String result1 = game.guess("1234");
        String result2 = game.guess("1324");
        String result3 = game.guess("4321");
        String result4 = game.guess("5678");

        assertThat(result1, is("4A0B"));
        assertThat(result2, is("2A2B"));
        assertThat(result3, is("0A4B"));
        assertThat(result4, is("0A0B"));
    }

    @Test
    public void guess_should_get_null_if_not_started() throws Exception {
        String result = game.guess("1234");
        assertThat(result, is((String)null));
    }
}