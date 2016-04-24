package br.com.buylist.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Igor on 14/03/2016.
 */
public class SqLiteDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ContactDataBase.db";
    protected static final int DATABASE_VERSION = 3;

    private static final String DATABASE_CREATION = "CREATE TABLE     Account " +
            "(ID TEXT PRIMARY KEY NOT NULL," +
            " NAME TEXT NOT NULL," +
            " BIRTH DATE NOT NULL," +
            " EMAIL TEXT NOT NULL, " +
            " ISACTIVE INTEGER NOT NULL, " +
            " TOKEN TEXT NOT NULL)";

    public SqLiteDao(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Account");
        onCreate(db);
    }
}
