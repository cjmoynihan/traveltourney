package com.example.traveltourney;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;

public class Round {
    Player[][] pairings;
    HashMap<Integer, Player> players;
    int[][][] score;

    public Round(HashMap<Integer, Player> players, Callable<Integer> playerScore) {
        this.players = players;
        this.playerScore = playerScore;
    }

    public Player[][] getPairings() {
        // Sort players by score
        // Implement Gale-Shapley algorithm for pairings
        // Return pairings as 2-player tuples (2-d array)
        return pairings;
    }

    public int[][] getAllScores() {
        // Returns a 2-dimensional array of all paired scores
        return score;
    }

    public int getPlayerScore(int playerID) {
        // Returns the score for playerid from this round
        return 0;
    }

    public String pair(){
        return "Paired";
    }
}
