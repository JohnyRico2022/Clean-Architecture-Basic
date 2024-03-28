package ru.nikita.cleanarchitecturebasic.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import ru.nikita.cleanarchitecturebasic.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MyLog", "Activity created")

        // создание VM  с помощью Фабрики. Можно проще: Выше дописать by viewModel
        viewModel = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        //Отписка происходит автоматически в onDestroy
        // подписка onResume в отписка onPause
        viewModel.resultLive.observe(this) { text ->
            dataTextView.text = text
        }

        sendButton.setOnClickListener {
            //клик по кнопке Save Data
            val text = dataEditText.text.toString()
            viewModel.save(text)
        }

        receiveButton.setOnClickListener {
            //клик по кнопке Get Data
            viewModel.load()
        }
    }
}