package com.androidapp.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val txtConstell = findViewById<TextView>(R.id.txtConstell)


        findViewById<Button>(R.id.btnGoResultConstell).setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }


/*val btnGoResult = findViewById<Button>(R.id.btnGoResult)
        btnGoResult.setOnClickListener { startActivity((Intent)) }*/
    }

}

