package com.example.mobilephonecatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilephonecatalog.adapter.Adapter
import com.example.mobilephonecatalog.data.ItemMobile
import com.example.mobilephonecatalog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val requestCode = 10

    var listPhones = mutableListOf<ItemMobile>()

    lateinit var mobileAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == requestCode && resultCode == RESULT_OK)
//
    }

    fun btnAdd(view: View) {
        val intent = Intent(this, AddNewPhone::class.java)
        startActivityForResult(intent, requestCode)
    }
}