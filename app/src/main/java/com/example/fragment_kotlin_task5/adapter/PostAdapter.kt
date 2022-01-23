package com.example.fragment_kotlin_task5.adapter

import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.fragment_kotlin_task5.R
import com.example.fragment_kotlin_task5.model.Post

class PostAdapter(private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post = postList[position]

        if (holder is PostViewHolder) {
            holder.apply {
                title.text = post.title
                time.text = post.time
                roundImage.setImageResource(post.roundImage)
                middleImage.setImageResource(post.roundImage)
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_post)
        val time: TextView = view.findViewById(R.id.time_post)
        val roundImage: ImageView = view.findViewById(R.id.round_image_post)
        val middleImage: ImageView = view.findViewById(R.id.middle_image_post)
        val favorite: ImageButton = view.findViewById(R.id.favorite_like)
        val like: ImageButton = view.findViewById(R.id.like_post)
        val dislike: ImageButton = view.findViewById(R.id.dis_like_post)
        val lottieAnim: LottieAnimationView = view.findViewById(R.id.lottie_anim)

        init {
            favorite.setOnClickListener {
                favorite.setImageResource(R.drawable.ic_favorite_red)
                Handler(Looper.getMainLooper()).postDelayed({
                    lottieAnim.visibility = View.VISIBLE
                }, 300)
            }
            like.setOnClickListener {
                like.setImageResource(R.drawable.ic_thumb_up_yellow)
                dislike.setImageResource(R.drawable.ic_thumb_down)
            }
            dislike.setOnClickListener {
                like.setImageResource(R.drawable.ic_thumb_up)
                dislike.setImageResource(R.drawable.ic_thumb_down_yellow)
            }
        }
    }
}