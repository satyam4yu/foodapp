package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.Nullable;

import com.example.myapplication.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
  final static String DBNAME="mydatabase.db";
  final static int DBVersion = 5;
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
              "create table  orders" +
              "(id integer primary key autoincrement,"+
              "name text," +
                      "phone text," +
                      "price int," +
                      "image int,"+
                      "quantity int,"+
                      "description text,"+
                      "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

      sqLiteDatabase.execSQL("DROP table if exists orders ");
      onCreate(sqLiteDatabase);

    }
    public boolean insertOrder(String name,String phone ,int price,int image,String description,String foodname,int quantity){
      SQLiteDatabase database= getReadableDatabase();
      ContentValues values = new ContentValues();
      values.put("name",name);
      values.put("phone",phone);
      values.put("price",price);
      values.put("image",image);
      values.put("description",description);
      values.put("foodname",foodname);
      values.put("quantity",quantity);

      long id= database.insert("orders",null,values);
      if(id<=0)
        return false;
      else
        return true;

    }
 public ArrayList<OrdersModel> getOrders(){
      ArrayList<OrdersModel> orders=new ArrayList<>();
      SQLiteDatabase database = this.getWritableDatabase();
   Cursor cursor = database.rawQuery("Select id,foodname,image,price from orders",null);
   if(cursor.moveToFirst()){
    do{
       OrdersModel model= new OrdersModel();
       model.setOrderNumber(cursor.getInt(0)+"");
       model.setSoldItemName(cursor.getString(1));
       model.setOrderImage(cursor.getInt(2));
       model.setPrice(cursor.getInt(3)+"");
       orders.add(model);

     }while(cursor.moveToNext());
   }
     cursor.close();
   database.close();
   return orders;
 }
 public Cursor getOrderById(int id){
   ArrayList<OrdersModel> orders=new ArrayList<>();
   SQLiteDatabase database = this.getWritableDatabase();
   Cursor cursor = database.rawQuery("Select * from orders where id="+id,null);

   if(cursor != null)
     cursor.moveToFirst();


   return cursor;

 }
  public boolean updateOrder(String name,String phone ,int price,int image,String description,String foodname,int quantity,int id){
    SQLiteDatabase database= getReadableDatabase();
    ContentValues values = new ContentValues();
    values.put("name",name);
    values.put("phone",phone);
    values.put("price",price);
    values.put("image",image);
    values.put("description",description);
    values.put("foodname",foodname);
    values.put("quantity",quantity);

    long row= database.update("orders",values,"id="+id,null);
    if(row<=0)
      return false;
    else
      return true;

  }
 public int deleteOrder(String id){
      SQLiteDatabase database = this.getWritableDatabase();
      return database.delete("orders","id="+id, null);


 }

}
