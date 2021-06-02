package com.example.lotto512

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.androidapp.lotto512.R
import com.androidapp.lotto512.ResultActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val txtConstell = findViewById<TextView>(R.id.txtConstell)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
       txtConstell.text = makeConstellationString(datePicker.month + 1, datePicker.dayOfMonth)

        val btnGoResultConstell = findViewById<Button>(R.id.btnGoResultConstell)
        btnGoResultConstell.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            btnGoResultConstell.setOnClickListener {
                intent.putIntegerArrayListExtra("result",
                        ArrayList(getShuffledLottoNumberFromHash(txtConstell.text.toString(),datePicker.month,datePicker.dayOfMonth)))
                intent.putExtra("constellation", makeConstellationString(datePicker.month, datePicker.dayOfMonth))
                startActivity(intent)
                val date = ""+datePicker.year + "년" + datePicker.month +"월" + datePicker.dayOfMonth+"일"
                intent.putExtra("date",date)
            }
        val calendar = Calendar.getInstance()
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
            }

            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
              txtConstell.text = makeConstellationString(datePicker.month,datePicker.dayOfMonth)
            }

        }
    }
        fun getShuffledLottoNumberFromHash(str: String, month: Int, dayOfMonth: Int): MutableList<Int> {
            val list = mutableListOf<Int>()
            for (number in 1..45){
                list.add(number)
            }
            val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + str
            val target = "${month + 1}${String.format("%02d",dayOfMonth)}"+ str
            list.shuffle(Random(targetString.hashCode().toLong()))
            return list.subList(0, 6)

        }

    private fun makeConstellationString(month: Int, dayOfMonth: Int): String {
        val target = "${month}${String.format("%02d", dayOfMonth)}".toInt()

        when (target) {
            in 101..119 -> return "염소자리"
            in 128..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1124 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }


}


