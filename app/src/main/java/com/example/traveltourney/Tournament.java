package com.example.traveltourney;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.*;
import java.util.concurrent.Callable;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Tournament {
    /** This object represents the entirety of a running tournament. It keeps track of:
     * Players (names and ids)
     * Rounds (pairings and player scores)
    **/
    HashMap<Integer, Player> players;
    ArrayList<Round> rounds;

    public Tournament() {
        players = new HashMap<Integer, Player>();
        players.put(-1, new Player("BYE"));
        rounds = new ArrayList<Round>();
    }

    public Tournament(HashMap<Integer, Player> players){
        this.players = players;
        rounds = new ArrayList<Round>();
    }

    public Tournament(HashMap<Integer, Player> players,ArrayList<Round> rounds){
        this.players = players;
        this.rounds = rounds;
    }

    public int getCurrentRound(){
        return rounds.size();
    }

    public int roundsFromPlayers(){
        int numPlayers = players.size();
        return (int)Math.ceil(Math.log(numPlayers));
    }

    private int largestID () {
        // Returns the largest player id
        Integer largestPlayerID = Collections.max(this.players.keySet());
        return largestPlayerID;
    }

    public void addPlayer(String name) {
        Player newPlayer = new Player(name);
        this.players.put(this.largestID() + 1, newPlayer);
    }

    private Callable<Integer> getPlayerScoreCallable(int numRounds) {
        // Closure that returns the score of a player at round # numRounds
        class PlayerScoring {
            public Callable<Integer> scorePlayer;

            public int scorePlayer(int playerID) {
                int currentScore = 0;
                for (int currentRound = 0; currentRound < numRounds; currentRound ++) {
                    currentScore += rounds.get(currentRound).getPlayerScore(playerID);
                }
                return currentScore;
            }
        }
        return new PlayerScoring().scorePlayer;
    }
    public void addRound() {
        Round newRound = new Round(this.players, getPlayerScoreCallable(rounds.size()));
        rounds.add(newRound);
    }
}
