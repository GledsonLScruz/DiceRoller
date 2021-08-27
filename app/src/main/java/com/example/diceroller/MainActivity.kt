package com.example.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show()

        //Declare animation and views
        val ttb = AnimationUtils.loadAnimation(this,R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)
        val rollButton : Button = findViewById(R.id.rollbutton)
        val diceImage: ImageView = findViewById(R.id.diceImage)

        //set Animation and functions
        diceImage.startAnimation(stb)
        rollButton.startAnimation(ttb)
        rollButton.setOnClickListener{
            rollDice()
            val shake = AnimationUtils.loadAnimation(this,R.anim.shake)
            diceImage.startAnimation(shake)}

        rollDice()

    }
    //fun of the dice
    private fun rollDice(){

        val dice = Dice(6)
        val roll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.diceImage)
        when(roll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    //instructions to make the dice
    class Dice(private val numSides: Int){
        fun roll(): Int{
            return (1..numSides).random()
        }
    }
}

