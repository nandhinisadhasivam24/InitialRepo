package com.example.sampledependencyinjection

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        val textView = findViewById<TextView>(R.id.textView)
        viewModel.users.observe(this, Observer { users ->
            Toast.makeText(this, "Fetched ${users.size} users", Toast.LENGTH_LONG).show()
            Log.d("", "onCreate: "+users.size)
        })

       viewModel.fetchUsers()
    }
}


