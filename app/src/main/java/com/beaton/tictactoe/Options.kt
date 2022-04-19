package com.beaton.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_multy_player.*
import kotlinx.android.synthetic.main.activity_options.*

class Options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        black_button.setOnClickListener{
            options_main.setBackgroundColor(Color.BLACK)
            home_activity.setBackgroundColor(Color.BLACK)
            mp_activity.setBackgroundColor(Color.BLACK)
        }
        white_button.setOnClickListener{
            options_main.setBackgroundColor(Color.WHITE)
            home_activity.setBackgroundColor(Color.WHITE)
            mp_activity.setBackgroundColor(Color.WHITE)
        }
    }
}