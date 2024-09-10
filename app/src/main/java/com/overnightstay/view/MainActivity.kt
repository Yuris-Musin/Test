package com.overnightstay.view

import android.animation.ValueAnimator
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.overnightstay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var array = mutableListOf("Привет!\nЯ - кот Статус, расскажу, что тебя ждет в игре.\nСейчас я работаю волонтером в Ночлежке.",
        "Но так было не всегда...\nПару лет назад я потерял все",
        "В ночлежке мне помогли.\nТеперь у меня есть дом",
        "Ночлежка - это благотворительная общественная организация. Наша цель -\nреабилитация бездомных людей и профилактика бездомности, основанная на\nпринципах гуманности, добровольности, уважения личности и ее прав.",
        "Ночлежка с 1990 года кормит, обогревает, помогает с документами, работой,\nоформлением инвалидностей, пособий, устройством в интернаты, в поиске\nродственников и отъезде домой, оспаривает незаконные сделки с недвижимостью.",
        "Давай сначала я покажу тебе что и как здесь все работает",
        "Смотри...\nШестеренка - это твой профиль. Здесь ты можешь поменять имя, пароль",
        "И в любой момент ты можешь выключить звук. Эта функция находится внутри\nшестеренки",
        "А теперь познакомлю тебя с нашими проектами.\nИди за мной")
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.text.animateCharacterByCharacter(array[count], 60L)
        binding.dialogNext.setOnClickListener{
            count++
            binding.text.animateCharacterByCharacter(array[count], 70L)
        }

    }

    private fun TextView.animateCharacterByCharacter(text: String, delay: Long = 33L) {
        if (text.isEmpty()) return

        val charAnimation = ValueAnimator.ofInt(0, text.length)

        charAnimation.apply {
            this.duration = delay * text.length.toLong()
            this.repeatCount = 0
            addUpdateListener {
                val charCount = it.animatedValue as Int
                val animatedText = text.substring(0, charCount)
                this@animateCharacterByCharacter.text = animatedText
            }
        }

        charAnimation.start()
    }

}