package ru.netology.javaqa.homework.fourteen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    @Test
    void testRoundPlayerOneWins() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Tanya", 10);
        Player player2 = new Player(2, "Alex", 5);

        game.register(player1);
        game.register(player2);

        int result = game.round("Tanya", "Alex");
        Assertions.assertEquals(1, result);
    }

    @Test
    void testRoundPlayerTwoWins() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Mark", 5);
        Player player2 = new Player(2, "Dima", 10);

        game.register(player1);
        game.register(player2);

        int result = game.round("Mark", "Dima");
        assertEquals(2, result);
    }

    @Test
    void testRoundDraw() throws NotRegisteredException {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 10);
        Player player2 = new Player(2, "Kolya", 10);

        game.register(player1);
        game.register(player2);

        int result = game.round("Oleg", "Kolya");
        assertEquals(0, result);
    }

    @Test
    void testRoundPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Katya", 10);

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Katya", "Igor");
        });
    }
}