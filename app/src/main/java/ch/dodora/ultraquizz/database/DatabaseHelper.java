package ch.dodora.ultraquizz.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rdomi on 10/10/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "db_quizz.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableTheme.SQL_CREATE_TABLE);
        db.execSQL(TableQuestion.SQL_CREATE_TABLE);

        db.execSQL(TableTheme.SQL_CREATE_PART_00);
        db.execSQL(TableQuestion.SQL_CREATE_PART_00);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TableQuestion.SQL_DROP_TABLE);
        db.execSQL(TableTheme.SQL_DROP_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}