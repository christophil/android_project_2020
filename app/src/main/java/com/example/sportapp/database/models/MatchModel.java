package com.example.sportapp.database.models;

import androidx.annotation.NonNull;

public class MatchModel {
    private int id;
    private String playerOne;
    private String playerTwo;
    private String score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public MatchModel(int id, String playerOne, String playerTwo, String score) {
        this.id = id;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.score = score;
    }

    @NonNull
    @Override
    public String toString() {
        return "" + this.playerOne + " VS " + this.playerTwo + " => " + this.score;
    }
}
