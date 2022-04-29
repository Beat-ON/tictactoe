package com.beaton.tictactoe.twoplayer

import android.app.AlertDialog
import android.media.MediaPlayer
import android.util.Log
import android.widget.TextView
import com.beaton.tictactoe.R
import kotlinx.android.synthetic.main.activity_multy_player.drawutti
import kotlinx.android.synthetic.main.activity_multy_player.outti
import kotlinx.android.synthetic.main.activity_multy_player.text11
import kotlinx.android.synthetic.main.activity_multy_player.text12
import kotlinx.android.synthetic.main.activity_multy_player.text13
import kotlinx.android.synthetic.main.activity_multy_player.text21
import kotlinx.android.synthetic.main.activity_multy_player.text22
import kotlinx.android.synthetic.main.activity_multy_player.text23
import kotlinx.android.synthetic.main.activity_multy_player.text31
import kotlinx.android.synthetic.main.activity_multy_player.text32
import kotlinx.android.synthetic.main.activity_multy_player.text33
import kotlinx.android.synthetic.main.activity_multy_player.xutti

class LoadMultiPlayer(private var activity: MultyPlayer) {
    private var click = 1
    private var gamePanel = mutableListOf<MutableList<String>>()
    private var winners = ""
    private var xwinner = 0
    private var owinner = 0
    private var drawwinner = 0
    private var isShowDialog = false

    fun start() {
        fillGamePanel()
        setOnClickArea()
    }

    private fun check() {
        checkWinner()
        Log.d("Clickable", "$click")
        if (winners.isNotEmpty() && winners != "draw") {
            showDialog(winners)
        } else if (click == 10) {
            showDialog("draw")
            drawwinner++
            activity.drawutti.text = "$drawwinner"
        }
    }
    private fun showDialog(winnerin:String){
        var strr = winnerin
        strr = if(strr == "draw"){
            "Draw !!"
        }else {
            "$strr Victory!"
        }
        isShowDialog = true
        val dialogSound = MediaPlayer.create(activity, R.raw.open)
        dialogSound.start()
        val dialog = AlertDialog.Builder(activity)
            .setIcon(android.R.drawable.btn_star_big_on)
            .setTitle("Result")
            .setMessage(strr)
            .setPositiveButton("Reset", null)
            .show()
        val button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)

        button.setOnClickListener {
            dialog.dismiss()
            isShowDialog = false
            restart()
        }
    }

    private fun checkWinner() {
            if (checkColumn().winner == "X" || checkDiagonal().winner == "X" || checkRow().winner == "X") {
                winners= "X"
                xwinner++
            } else if (checkColumn().winner == "O" || checkDiagonal().winner == "O" || checkRow().winner == "O") {
                winners="O"
                owinner++
            } else if (checkColumn().winner == "draw" || checkDiagonal().winner == "draw" || checkRow().winner == "draw") {
                winners="draw"
                drawwinner++
            } else {
                winners=""
            }
        activity.xutti.text = "$xwinner"
        activity.outti.text = "$owinner"
        activity.drawutti.text = "$drawwinner"
    }
    private fun restart(){
        gamePanel.clear()
        winners=""
        fillGamePanel()
        click=1
        setTextOnTextViewsmp()

    }
    private fun setTextOnTextViewsmp(){
        activity.text11.text = ""
        activity.text12.text = ""
        activity.text13.text = ""
        activity.text21.text = ""
        activity.text22.text = ""
        activity.text23.text = ""
        activity.text31.text = ""
        activity.text32.text = ""
        activity.text33.text = ""
    }
    private fun viewFuncition(textView: TextView,row:Int,col:Int){
        if(textView.text.isEmpty()){
            val zapis = MediaPlayer.create(activity, R.raw.o_click)
            if(click%2==0){
                zapis.start()
                textView.text = "O"
            }else{
                val zapis2 = MediaPlayer.create(activity, R.raw.x_click)
                textView.text = "X"
                zapis2.start()
            }
            gamePanel[row][col] = textView.text.toString()
            click++
            check()
        }
    }

    private fun checkRow():Winner{
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

    private fun checkColumn():Winner{
        for (i in 0..2){
            val row = gamePanel[0][i]+gamePanel[1][i]+gamePanel[2][i]+""
            if(row.lowercase() == "xxx"){
                return Winner("X")
            }
            if(row.lowercase() == "ooo"){
                return Winner("O")
            }
        }
        return Winner("")
    }

    private fun checkDiagonal():Winner{
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

    private fun setOnClickArea(){
        activity.text11.setOnClickListener {
            viewFuncition(it as TextView,0,0)
        }
        activity.text12.setOnClickListener {
            viewFuncition(it as TextView,0,1)
        }
        activity.text13.setOnClickListener {
            viewFuncition(it as TextView,0,2)
        }
        activity.text21.setOnClickListener {
            viewFuncition(it as TextView,1,0)
        }
        activity.text22.setOnClickListener {
            viewFuncition(it as TextView,1,1)
        }
        activity.text23.setOnClickListener {
            viewFuncition(it as TextView,1,2)
        }
        activity.text31.setOnClickListener {
            viewFuncition(it as TextView,2,0)
        }
        activity.text32.setOnClickListener {
            viewFuncition(it as TextView,2,1)
        }
        activity.text33.setOnClickListener {
            viewFuncition(it as TextView,2,2)
        }
    }

    private fun fillGamePanel() {
        for (i in 0..2) {
            val list = mutableListOf<String>()
            for (j in 0..2) {
                list.add(" ")
            }
            gamePanel.add(list)
        }
    }


}