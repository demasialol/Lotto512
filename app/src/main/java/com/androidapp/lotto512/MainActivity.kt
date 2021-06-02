package com.androidapp.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.lotto.ConstellationActivity
import java.util.*
import kotlin.collections.ArrayList

fun getRandomLottoNumber(): Int{
    return Random().nextInt(45)+1
}


fun getShuffledLottoNumber(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()
        for (i in 1..6){
            var number = 0
            do{
                number = getRandomLottoNumber()
            }while (lottoNumbers.contains(number))
            lottoNumbers.add(number)
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


        val ResultCard = findViewById<CardView>(R.id.ResultCard)
        ResultCard.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            //intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumber()))
            //result가 getRandomLottoNumbers()를 ResultActivity에서 받아주는 키값
            startActivity(intent)

            val resultIntent = Intent(this, ResultActivity::class.java)
            ResultCard.setOnClickListener { startActivity(resultIntent) }
        }

        val ConstellationCard = findViewById<CardView>(R.id.ConstellationCard)
        ConstellationCard.setOnClickListener {
            val ConstellIntent = Intent(this, ConstellationActivity::class.java)
            ConstellationCard.setOnClickListener { startActivity(ConstellIntent) }
        }

        val NameCard = findViewById<CardView>(R.id.NameCard)
        NameCard.setOnClickListener {
            val NameIntent = Intent(this, NameActivity::class.java)
            NameCard.setOnClickListener { startActivity(NameIntent) }
        }
    }
}
