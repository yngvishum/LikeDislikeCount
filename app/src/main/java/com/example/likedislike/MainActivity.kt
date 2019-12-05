package com.example.likedislike

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Module-level variable
    //var like: Int = 0
    //var dislike: Int = 0
    lateinit var counterViewModel: CounterViewModel
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")


        //Initialize the counter ViewModel
        counterViewModel = ViewModelProviders.of(this)
            .get(CounterViewModel::class.java)

        //Initialize the shared preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)


        //Like
        textViewLike.text = counterViewModel.likeCount.toString()

        imageViewLike.setOnClickListener{
            counterViewModel.incrementLike()
            textViewLike.text = counterViewModel.likeCount.toString()
        }
        //End Like

        //Dislike

        textViewDislike.text = counterViewModel.dislikeCount.toString()

        imageViewDislike.setOnClickListener{
            counterViewModel.incrementDislike()
            textViewDislike.text = counterViewModel.dislikeCount.toString()
        }
        //End Dislike

    }

    override fun onStart() {
        Log.d("MainActivity", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume")
        val like = sharedPreferences.getInt(getString(R.string.like), 0)
        counterViewModel.likeCount = like

        val dislike = sharedPreferences.getInt(getString(R.string.dislike), 0)
        counterViewModel.dislikeCount = dislike


        textViewLike.text = counterViewModel.likeCount.toString()
        textViewDislike.text = counterViewModel.dislikeCount.toString()
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like), counterViewModel.likeCount)
            putInt(getString(R.string.dislike), counterViewModel.dislikeCount)
            apply()
        }
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }


}
