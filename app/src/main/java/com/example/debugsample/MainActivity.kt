package com.example.debugsample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val editTextId = intArrayOf(// 数値入力用EditTextのid配列
        R.id.editText1,
        R.id.editText2,
        R.id.editText3,
        R.id.editText4,
        R.id.editText5
    )
    private var editText = arrayOfNulls<EditText>(editTextId.size)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // アクティビティにレイアウトを設定
        setContentView(R.layout.debug_sample)

        // XML定義のビューを取得
        for(i in editTextId.indices){
            editText[i] = findViewById(editTextId[i])
        }
        var button1 = findViewById<Button>(R.id.button)
        var button2 = findViewById<Button>(R.id.button2)
        var textView1 = findViewById<TextView>(R.id.textView1)
        var textView2 = findViewById<TextView>(R.id.textView2)

        // ボタン　クリック時の処理
        // 合計ボタン 合計処理
        button1.setOnClickListener{
            val ret = calcSum()
            textView1.text = ret.toString()
        }

        // 平均ボタン 平均処理
        button2.setOnClickListener{
            val ret = calcAverage()
            textView2.text = ret.toString()
        }

    }

    // 合計計算
    private fun calcSum(): Int{
        var total = 0 // 合計格納変数
        // 累計処理
        for(i in editTextId.indices){
            total += Integer.parseInt(editText[i]?.text.toString())
        }
        return total
    }

    // 平均計算
    private fun calcAverage(): Int{
        return calcSum()/ editTextId.size
    }
}