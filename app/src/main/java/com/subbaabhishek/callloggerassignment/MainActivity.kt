package com.subbaabhishek.callloggerassignment

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.subbaabhishek.callloggerassignment.adapters.CallLogRecyclerAdapter
import com.subbaabhishek.callloggerassignment.model.CallLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val callLogExampleList: List<CallLog> = arrayListOf(
            CallLog(
                "+91987654321",
                "From: +9112345678",
                "Date: Tuesday 12 September 2023 11:12:26 | Dur: 88s",
                "filename.mp3",
                true
            ),
            CallLog(
                "+91987654321",
                "From: +9112345678",
                "Date: Tuesday 12 September 2023 11:09:26 | Dur: 7s",
                "filename.mp3",
               false
            ),
        )
        val rv = findViewById<RecyclerView>(R.id.call_log_rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = CallLogRecyclerAdapter(callLogExampleList)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_LONG).show()
                true
            }

            R.id.refresh -> {
                Toast.makeText(this, "Refresh clicked", Toast.LENGTH_LONG).show()
                true
            }

            else ->
                return super.onOptionsItemSelected(item)
        }
    }
}