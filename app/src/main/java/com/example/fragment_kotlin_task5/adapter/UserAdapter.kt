package com.example.fragment_kotlin_task5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_kotlin_task5.R
import com.example.fragment_kotlin_task5.model.User

class UserAdapter(private val userList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = userList[position]

        if (holder is UserViewHolder) {
            holder.apply {
                title.text = user.title
                des.text = user.description
                imageView.setImageResource(user.image)
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.text_title_user)
        val des: TextView = view.findViewById(R.id.text_des_user)
        val imageView: ImageView = view.findViewById(R.id.image_item_user)
    }
}