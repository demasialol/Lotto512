package com.androidapp.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.ConstellationCard).setOnClickListener{
            val intent = Intent(this,ConstellationActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.NameCard).setOnClickListener{
            val intent = Intent(this,NameActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.ResultCard).setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }

    }




}