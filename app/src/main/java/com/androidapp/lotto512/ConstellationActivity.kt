package com.androidapp.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)


        findViewById<Button>(R.id.btnGoResult).setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }


/*val btnGoResult = findViewById<Button>(R.id.btnGoResult)
        btnGoResult.setOnClickListener { startActivity((Intent)) }*/
    }

}

