package com.example.debugsample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

// 高度なデバッグ  BMI計算
class DebugSample2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // アクティビティにレイアウトを設定
        setContentView(R.layout.debug_sample2)

        // XML定義のビューを取得
        var editText1 = findViewById<EditText>(R.id.height)
        var editText2 = findViewById<EditText>(R.id.weight)
        var button1 = findViewById<Button>(R.id.bmiButton)
        var textView1 = findViewById<TextView>(R.id.std)
        var textView2 = findViewById<TextView>(R.id.bmi)
        var textView3 = findViewById<TextView>(R.id.bmiString)

        // 計算ボタン BMI産出
        button1.setOnClickListener{
            // 変数の宣言　及び　計算処理
            var height = editText1.text.toString().toDouble() / 100.0 // 身長(m)
            var weight = editText2.text.toString().toDouble()
            var std = height * height * 22.0 // 標準体重 = 身長(m)×身長(m)×22
            var bmi = weight / (height * height) // BMI = 体重÷(身長(m)×身長(m))
            var bmiString = if(bmi<18.5) "低体重" // BMI判定
                            else if(bmi<25) "普通体重"
                            else if(bmi<30) "肥満_(1度)"
                            else if(bmi<35) "肥満_(2度)"
                            else if(bmi<40) "肥満_(3度)"
                            else "肥満_(4度)"
            // テキストビュー表示
            textView1.text = "標準体重:" + String.format("%.2f", std) + "kg"
            textView2.text = "BMI:" + String.format("%.2f", bmi)
            textView3.text = "BMI評価:" + bmiString
        }

        debugFunc1() // ブレークポイント 説明処理 1から1000までの累計


    }

    // ブレークポイント 説明処理 1から1000までの累計
    private fun debugFunc1(){
        var total = 0

        for(i in 1..1000){ // 1000回のループ
            total += i
        }

    }

}