package ru.netology.javaqa.homework.fourteen;

import java.util.HashMap;

class Game {
    private HashMap<String,Player> players;

    public Game() {
        players = new HashMap<>();
    }

    public void register(Player player) {

        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException{
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Один или оба игрока не зарегестрированы");
        }

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }

    private Player findPlayerByName(String playerName) {
        return players.get(playerName);
    }
}
