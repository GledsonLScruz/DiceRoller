package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declare animation and views
        val ttb = AnimationUtils.loadAnimation(this,R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)

        val logo = findViewById(R.id.logo) as ImageView
        val rollButton: Button = findViewById(R.id.button)
        val diceImage: ImageView = findViewById(R.id.imageView)


        //Set The Animation and click button
        logo.startAnimation(ttb)
        rollButton.startAnimation(stb)
        diceImage.startAnimation(stb)

        rollButton.setOnClickListener {rollDice()}

        rollDice()
    }


    //Object The Dice
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

    }

    //Plant The Dice
    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}

