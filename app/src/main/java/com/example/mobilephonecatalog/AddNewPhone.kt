package com.example.mobilephonecatalog

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.mobilephonecatalog.databinding.ActivityAddNewPhoneBinding
import com.example.mobilephonecatalog.databinding.ActivityMainBinding

class AddNewPhone : AppCompatActivity() {

    private lateinit var binding: ActivityAddNewPhoneBinding

    val IMAGE_CODE = 1

    var imgUri: Uri? = null

    var THE_CHOICE_OC: String? = null

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

                val selButtonId = binding.radioGroup.checkedRadioButtonId
                val interfaceValue = findViewById<RadioButton>(selButtonId).text
                putExtra("EXTRA_INTERFACE", interfaceValue)

                setResult(Activity.RESULT_OK, this)
                finish()
            }
        }
        binding.btnImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_CODE)
        }

        binding.rgOC.setOnCheckedChangeListener { group, checkedId ->
            val selRadioBtn = findViewById<RadioButton>(checkedId)
            val osValue = selRadioBtn.text
            THE_CHOICE_OC = osValue.toString()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == IMAGE_CODE) {
            imgUri = data?.data
            binding.btnImage.setImageURI(imgUri)
        }
        else{
            binding.btnImage.setImageURI(Uri.parse("@drawable/phone"))
        }
    }

}