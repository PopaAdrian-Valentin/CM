package com.example.proiect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String dbName="proiectDB";
    private static int dbVersion=1;

    private static String exercitiuTable="exercitiu";
    private static String antrenamentTable="antrenament";

    private static String idColumn="id";
    private static String nameColumn="name";
    private static String durataColumn="durata";
    private static String exid1Column="exid1";
    private static String exid2Column="exid2";
    private static String exid3Column="exid3";

    public DataBaseHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + exercitiuTable+  "(" +
                idColumn + " integer primary key autoincrement, " +
                nameColumn + " text, " +
                durataColumn + " integer" +
                ")");

        sqLiteDatabase.execSQL("create table " + antrenamentTable+  "(" +
                idColumn + " integer primary key autoincrement, " +
                nameColumn + " text, " +
                exid1Column + " integer references " + exercitiuTable + "(" + idColumn + ")," +
                exid2Column + " integer references " + exercitiuTable + "(" + idColumn + ")," +
                exid3Column + " integer references " + exercitiuTable + "(" + idColumn + ")" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean createExercitiu(Exercitiu exercitiu){
        try{
            SQLiteDatabase sqLiteDatabase=getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(nameColumn,exercitiu.getNume());
            contentValues.put(durataColumn,exercitiu.getDurata());
            return sqLiteDatabase.insert(exercitiuTable,null,contentValues)>0;
        } catch (Exception e){
            return false;
        }
    }

    public List<Exercitiu> findAllExercitii(){
        List<Exercitiu> exercitii=new ArrayList<Exercitiu>();
        try{
            SQLiteDatabase sqLiteDatabase=getReadableDatabase();
            Cursor cursor= sqLiteDatabase.rawQuery("select * from "+ exercitiuTable, null);
            if(cursor.moveToFirst()){

                do{
                    Exercitiu ex =new Exercitiu();
                    ex.setId(cursor.getInt(0));
                    ex.setNume(cursor.getString(1));
                    ex.setDurata(cursor.getInt(2));
                    exercitii.add(ex);
                }while(cursor.moveToNext());
            }
        }catch (Exception e){
            exercitii=null;
        }
        return exercitii;
    }

    public boolean createAntrenament(Antrenament antrenament){
        try{
            SQLiteDatabase sqLiteDatabase=getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(nameColumn,antrenament.getNume());
            contentValues.put(exid1Column,antrenament.getExid1());
            contentValues.put(exid2Column,antrenament.getExid2());
            contentValues.put(exid3Column,antrenament.getExid3());
            return sqLiteDatabase.insert(antrenamentTable,null,contentValues)>0;
        } catch (Exception e){
            return false;
        }
    }
}
