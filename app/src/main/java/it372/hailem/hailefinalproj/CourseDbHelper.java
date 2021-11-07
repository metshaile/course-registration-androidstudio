package it372.hailem.hailefinalproj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CourseDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "registration.dbh";
    private static final int DATABASE_VERSION = 1;

    CourseDbHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    // This method is only called if the database
    // does not exist.
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table registration(" +
                "name text, id integer, email text, course text, year text, location text, days text, vaccinated text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {

    }
}