package com.beaton.tictactoe.singleplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beaton.tictactoe.R

class SinglePlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_player)
        supportActionBar?.hide()
        val load = LoadSinglePlayer(this)
        load.start()
    }
}