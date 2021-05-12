package com.androidapp.lotto512

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        Toast.makeText(this,"Name Activity", Toast.LENGTH_LONG).show()
    }
}