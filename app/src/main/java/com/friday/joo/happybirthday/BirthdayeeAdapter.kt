package com.friday.joo.happybirthday

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_birthdayee.view.*
import java.util.*

class BirthdayeeAdapter(
        private val birthdayeeList: List<Birthdayee>
) : RecyclerView.Adapter<BirthdayeeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_birthdayee, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return birthdayeeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val birthdayee = birthdayeeList[position]
        Glide.with(holder.itemView.context)
                .load(birthdayee.profileUrl)
                .into(holder.itemView.profile)
        holder.itemView.birthdayeeName.text = birthdayee.name
        holder.itemView.birthdayeeDate.text = birthdayee.date.let { Date(it).toString() }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}