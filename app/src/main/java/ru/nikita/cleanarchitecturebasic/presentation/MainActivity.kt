package ru.nikita.cleanarchitecturebasic.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.koin.androidx.viewmodel.ext.android.viewModel


import ru.nikita.cleanarchitecturebasic.R

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MyLog", "Activity created")

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        //Отписка происходит автоматически в onDestroy
        // подписка onResume в отписка onPause
        viewModel.stateLive.observe(this) { state ->
            dataTextView.text = "${state.firstName} ${state.lastName} ${state.saveResult}"
        }


        sendButton.setOnClickListener {
            //клик по кнопке Save Data
            val text = dataEditText.text.toString()
            viewModel.send(SaveEvent(text = text))
        }

        receiveButton.setOnClickListener {
            //клик по кнопке Get Data
            viewModel.send(LoadEvent())
        }
    }
}