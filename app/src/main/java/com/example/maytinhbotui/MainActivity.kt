package com.example.maytinhbotui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn0 = findViewById<Button>(R.id.phim0)
        var btn1 = findViewById<Button>(R.id.phim1)
        var btn2 = findViewById<Button>(R.id.phim2)
        var btn3 = findViewById<Button>(R.id.phim3)
        var btn4 = findViewById<Button>(R.id.phim4)
        var btn5 = findViewById<Button>(R.id.phim5)
        var btn6 = findViewById<Button>(R.id.phim6)
        var btn7 = findViewById<Button>(R.id.phim7)
        var btn8 = findViewById<Button>(R.id.phim8)
        var btn9 = findViewById<Button>(R.id.phim9)
        var btncham = findViewById<Button>(R.id.cham)
        var btncong = findViewById<Button>(R.id.cong)
        var btntru = findViewById<Button>(R.id.tru)
        var btnnhan = findViewById<Button>(R.id.nhan)
        var btnchia = findViewById<Button>(R.id.chia)
        var btnbang = findViewById<Button>(R.id.bang)
        var btnon = findViewById<Button>(R.id.on)
        var edt = findViewById<EditText>(R.id.edtNhap)

        var arrNumber: ArrayList<Double?>
        var arrOperation: ArrayList<String>

        fun tinhtoan (input: String)
        {
            arrNumber = ArrayList()
            val regex: Pattern = Pattern.compile("(\\d+(?:\\.\\d+)?)")
            val matcher: Matcher = regex.matcher(input)
            while (matcher.find()){
                arrNumber.add(matcher.group(1).toDouble())
            }

            arrOperation = ArrayList()
            val cArray  = input.toCharArray()
            for (i in 0..cArray.size-1 step 1)
            {
                when(cArray[i])
                {
                    '+' -> arrOperation.add(cArray[i].toString() + "")
                    '-' -> arrOperation.add(cArray[i].toString() + "")
                    '*' -> arrOperation.add(cArray[i].toString() + "")
                    '/' -> arrOperation.add(cArray[i].toString() + "")
                    else -> {}
                }
            }

            val df = DecimalFormat("###.#######")
            var result: Double = 0.0

            if(arrOperation.size >= arrNumber.size || arrOperation.size <1)
            {
                edt.setText("######")
            }
            else
            {
                for (i in 0..arrNumber.size-2 step 1)
                {
                    when(arrOperation[i])
                    {
                        "+" -> {
                            if(i == 0) result = arrNumber[i]!! + arrNumber[i+1]!!
                            else result = result + arrNumber[i+1]!!
                        }
                        "-" -> {
                            if(i == 0) result = arrNumber[i]!! - arrNumber[i+1]!!
                            else result = result - arrNumber[i+1]!!
                        }
                        "*" -> {
                            if(i == 0) result = arrNumber[i]!! * arrNumber[i+1]!!
                            else result = result * arrNumber[i+1]!!
                        }
                        "/" -> {
                            if(i == 0) result = arrNumber[i]!! / arrNumber[i+1]!!
                            else result = result / arrNumber[i+1]!!
                        }
                        else -> {}
                    }
                    edt.setText(df.format(result)+"")
                }
            }
        }


        btn0.setOnClickListener { edt.append("0") }
        btn1.setOnClickListener { edt.append("1") }
        btn2.setOnClickListener { edt.append("2") }
        btn3.setOnClickListener { edt.append("3") }
        btn4.setOnClickListener { edt.append("4") }
        btn5.setOnClickListener { edt.append("5") }
        btn6.setOnClickListener { edt.append("6") }
        btn7.setOnClickListener { edt.append("7") }
        btn8.setOnClickListener { edt.append("8") }
        btn9.setOnClickListener { edt.append("9") }
        btncham.setOnClickListener { edt.append(".") }
        btncong.setOnClickListener { edt.append("+") }
        btntru.setOnClickListener { edt.append("-") }
        btnnhan.setOnClickListener { edt.append("*") }
        btnchia.setOnClickListener { edt.append("/") }
        btnbang.setOnClickListener { tinhtoan(edt.getText().toString()) }
        btnon.setOnClickListener { edt.setText("") }


    }


}