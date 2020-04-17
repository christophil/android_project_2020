package com.example.sportapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sportapp.database.models.MatchModel;

import java.io.File;
import java.util.ArrayList;

public class SqlLiteDatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "management.db";
    private static final MatchTable matchTable = new MatchTable();

    public SqlLiteDatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("create table if not exists " + this.matchTable.getTABLE_NAME() + " " + this.matchTable.getTABLE_STRUCTURE());
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists " + this.matchTable.getTABLE_NAME() + " " + this.matchTable.getTABLE_STRUCTURE());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ this.matchTable.getTABLE_NAME());
        onCreate(db);
    }

    private static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }

    public boolean addMatch(MatchModel match) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.matchTable.getPLAYER_ONE_COL(), match.getPlayerOne());
        contentValues.put(this.matchTable.getPLAYER_TWO_COL(), match.getPlayerTwo());
        contentValues.put(this.matchTable.getSCORE_COL(), match.getScore());
        long result = db.insert(this.matchTable.getTABLE_NAME(),null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public ArrayList<MatchModel> getAllmatches() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<MatchModel> matches = new ArrayList<MatchModel>();

        Cursor cursor = db.rawQuery("select * from "+ this.matchTable.getTABLE_NAME(),null);

        try {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {

                    matches.add(new MatchModel(
                            cursor.getInt(cursor.getColumnIndex(this.matchTable.getID_COL())),
                            cursor.getString(cursor.getColumnIndex(this.matchTable.getPLAYER_ONE_COL())),
                            cursor.getString(cursor.getColumnIndex(this.matchTable.getPLAYER_TWO_COL())),
                            cursor.getString(cursor.getColumnIndex(this.matchTable.getSCORE_COL()))
                    ));

                    cursor.moveToNext();
                }
            }
        } finally {
            cursor.close();
        }

        return matches;
    }

    public int getMatchCount(){

        int count = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<MatchModel> matches = new ArrayList<MatchModel>();

        Cursor cursor = db.rawQuery("select count(*) from "+ this.matchTable.getTABLE_NAME(),null);
        cursor.moveToFirst();
        count = cursor.getInt(0);
        cursor.close();

        return count;
    }

    public int getPlayerCount(){

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> players = new ArrayList<String>();
        int count = 0;

        Cursor cursor = db.rawQuery("select * from "+ this.matchTable.getTABLE_NAME(),null);

        try {
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {

                    String playerOne = cursor.getString(cursor.getColumnIndex(this.matchTable.getPLAYER_ONE_COL()));
                    String playerTwo = cursor.getString(cursor.getColumnIndex(this.matchTable.getPLAYER_TWO_COL()));

                    if(!players.contains(playerOne)){
                        count = count + 1;
                        players.add(playerOne);
                    }

                    if(!players.contains(playerTwo)){
                        count = count + 1;
                        players.add(playerTwo);
                    }

                    cursor.moveToNext();
                }
            }
        } finally {
            cursor.close();
        }

        return count;

    }

    /*

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }*/
}
