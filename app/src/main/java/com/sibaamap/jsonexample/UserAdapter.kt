package com.sibaamap.jsonexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sibaamap.jsonexample.Model.UserModelClass



class UserAdapter (val context: Context, val items: ArrayList<UserModelClass>):
        RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user_layout,parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val items = items.get(position)

        holder.tvId.text = items.id.toString()
        holder.tvName.text = items.name
        holder.tvEmail.text = items.email
        holder.tvGender.text = items.gender
        holder.tvWeight.text = items.weight.toString()
        holder.tvHeight.text = items.height.toString()
        holder.tvMobileNumber.text = items.phone.mobile
        holder.tvOfficeNumber.text = items.phone.office

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {

        val tvId = view.findViewById<TextView>(R.id.tv_id)
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvEmail = view.findViewById<TextView>(R.id.tv_email)
        val tvGender = view.findViewById<TextView>(R.id.tv_gender)
        val tvWeight = view.findViewById<TextView>(R.id.tv_weight)
        val tvHeight = view.findViewById<TextView>(R.id.tv_height)
        val tvMobileNumber = view.findViewById<TextView>(R.id.tv_mobile)
        val tvOfficeNumber = view.findViewById<TextView>(R.id.tv_office_number)

    }

}