package com.beaton.tictactoe.singleplayer

import android.app.AlertDialog
import android.media.MediaPlayer
import android.os.Handler
import android.widget.TextView
import com.beaton.tictactoe.R
import com.beaton.tictactoe.twoplayer.Winner
import kotlinx.android.synthetic.main.activity_single_player.*

class LoadSinglePlayer(private val activitySingle: SinglePlayer) {
    private var click = 1
    private var gamePanel = mutableListOf<MutableList<String>>()
    private var set = mutableSetOf(1,2,3,4,5,6,7,8,9)
    private var winner = ""
    private var isPlayerSet = false
    private var xWinCount = 0
    private var oWinCount = 0
    private var drawCount = 0
    private var isShowDialog = false

    fun start(){
        fillGamePanel()
        setOnClickArea()
    }

    private fun restart(){
        set = mutableSetOf(1,2,3,4,5,6,7,8,9)
        gamePanel.clear()
        winner=""
        fillGamePanel()
        click=1
        isPlayerSet = false
        setTextOnTextViews()
    }
    private fun setTextOnTextViews(){
        activitySingle.text11.text = ""
        activitySingle.text12.text = ""
        activitySingle.text13.text = ""
        activitySingle.text21.text = ""
        activitySingle.text22.text = ""
        activitySingle.text23.text = ""
        activitySingle.text31.text = ""
        activitySingle.text32.text = ""
        activitySingle.text33.text = ""
    }

    private fun clickView(view: TextView,x:Int,y:Int,number:Int){
        if(!isPlayerSet){
            val zapis = MediaPlayer.create(activitySingle, R.raw.x_click)
            zapis.start()
            if(view.text.toString().isEmpty()){
                if(click%2==0){
                    view.text = "O"
                }else{
                    view.text = "X"
                }
                gamePanel[x][y] = view.text.toString()
                click++
                check()
                set.remove(number)
                isPlayerSet = true
            }
        }
        if(isPlayerSet){
            Handler().postDelayed({
                randomComputer()
            }, 1000)
        }
    }

    private fun setOnClickArea(){
        activitySingle.text11.setOnClickListener {
            clickView(it as TextView,0,0,1)
        }
        activitySingle.text12.setOnClickListener {
            clickView(it as TextView,0,1,2)
        }
        activitySingle.text13.setOnClickListener {
            clickView(it as TextView,0,2,3)
        }
        activitySingle.text21.setOnClickListener {
            clickView(it as TextView,1,0,4)
        }
        activitySingle.text22.setOnClickListener {
            clickView(it as TextView,1,1,5)
        }
        activitySingle.text23.setOnClickListener {
            clickView(it as TextView,1,2,6)
        }
        activitySingle.text31.setOnClickListener {
            clickView(it as TextView,2,0,7)
        }
        activitySingle.text32.setOnClickListener {
            clickView(it as TextView,2,1,8)
        }
        activitySingle.text33.setOnClickListener {
            clickView(it as TextView,2,2,9)
        }
    }

    private fun randomComputer() {
        if(set.isNotEmpty() && !isShowDialog){
            val zapis = MediaPlayer.create(activitySingle,R.raw.o_click)
            zapis.start()
            when(set.random()){
                1 -> {
                    setRandomNumber(activitySingle.text11,0,0,1)
                }
                2 -> {
                    setRandomNumber(activitySingle.text12,0,1,2)
                }
                3 -> {
                    setRandomNumber(activitySingle.text13,0,2,3)
                }
                4 -> {
                    setRandomNumber(activitySingle.text21,1,0,4)
                }
                5 -> {
                    setRandomNumber(activitySingle.text22,1,1,5)
                }
                6 -> {
                    setRandomNumber(activitySingle.text23,1,2,6)
                }
                7 -> {
                    setRandomNumber(activitySingle.text31,2,0,7)
                }
                8 -> {
                    setRandomNumber(activitySingle.text32,2,1,8)
                }
                9 -> {
                    setRandomNumber(activitySingle.text33,2,2,9)
                }
            }
        }
    }
    private fun setRandomNumber(view:TextView,x:Int,y:Int,number:Int){
        if(click%2==0){
            view.text = "O"
        }else{
            view.text = "X"
        }
        isPlayerSet = false
        click++
        gamePanel[x][y] = view.text.toString()
        set.remove(number)
        check()
    }

    private fun check(){
        checkWinner()
        if(winner.isNotEmpty() && winner != "draw"){
            showDialog(winner)
        }else if(click == 10){
            showDialog("draw")
            drawCount++
            activitySingle.drawutti.text = "$drawCount"
        }
    }
    private fun showDialog(winnerin:String){
        var str = winnerin
        str = if(str == "draw"){
            "Draw !!"
        }else {
            "$str Victory!"
        }
        isShowDialog = true

        val winSound = MediaPlayer.create(activitySingle,R.raw.open)
        winSound.start()

        val dialog = AlertDialog.Builder(activitySingle)
            .setIcon(R.drawable.ic_launcher_background)
            .setTitle("Result")
            .setMessage(str)
            .setPositiveButton("Reset", null)
            .show()
        val button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)

        button.setOnClickListener {
            dialog.dismiss()
            isShowDialog = false
            restart()
        }
        activitySingle.xutti.text = "$xWinCount"
        activitySingle.outti.text = "$oWinCount"
    }

    private fun checkWinner(){
        winner = ""
        if(checkColumn().winner == "X" || checkDiagonal().winner == "X" || checkRow().winner == "X"){
            winner = "X"
            xWinCount++
        }else if(checkColumn().winner == "O" || checkDiagonal().winner == "O" || checkRow().winner == "O"){
            winner = "O"
            oWinCount++
        }else if(checkColumn().winner == "draw" || checkDiagonal().winner == "draw" || checkRow().winner == "draw"){
            winner = "draw"
            drawCount++
        }else{
            winner = ""
        }
    }

    private fun checkRow(): Winner {
        for (i in 0..2){
            val row = gamePanel[i][0]+gamePanel[i][1]+gamePanel[i][2]+""
            if(row.lowercase() == "xxx"){
                return Winner("X")
            }
            if(row.lowercase() == "ooo"){
                return Winner("O")
            }
        }
        return Winner("")
    }

    private fun checkColumn(): Winner {
        for (i in 0..2){
            val row = gamePanel[0][i]+gamePanel[1][i]+gamePanel[2][i]+""
            if(row.lowercase() == "xxx"){
                return Winner("X")
            }
            if(row.lowercase() == "ooo"){
                return Winner("O")
            }
        }
        if(set.isEmpty()){
            return Winner("")
        }else{
            return Winner("")
        }

    }

    private fun checkDiagonal(): Winner {
        val dl = gamePanel[0][0]+gamePanel[1][1]+gamePanel[2][2]
        if(dl.lowercase() == "xxx"){
            return Winner("X")
        }else if(dl.lowercase() == "ooo"){
            return Winner("O")
        }
        val dl1 = gamePanel[2][0]+gamePanel[1][1]+gamePanel[0][2]
        if(dl1.lowercase() == "xxx"){
            return Winner("X")
        }
        if(dl1.lowercase() == "ooo"){
            return Winner("O")
        }
        return Winner("")
    }

    private fun fillGamePanel() {
        for (i in 0..2){
            val list = mutableListOf<String>()
            for (j in 0..2){
                list.add(" ")
            }
            gamePanel.add(list)
        }
    }

}