package mancala;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void shouldHaveAnOpponent() {
        Player player = new Player();
        assertNotNull(player.getOpponent());
    }

    @Test
    public void test() {
        Player player = new Player();
        player.setAge(10);
        player.setBirthDate(new Date());
        player.setAge(30);
    }
}
