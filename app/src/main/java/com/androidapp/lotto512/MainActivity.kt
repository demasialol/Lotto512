package com.androidapp.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.lotto512.ConstellationActivity
import java.util.*
import kotlin.collections.ArrayList

fun getRandomLottoNumber(): Int{
    return Random().nextInt(45)+1
}

fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    while (true){
        val number = getRandomLottoNumber()
        var flag_exist = 0

        if (lottoNumbers.size < 1){
            lottoNumbers.add(number)
            continue
        }
        else {
            for (j in 0 until lottoNumbers.size) {
                if (number == lottoNumbers[j]) {
                    flag_exist = 1
                    break
                }
            }
            if (flag_exist == 0)
                lottoNumbers.add(number)
            if (lottoNumbers.size >= 6)
                break
        }
    }
    return lottoNumbers
}

fun getshuffledLottoNumbers() :MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for(number in 1..45){
        lottoNumbers.add(number)
    }
    lottoNumbers.shuffle()

    return  lottoNumbers.subList(0,6)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val card_Constellation = findViewById<CardView>(R.id.ConstellationCard)
        val card_Name = findViewById<CardView>(R.id.NameCard)
        val card_Random = findViewById<CardView>(R.id.ResultCard)

        card_Random.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
        }

        card_Constellation.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }
        card_Name.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }
    }
}
