package com.example.beautysalon.ui.searchMaster

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beautysalon.R
import com.example.beautysalon.interfaces.OnItemClickListener

class SearchMasterFragment : Fragment() {

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

       val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(object : OnItemClickListener {
            override fun onItemClicked(position: Int, any: Any?) {
                NavHostFragment.findNavController(view.findFragment()).navigate(
                    R.id.action_navigation_search_master_to_recordFragment
                )
            }
        })
    }
}