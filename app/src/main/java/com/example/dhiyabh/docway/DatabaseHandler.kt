package com.example.dhiyabh.docway

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAMED = "Appointment"
val TABLE_NAMED = "DateList"
val COL_NAMED = "namedoctor"
val COL_Date = "date"
val COL_IDD = "id"

class DatabaseHandler2(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAMED,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE "+ TABLE_NAMED + " ("+
                COL_IDD +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAMED+" TXT,"+
                COL_Date+" TXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun insertData(appointment: Appointment){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAMED,appointment.namedoctor)
        cv.put(COL_Date,appointment.date)

        var res = db.insert(TABLE_NAMED,null,cv)
        if (res == -1.toLong()){
            Toast.makeText(context,"failed",Toast.LENGTH_LONG).show()
        }else{Toast.makeText(context,"succes",Toast.LENGTH_LONG).show()}
    }
    fun readData():MutableList<Appointment>{
        var list : MutableList<Appointment> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM " + TABLE_NAMED
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do {
                var appointment = Appointment()
                appointment.id = result.getString(result.getColumnIndex(COL_IDD)).toInt()
                appointment.namedoctor = result.getString(result.getColumnIndex(COL_NAMED))
                appointment.date = result.getString(result.getColumnIndex(COL_Date))
                list.add(appointment)
            } while (result.moveToNext())

        }
        result.close()
        db.close()
        return  list
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAMED, null, null)


        db.close()
    }






}