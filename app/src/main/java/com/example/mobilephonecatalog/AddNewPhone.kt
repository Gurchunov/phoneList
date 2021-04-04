package com.example.mobilephonecatalog

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mobilephonecatalog.databinding.ActivityAddNewPhoneBinding
import com.example.mobilephonecatalog.databinding.ActivityMainBinding

class AddNewPhone : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewPhoneBinding

    val IMAGE_CODE = 1

    var imgUri: Uri? = null

    lateinit var THE_CHOICE_OC: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            Intent().apply {
                putExtra("EXTRA_BRAND", binding.fieldBrand.text.toString())
                putExtra("EXTRA_MODEL", binding.fieldModel.text.toString())
                putExtra("EXTRA_OC", THE_CHOICE_OC)
                putExtra("EXTRA_URI", imgUri.toString())

                setResult(Activity.RESULT_OK, this)
                finish()
            }
        }
        binding.btnImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_CODE)
        }
    }



//    fun Android(view: View) {
//     THE_CHOICE_OC =  binding.btnAndroid.toString()
//    }

}