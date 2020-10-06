package com.example.busfleets

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.busfleets.trainSchedule.ApplicationDatabase
import com.example.busfleets.trainSchedule.BussPassenger
import com.example.busfleets.trainSchedule.Schedule
import com.example.busfleets.ui.ScrollingFragment
import kotlinx.android.synthetic.main.activity_passengers.*

class PassengersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passengers)

        (this as AppCompatActivity).supportActionBar?.title = "Пассажиры"
        (this as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadRecyclerView()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun loadRecyclerView(){
        busy_places.layoutManager = LinearLayoutManager(this)
        free_places.layoutManager = LinearLayoutManager(this)
        var placeBusyList = mutableListOf(
            BussPassenger(name = "Aigerim", status = "OFFLINE", placeNum = 0, placeType = "нижний", placeIndex = "A"),
            BussPassenger(name = "Aikul", status = "OFFLINE", placeNum = 0, placeType = "верхний", placeIndex = "B"),
            BussPassenger(name = "Beksultan", status = "ONLINE", placeNum = 1, placeType = "нижний", placeIndex = "A"),
            BussPassenger(name = "Nurzhan", status = "ONLINE", placeNum = 1, placeType = "верхний", placeIndex = "B"),
            BussPassenger(name = "Maulen", status = "OFFLINE", placeNum = 2, placeType = "верхний", placeIndex = "A")
        )
        var placeFreeList = mutableListOf(
            BussPassenger(name = "no name", status = "no type", placeNum = 3, placeType = "нижний", placeIndex = "A"),
            BussPassenger(name = "no name", status = "no type", placeNum = 3, placeType = "верхний", placeIndex = "B"),
            BussPassenger(name = "no name", status = "no type", placeNum = 4, placeType = "нижний", placeIndex = "A"),
            BussPassenger(name = "no name", status = "no type", placeNum = 4, placeType = "верхний", placeIndex = "B"),
            BussPassenger(name = "no name", status = "no type", placeNum = 5, placeType = "нижний", placeIndex = "A"),
            BussPassenger(name = "no name", status = "no type", placeNum = 5, placeType = "верхний", placeIndex = "B"),
            BussPassenger(name = "no name", status = "no type", placeNum = 6, placeType = "нижний", placeIndex = "A"),
            BussPassenger(name = "no name", status = "no type", placeNum = 6, placeType = "верхний", placeIndex = "B")
        )


        busy_places.adapter = PassengerListAdapter(bussPassengerList = placeBusyList)
        free_places.adapter = PassengerListAdapter(bussPassengerList = placeFreeList)

    }
}