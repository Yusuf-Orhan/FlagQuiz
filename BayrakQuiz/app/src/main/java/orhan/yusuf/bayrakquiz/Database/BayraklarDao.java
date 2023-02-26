package orhan.yusuf.bayrakquiz.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BayraklarDao {
    public ArrayList<Bayraklar> random5(DataBase db){
        ArrayList<Bayraklar> arrayList = new ArrayList<>();
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 10",null);
        int IdIx = cursor.getColumnIndex("bayrak_id");
        int resim_Ix = cursor.getColumnIndex("bayrak_resim");
        int bayrak_ad_Ix = cursor.getColumnIndex("bayrak_ad");
        while (cursor.moveToNext()){
            int Id = cursor.getInt(IdIx);
            String resim = cursor.getString(resim_Ix);
            String bayrak_ad = cursor.getString(bayrak_ad_Ix);
            Bayraklar bayraklar = new Bayraklar(bayrak_ad,resim,Id);
            arrayList.add(bayraklar);
        }
        return arrayList;
    }
    public ArrayList<Bayraklar> random_yanlis3(DataBase db,int bayrak_id){
        ArrayList<Bayraklar> arrayList = new ArrayList<>();
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != "+bayrak_id+" ORDER BY RANDOM()  LIMIT 3",null);
        int IdIx = cursor.getColumnIndex("bayrak_id");
        int resim_Ix = cursor.getColumnIndex("bayrak_resim");
        int bayrak_ad_Ix = cursor.getColumnIndex("bayrak_ad");
        while (cursor.moveToNext()){
            int Id = cursor.getInt(IdIx);
            String resim = cursor.getString(resim_Ix);
            String bayrak_ad = cursor.getString(bayrak_ad_Ix);
            Bayraklar bayraklar = new Bayraklar(bayrak_ad,resim,Id);
            arrayList.add(bayraklar);
        }
        return arrayList;
    }
}
