package com.example.fragment_kotlin_task5.util

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object Time {

    fun timeStamp(): String {
        val timeStamp = Timestamp(System.currentTimeMillis())
        val msh = SimpleDateFormat("HH:mm")
        val time = msh.format(Date(timeStamp.time))

        return time.toString()
    }
}