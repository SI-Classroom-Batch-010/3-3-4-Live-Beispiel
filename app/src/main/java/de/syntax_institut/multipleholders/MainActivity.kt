package de.syntax_institut.multipleholders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.syntax_institut.multipleholders.adapter.MessageAdapter
import de.syntax_institut.multipleholders.data.DataSource
import de.syntax_institut.multipleholders.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val messages = DataSource().loadMessages()

        val recView = binding.rvMessages

        recView.adapter = MessageAdapter(messages)
        recView.setHasFixedSize(true)



    }
}