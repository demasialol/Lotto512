package com.androidapp.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList

fun getRandomLottoNumber(): Int{
    return Random().nextInt(45)+1
}

fun getRandomLottoNumbers(): MutableList<Int> {
    val lottoNumbers = mutableListOf<Int>()

    while (true) {
        val number = getRandomLottoNumber()
        var flag_exist = 0;

        if (lottoNumbers.size < 1) {
            lottoNumbers.add(number)
            continue
        } else {
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

/*fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNUmbers = mutableListOf<Int>()

    for(i in 1..6){
        var number = 0
        do{
            number = getRandomLottoNumber()
        }while(lottoNUmbers.contains(number))
        lottoNumbers.add(number)
    }
    return.lottoNumbers
}*/


    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            findViewById<View>(R.id.ResultCard).setOnClickListener {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
               /// intent.putIntegerArrayListExtra("result", ArrayList(getSuffledLottoNumbers()))
                startActivity(intent)
            }
            findViewById<View>(R.id.ConstellationCard).setOnClickListener {
                val intent = Intent(this, ConstellationActivity::class.java)
                startActivity(intent)
            }
            findViewById<View>(R.id.NameCard).setOnClickListener {
                val intent = Intent(this, NameActivity::class.java)
                startActivity(intent)
            }

        }
        val numbers = { listOf(1,2,3,4)}
        /*println(numbers)
        numbers.forEach{numbers -> println(numbers)}
        numbers.forEach{numbers -> println(number)}
        numbers.forEach{println(it)}
        val mutableNumbers = mutableListOf<Int>(5,6,7,8)*/
    }