package com.example.mobilephonecatalog.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilephonecatalog.R
import com.example.mobilephonecatalog.data.ItemMobile
import com.example.mobilephonecatalog.databinding.PhoneItemBinding


class Adapter(var list: List<ItemMobile>) : RecyclerView.Adapter<Adapter.MyHolder>() {

    inner class MyHolder(val phoneItemBinding: PhoneItemBinding) : RecyclerView.ViewHolder(phoneItemBinding.root) {

        fun bind(mobile: ItemMobile) {
            phoneItemBinding.editBrand.setText(mobile.brand)
            phoneItemBinding.editModel.setText(mobile.model)
            phoneItemBinding.etOC.setText(mobile.oc)
            phoneItemBinding.editImage.setImageDrawable(mobile.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemMobileBinding = PhoneItemBinding.inflate(inflater, parent, false)
        return MyHolder(itemMobileBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(list[position])
    }
}
