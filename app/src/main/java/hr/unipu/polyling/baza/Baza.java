package hr.unipu.polyling.baza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hr.unipu.polyling.util.Fraza;
import hr.unipu.polyling.util.Kategorija;

public class Baza {

    private static final String LOGTAG = "POLYLING";
    SQLiteOpenHelper dbhelper;
    SQLiteDatabase database;

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
        List<Kategorija> kategorije = new ArrayList<>();
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
            Log.d(LOGTAG, "Kategorija uspjesno ubacena u bazu.");
        } else {
            Log.d(LOGTAG, "Kategorija nije uspjesno ubacena u bazu.");
        }
    }

    public void obrisiKategorije() {
        //ne postoji TRUNCATE u sqlite
        String sql = "DELETE FROM " + BazaOpenHelper.TABLE_KATEGORIJE;
        database.execSQL(sql);
        sql = "DELETE FROM SQLITE_SEQUENCE WHERE NAME='" + BazaOpenHelper.TABLE_KATEGORIJE + "'";
        database.execSQL(sql); //resetiranje autoincrement ROWID-a
    }

    private List<Fraza> sqlFrazeList(String sql) {
        List<Fraza> fraze = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, null);

        Log.d(LOGTAG, "Fraza u bazi: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Fraza fraza = new Fraza();
                fraza.setId(cursor.getInt(cursor.getColumnIndex(BazaOpenHelper.FRAZE_ID)));
                fraza.setNaziv_en(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.FRAZE_NAZIV_EN)));
                fraza.setNaziv_hr(cursor.getString(cursor.getColumnIndex(BazaOpenHelper.FRAZE_NAZIV_HR)));
                fraza.setKategorija_id(cursor.getInt(cursor.getColumnIndex(BazaOpenHelper.FRAZE_KATEGORIJA_ID)));
                fraze.add(fraza);
            }
        }
        cursor.close();
        return fraze;
    }

    public List<Fraza> getFrazeByKategorijaId(int kategorijaId) {
        List<Fraza> fraze;
        String sql = "SELECT * FROM " + BazaOpenHelper.TABLE_FRAZE + " WHERE " + BazaOpenHelper.FRAZE_KATEGORIJA_ID + " = " + kategorijaId;

        fraze = sqlFrazeList(sql);

        return fraze;
    }

    public List<Fraza> getRandomFraze(int kategorijaId) {
        List<Fraza> fraze;
        String sql = "SELECT DISTINCT * FROM " + BazaOpenHelper.TABLE_FRAZE + " WHERE " + BazaOpenHelper.FRAZE_KATEGORIJA_ID + " = " + kategorijaId + " ORDER BY RANDOM() LIMIT 3";

        fraze = sqlFrazeList(sql);

        return fraze;
    }

    public void dodajFrazu(String naziv_en, String naziv_hr, int kategorijaId) {

        ContentValues values = new ContentValues();
        values.put(BazaOpenHelper.FRAZE_NAZIV_EN, naziv_en);
        values.put(BazaOpenHelper.FRAZE_NAZIV_HR, naziv_hr);
        values.put(BazaOpenHelper.FRAZE_KATEGORIJA_ID, kategorijaId);
        if (database.insert(BazaOpenHelper.TABLE_FRAZE, null, values) > 0) {
            Log.d(LOGTAG, "Fraza uspjesno ubacena u bazu.");
        } else {
            Log.d(LOGTAG, "Fraza nije uspjesno ubacena u bazu.");
        }
    }

    public void obrisiFraze() {
        String sql = "DELETE FROM " + BazaOpenHelper.TABLE_FRAZE;
        database.execSQL(sql);
        sql = "DELETE FROM SQLITE_SEQUENCE WHERE NAME='" + BazaOpenHelper.TABLE_FRAZE + "'";
        database.execSQL(sql); //resetiranje autoincrement ROWID-a
    }

    public int getKategorijaIdByNaziv(String name) {
        int idKategorije = 0;

        String sql = "SELECT * FROM " + BazaOpenHelper.TABLE_KATEGORIJE + " WHERE " + BazaOpenHelper.KATEGORIJE_NAZIV_EN + " = \'" + name + "\'";
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null && cursor.moveToFirst()) {
            idKategorije = cursor.getInt(cursor.getColumnIndex(BazaOpenHelper.KATEGORIJE_ID));
            cursor.close();
        }

        return idKategorije;
    }

    public List<Fraza> searchFraze(String query) {
        List<Fraza> fraze;
        String sql = "SELECT * FROM " + BazaOpenHelper.TABLE_FRAZE + " WHERE " + BazaOpenHelper.FRAZE_NAZIV_EN + " LIKE \'%" + query + "%\'";
        fraze = sqlFrazeList(sql);

        Log.d(LOGTAG, "Koristen sql: " + sql);

        return fraze;
    }
}