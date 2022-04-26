package com.beaton.tictactoe.twoplayer

import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_multy_player.*

class LoadMultiPlayer(private var activity: MultyPlayer) {
    private var click = 1
    private var miss_click1 = 0
    private var miss_click2 = 0
    private var miss_click3 = 0
    private var miss_click4 = 0
    private var miss_click5 = 0
    private var miss_click6 = 0
    private var miss_click7 = 0
    private var miss_click8 = 0
    private var miss_click9 = 0
    private var gamePanel = mutableListOf<MutableList<String>>()
    private var winners = ""

    fun start(){
        fillGamePanel()
        setOnClickArea()
    }

    private fun check(){
        checkWinner()
        Log.d("Clickable","$click")
        if(winners.isNotEmpty() && winners != "draw"){
            Toast.makeText(activity, "$winners victory",Toast.LENGTH_SHORT).show()
        }else if(click == 10){
            Toast.makeText(activity,"Draw !!",Toast.LENGTH_LONG).show()
        }
    }

    private fun checkWinner(){
        winners = if(checkColumn().winner == "X" || checkDiagonal().winner == "X" || checkRow().winner == "X"){
            "X"
        }else if(checkColumn().winner == "O" || checkDiagonal().winner == "O" || checkRow().winner == "O"){
            "O"
        }else if(checkColumn().winner == "draw" || checkDiagonal().winner == "draw" || checkRow().winner == "draw"){
            "draw"
        }else{
            ""
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
    private fun setOnClickArea() {
        activity.text11.setOnClickListener {
            if (winners!="X" && winners !="O") {
                if (miss_click1 == 0) {
                    if (click % 2 == 0) {
                        activity.text11.text = "O"
                    } else {
                        activity.text11.text = "X"
                    }
                    gamePanel[0][0] = activity.text11.text.toString()
                    click++
                    check()
                }
                miss_click1++
            }else{
                activity.text11.setOnClickListener(null)
            }
        }
            activity.text12.setOnClickListener {
                if (winners != "X" && winners != "O") {
                    if (miss_click2 == 0) {
                        if (click % 2 == 0) {
                            activity.text12.text = "O"
                        } else {
                            activity.text12.text = "X"
                        }
                        gamePanel[0][1] = activity.text12.text.toString()
                        click++
                        check()
                    }
                    miss_click2++
                }else{
                    activity.text12.setOnClickListener(null)
                }
            }
            activity.text13.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click3 == 0) {
                    if (click % 2 == 0) {
                        activity.text13.text = "O"
                    } else {
                        activity.text13.text = "X"
                    }
                    gamePanel[0][2] = activity.text13.text.toString()
                    click++
                    check()
                }
                miss_click3++
            }else{
                    activity.text13.setOnClickListener(null)
                }
            }
            activity.text21.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click4 == 0) {
                    if (click % 2 == 0) {
                        activity.text21.text = "O"
                    } else {
                        activity.text21.text = "X"
                    }
                    gamePanel[1][0] = activity.text21.text.toString()
                    click++
                    check()
                }
                miss_click4++
            }else{
                    activity.text21.setOnClickListener(null)
                }
            }
            activity.text22.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click5 == 0) {
                    if (click % 2 == 0) {
                        activity.text22.text = "O"
                    } else {
                        activity.text22.text = "X"
                    }
                    gamePanel[1][1] = activity.text22.text.toString()
                    click++
                    check()
                }
                miss_click5++
            }else{
                    activity.text22.setOnClickListener(null)
                }
            }
            activity.text23.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click6 == 0) {
                    if (click % 2 == 0) {
                        activity.text23.text = "O"
                    } else {
                        activity.text23.text = "X"
                    }
                    gamePanel[1][2] = activity.text23.text.toString()
                    click++
                    check()
                }
                miss_click6++
            }else{
                    activity.text23.setOnClickListener(null)
                }
            }
            activity.text31.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click7 == 0) {
                    if (click % 2 == 0) {
                        activity.text31.text = "O"
                    } else {
                        activity.text31.text = "X"
                    }
                    gamePanel[2][0] = activity.text31.text.toString()
                    click++
                    check()
                }
                miss_click7++
            }else{
                    activity.text31.setOnClickListener(null)
                }
            }
            activity.text32.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click8 == 0) {
                    if (click % 2 == 0) {
                        activity.text32.text = "O"
                    } else {
                        activity.text32.text = "X"
                    }
                    gamePanel[2][1] = activity.text32.text.toString()
                    click++
                    check()
                }
                miss_click8++
            }else{
                    activity.text32.setOnClickListener(null)
                }
            }
            activity.text33.setOnClickListener {
                if (winners != "X" && winners != "O") {
                if (miss_click9 == 0) {
                    if (click % 2 == 0) {
                        activity.text33.text = "O"
                    } else {
                        activity.text33.text = "X"
                    }
                    gamePanel[2][2] = activity.text33.text.toString()
                    click++
                    check()
                }
                miss_click9++
            }else{
                    activity.text33.setOnClickListener(null)
                }
            }
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