package com.example.mobilephonecatalog

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilephonecatalog.adapter.Adapter
import com.example.mobilephonecatalog.data.ItemMobile
import com.example.mobilephonecatalog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val REQUEST_CODE = 10

    var listPhones = mutableListOf<ItemMobile>()

    lateinit var mobileAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mobileAdapter = Adapter(listPhones)
        binding.rvListPhone.adapter = mobileAdapter
        binding.rvListPhone.layoutManager = LinearLayoutManager(this)

        binding.btnAdd.setOnClickListener {
            Intent(this, AddNewPhone::class.java).also { newIntent ->
                newIntent.putExtra("EXTRA_MODEL", "Phone")
                startActivityForResult(newIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let { result ->
                    val brand = result.getStringExtra("EXTRA_BRAND") ?: "Unknown"
                    val model = result.getStringExtra("EXTRA_MODEL") ?: "Unknown"
                    val oc = result.getStringExtra("EXTRA_OC") ?: "Unknown"
                    val imageUri = result.getStringExtra("EXTRA_URI")
                    var img: Drawable? = null
                    imageUri?.let { imgUri ->
                        img = uriToDrawable(imgUri)
                    }

                    val newPhone = ItemMobile(oc, brand, model, img)

                    listPhones.add(newPhone)
                    mobileAdapter.notifyItemInserted(listPhones.size - 1)
                }

            }
        }
    }

   private fun uriToDrawable(imageUri: String): Drawable {
        val inputStream = contentResolver.openInputStream(Uri.parse(imageUri))
        return Drawable.createFromStream(inputStream, imageUri)
    }
}
