package com.beaton.tictactoe.twoplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beaton.tictactoe.R

class MultyPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multy_player)
        supportActionBar?.hide()
        val load = LoadMultiPlayer(this)
        load.start()
    }
}