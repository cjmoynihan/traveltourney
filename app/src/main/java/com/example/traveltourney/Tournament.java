package com.example.traveltourney;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.*;

public class Tournament {
    Set<Player> players;
    Round[] rounds;

    public Tournament() {
        players = new Set<Player>() {

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Player> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Player player) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Player> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }
            };

        players.add(new Player("BYE",-1));
    }

    public Tournament(Set<Player> players){
        this.players = players;
        rounds = new Round[roundsFromPlayers()];
    }
    public Tournament(Set<Player> players,Round[] rounds){
        this.players = players;
        this.rounds = rounds;
    }

    public int getCurrentRound(){
        return rounds.length;
    }

    public int roundsFromPlayers(){
        int numPlayers = players.size();
        return (int)Math.ceil(Math.log(numPlayers));
    }
}
