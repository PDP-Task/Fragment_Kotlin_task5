package com.example.fragment_kotlin_task5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_kotlin_task5.R
import com.example.fragment_kotlin_task5.adapter.PostAdapter
import com.example.fragment_kotlin_task5.model.Post
import com.example.fragment_kotlin_task5.util.Time

class PostFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private var postList = ArrayList<Post>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_post, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_post)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        postAdapter = PostAdapter(postList())

        recyclerView.adapter = postAdapter
    }

    private fun postList(): ArrayList<Post> {
        val currentTime = Time.timeStamp()
        postList.add(Post("PDP Academy", currentTime, R.drawable.pdp_ac))
        postList.add(Post("Google", currentTime, R.drawable.ggole))
        postList.add(Post("Pinterest", currentTime, R.drawable.pin))
        postList.add(Post("Instagram", currentTime, R.drawable.im_instagram))
        postList.add(Post("Telegram", currentTime, R.drawable.tg))
        postList.add(Post("What's app", currentTime, R.drawable.wha))
        postList.add(Post("Tik Tok", currentTime, R.drawable.tik))
        postList.add(Post("Facebook", currentTime, R.drawable.yumaloqface))
        postList.add(Post("Twitter", currentTime, R.drawable.twitter))
        postList.add(Post("Meta", currentTime, R.drawable.meta))

        return postList
    }
}