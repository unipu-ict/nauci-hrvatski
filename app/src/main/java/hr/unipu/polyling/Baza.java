package hr.unipu.polyling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Baza extends SQLiteOpenHelper {
    public static final String TABLE_KATEGORIJE = "kategorije";
    public static final String KATEGORIJE_ID = "ID";
    public static final String KATEGORIJE_NAZIV_EN = "naziv_en";
    public static final String KATEGORIJE_NAZIV_HR = "naziv_hr";
    public static final String KATEGORIJE_IMAGE = "slika";
    public static final String TABLE_FRAZE = "fraze";
    public static final String FRAZE_ID = "ID";
    public static final String FRAZE_NAZIV_EN = "naziv_en";
    public static final String FRAZE_NAZIV_HR = "naziv_hr";
    private static final String LOGTAG = "POLYLING";
    private static final String DATABASE_NAME = "polyling.db";
    private static final int DATABASE_VERSION = 1;
    private static final String KATEGORIJE_CREATE =
            "CREATE TABLE " + TABLE_KATEGORIJE + " (" +
                    KATEGORIJE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KATEGORIJE_NAZIV_EN + " TEXT, " +
                    KATEGORIJE_NAZIV_HR + " TEXT, " +
                    KATEGORIJE_IMAGE + " TEXT, " +
                    ")";

    private static final String FRAZE_CREATE =
            "CREATE TABLE " + TABLE_FRAZE + " (" +
                    FRAZE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FRAZE_NAZIV_EN + " TEXT, " +
                    FRAZE_NAZIV_HR + " TEXT, " +
                    ")";


    public Baza(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(KATEGORIJE_CREATE);
        db.execSQL(FRAZE_CREATE);
        Log.i(LOGTAG, "Table has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KATEGORIJE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRAZE);
        onCreate(db);
    }
}
