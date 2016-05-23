package hr.unipu.polyling.baza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hr.unipu.polyling.model.Kategorija;

public class Baza {

    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;
    private static final String LOGTAG = "POLYLING";

    public Baza(Context context) {
        dbhelper = new BazaOpenHelper(context);
        open();
    }

    public void open() {
        database = dbhelper.getWritableDatabase();
        Log.d(LOGTAG, "Baza podataka otvorena");
    }

    public void close() {
        dbhelper.close();
        Log.d(LOGTAG, "Baza podataka zatvorena");
    }

    public List<Kategorija> sveKategorije() {
        List<Kategorija> kategorije = new ArrayList<Kategorija>();
        String sql = "SELECT * FROM " + BazaOpenHelper.TABLE_KATEGORIJE;
        Cursor cursor = database.rawQuery(sql, null);

        Log.d(LOGTAG, "Kategorija u bazi: " +cursor.getCount());
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                Kategorija kategorija = new Kategorija();
                kategorija.setId(cursor.getInt(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_ID)));
                kategorija.setNaziv_en(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_NAZIV_EN)));
                kategorija.setNaziv_hr(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_NAZIV_HR)));
                kategorija.setSlika(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_IMAGE)));
                kategorije.add(kategorija);
            }
        }
        cursor.close();
        return kategorije;

    }

    public Kategorija getKategorijabyID(int id) {

        String sql = "SELECT * FROM " + BazaOpenHelper.TABLE_KATEGORIJE + " WHERE " + BazaOpenHelper.KATEGORIJE_ID + " = " + id;
        Cursor cursor = database.rawQuery(sql, null);

        Kategorija kategorija = new Kategorija();

        if (cursor!=null && cursor.moveToFirst()) {

            kategorija.setId(cursor.getInt(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_ID)));
            kategorija.setNaziv_en(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_NAZIV_EN)));
            kategorija.setNaziv_hr(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_NAZIV_HR)));
            kategorija.setSlika(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_IMAGE)));
            cursor.close();
        }

        return kategorija;
    }

    public void dodajKategoriju(String naziv_en, String naziv_hr, String slika) {

        ContentValues values = new ContentValues();
        values.put(BazaOpenHelper.KATEGORIJE_NAZIV_EN, naziv_en);
        values.put(BazaOpenHelper.KATEGORIJE_NAZIV_HR, naziv_hr);
        values.put(BazaOpenHelper.KATEGORIJE_IMAGE, slika);
        if(database.insert(BazaOpenHelper.TABLE_KATEGORIJE, null, values) > 0) {
            Log.d(LOGTAG, "Kategorija uspjesno ubacena u bazu");
        } else {
            Log.d(LOGTAG, "Kategorija nije uspjesno ubacena u bazu. ");
        };


    }

    public void obrisiKategorije() {
        //ne postoji TRUNCATE u sqlite
        String sql = "DELETE FROM " + BazaOpenHelper.TABLE_KATEGORIJE;
        database.execSQL(sql);
        database.execSQL("VACUUM");//resetiranje baze

    }
}
