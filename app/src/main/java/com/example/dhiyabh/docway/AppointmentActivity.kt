package com.example.dhiyabh.docway

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_appointment.*




class AppointmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        val context = this
        var db = DatabaseHandler2(context)

        bttn1.setOnClickListener{
            if(ett1.text.toString().length > 0 && ett2.text.isNotEmpty() ){
                var appointment = Appointment(ett1.text.toString(),ett2.text.toString())

                db.insertData(appointment)
                var data = db.readData()
                t2.text = ""
                for(i in 0..data.size-1){
                    t2.append(data.get(i).namedoctor+": "+data.get(i).date+"\n")
                }
            }else{
                Toast.makeText(context,"failed, verify!",Toast.LENGTH_LONG).show()
            }
        }


        bttn2.setOnClickListener {
            db.deleteData()
            var data = db.readData()
            t2.text = ""
            for(i in 0..data.size-1){
                t2.append(data.get(i).namedoctor+": "+data.get(i).date+"\n")
            }
        }
        bttn3.setOnClickListener{
            startActivity(Intent(this,CalendarActivity::class.java))
        }

        var data = db.readData()
        t2.text = ""
        for(i in 0..data.size-1){
            t2.append(data.get(i).namedoctor+": "+data.get(i).date+"\n")
        }


    }

}



