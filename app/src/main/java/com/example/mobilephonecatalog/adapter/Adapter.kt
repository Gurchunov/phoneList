package com.example.mobilephonecatalog.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilephonecatalog.R
import com.example.mobilephonecatalog.data.ItemMobile


class Adapter(var list: List<ItemMobile>) : RecyclerView.Adapter<Adapter.MyHolder>() {


   inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context).
        inflate(R.layout.activity_edit_phone, parent, false)
        return MyHolder(inflater)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.itemView.apply {
            /*
            тут не могу понять почему не видит поля из activity_edit_phone.xml
             */



        }
    }
}
