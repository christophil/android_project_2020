package com.example.sportapp.database;

public class MatchTable {

    private final String TABLE_NAME = "MATCH";
    private final String TABLE_STRUCTURE = "(ID INTEGER PRIMARY KEY AUTOINCREMENT,PLAYER_ONE TEXT,PLAYER_TWO TEXT,SCORE TEXT)";

    private final String ID_COL = "ID";
    private final String PLAYER_ONE_COL = "PLAYER_ONE";
    private final String PLAYER_TWO_COL = "PLAYER_TWO";
    private final String SCORE_COL = "SCORE";

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String getTABLE_STRUCTURE() {
        return TABLE_STRUCTURE;
    }

    public String getID_COL() {
        return ID_COL;
    }

    public String getPLAYER_ONE_COL() {
        return PLAYER_ONE_COL;
    }

    public String getPLAYER_TWO_COL() {
        return PLAYER_TWO_COL;
    }

    public String getSCORE_COL() {
        return SCORE_COL;
    }
}
