package com.example.beautysalon.ui.searchMaster

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.Master
import com.example.beautysalon.R
import com.example.beautysalon.interfaces.OnItemClickListener

class SearchMasterFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences.Editor
    private lateinit var searchMasterViewModel: SearchMasterViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchMasterViewModel =
            ViewModelProvider(this).get(SearchMasterViewModel::class.java)
        return inflater.inflate(R.layout.fragment_search_master, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentMaster: List<Master> = arguments?.get("master") as List<Master>

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(
            object : OnItemClickListener {
                override fun onItemClicked(position: Int, any: Any?) {
                    sharedPreferences = requireContext().getSharedPreferences(
                        "UserPreference",
                        AppCompatActivity.MODE_PRIVATE
                    ).edit()
                    sharedPreferences.apply { putString("MASTER", currentMaster[position].name) }
                        .apply()

                    NavHostFragment.findNavController(view.findFragment()).navigate(
                        R.id.action_navigation_search_master_to_recordFragment,
                        bundleOf("master" to currentMaster[position].recordsTime),
                    )
                }
            },
            currentMaster
        )
    }
}