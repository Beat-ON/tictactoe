package com.beaton.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beaton.tictactoe.singleplayer.SinglePlayer
import com.beaton.tictactoe.twoplayer.MultyPlayer
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        sp.setOnClickListener{
            val intent = Intent(this, SinglePlayer::class.java)
            startActivity(intent)
        }
        mp.setOnClickListener{
            val intent = Intent(this, MultyPlayer::class.java)
            startActivity(intent)
        }
        options.setOnClickListener{
            val intent = Intent(this,Options::class.java)
            startActivity(intent)
        }
    }
}