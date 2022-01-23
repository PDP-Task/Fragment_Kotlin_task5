package com.example.fragment_kotlin_task5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_kotlin_task5.R
import com.example.fragment_kotlin_task5.adapter.ContactAdapter
import com.example.fragment_kotlin_task5.model.Contact

class ContactFragment : Fragment() {

    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private var contactList = ArrayList<Contact>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_contact)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        contactAdapter = ContactAdapter(arrayList())
        recyclerView.adapter = contactAdapter
    }

    private fun arrayList(): ArrayList<Contact> {
        val contactList = ArrayList<Contact>()

        for (i in 10..50) {
            when {
                i % 5 == 0 -> {
                    contactList.add(Contact("Android", "+998 95 123 45 $i"))
                }
                i % 3 == 0 -> {
                    contactList.add(Contact("Java", "+998 $i 987 65 43"))
                }
                else -> {
                    contactList.add(Contact("Kotlin", "+998 97 777 $i 00"))
                }
            }
        }
        return contactList
    }
}