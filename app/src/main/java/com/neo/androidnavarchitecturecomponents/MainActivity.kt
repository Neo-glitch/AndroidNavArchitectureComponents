package com.neo.androidnavarchitecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/**
 * Host Activity in nav graph
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}