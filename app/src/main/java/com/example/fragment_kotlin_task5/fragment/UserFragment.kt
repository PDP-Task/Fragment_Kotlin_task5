package com.example.fragment_kotlin_task5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_kotlin_task5.R
import com.example.fragment_kotlin_task5.adapter.UserAdapter
import com.example.fragment_kotlin_task5.model.User

class UserFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private var userList = ArrayList<User>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_user)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        userAdapter = UserAdapter(userList())
        recyclerView.adapter = userAdapter
    }

    private fun userList(): ArrayList<User> {
        userList.add(User("Benzema", "Bonjour", R.drawable.benzema))
        userList.add(User("Kane", "Hello", R.drawable.kane))
        userList.add(User("Ronaldo", "Olá", R.drawable.ronaldo))
        userList.add(User("Holland", "Hei der", R.drawable.holland))
        userList.add(User("Son", "Annyong", R.drawable.son))
        userList.add(User("Messi", "Hola", R.drawable.messi))
        userList.add(User("Mbappe", "Bonjour", R.drawable.mpabbe))
        userList.add(User("Salah", "Assalamu Alaykum", R.drawable.salah))
        userList.add(User("Neymar", "Olá", R.drawable.neymar))

        return userList
    }
}