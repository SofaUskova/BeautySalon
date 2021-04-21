package com.example.beautysalon.ui.profile

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.R

class ProfileFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO фото профиля
        sharedPreferences =
            requireActivity().getSharedPreferences("UserPreference", AppCompatActivity.MODE_PRIVATE)
        view.findViewById<TextView>(R.id.textProfileName).text =
            sharedPreferences.getString("NAME", "")
        view.findViewById<TextView>(R.id.textProfilePhone).text =
            sharedPreferences.getString("PHONE", "")

        //TODO записи
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapterProfile(
            sharedPreferences.getString("MASTER", "") ?: "",
            sharedPreferences.getString("SERVICE", "") ?: "",
            sharedPreferences.getString("TIME", "") ?: ""
        )
    }
}