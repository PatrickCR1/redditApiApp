package com.example.redditapp.ui.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.redditapp.R
import com.example.redditapp.databinding.ActivityMainBinding
import com.example.redditapp.ui.viewmodel.RedditListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // ViewModel & Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel & Bindind
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
