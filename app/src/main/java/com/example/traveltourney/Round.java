package com.example.traveltourney;

import java.util.Set;

public class Round {
    Player[][] pairings;
    Set<Player> players;
    int[][][] score;

    public Round(Set<Player> players) {
        this.players = players;
    }

    public Player[][] getPairings() {
        return pairings;
    }

    public int[][][] getScore() {
        return score;
    }

    public String pair(){
        return "Paired";
    }
}
