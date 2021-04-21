package com.example.beautysalon.ui.search

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.beautysalon.*


class SearchFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences.Editor
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var myView: View
    private var service: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myView = view
        //TODO
        val image = resources.getDrawable(R.drawable.ic_notifications_black_24dp)
        getService()
        view.findViewById<Button>(R.id.button).setOnClickListener {
            val currentMaster = if (isMasterOne() && isMasterTwo()) {
                createListMaster(listOf(image, image))
            } else if (isMasterOne()) {
                createListMasterOne(image)
            } else if (isMasterTwo()) {
                createListMasterTwo(image)
            } else {
                null
            }

            if (currentMaster == null) {
                Toast.makeText(requireContext(), "Выберите услугу", Toast.LENGTH_SHORT).show()
            } else {
                sharedPreferences = requireContext().getSharedPreferences(
                    "UserPreference",
                    AppCompatActivity.MODE_PRIVATE
                ).edit()
                sharedPreferences.apply { putString("SERVICE", service) }.apply()

                NavHostFragment.findNavController(view.findFragment()).navigate(
                    R.id.action_navigation_search_to_navigation_search_master,
                    bundleOf("master" to currentMaster)
                )
            }
        }
    }

    private fun getService() {
        myView.findViewById<RadioGroup>(R.id.radioGroup).setOnCheckedChangeListener { _, checkedId ->
            service = when (checkedId) {
                R.id.check1 -> getRadioButton(R.id.check1).text.toString()
                R.id.check2 -> getRadioButton(R.id.check2).text.toString()
                R.id.check3 -> getRadioButton(R.id.check3).text.toString()
                R.id.check4 -> getRadioButton(R.id.check4).text.toString()
                R.id.check5 -> getRadioButton(R.id.check5).text.toString()
                R.id.check6 -> getRadioButton(R.id.check6).text.toString()
                R.id.check7 -> getRadioButton(R.id.check7).text.toString()
                R.id.check8 -> getRadioButton(R.id.check8).text.toString()
                R.id.check9 -> getRadioButton(R.id.check9).text.toString()
                R.id.check10 -> getRadioButton(R.id.check10).text.toString()
                R.id.check11 -> getRadioButton(R.id.check11).text.toString()
                R.id.check12 -> getRadioButton(R.id.check12).text.toString()
                else -> getRadioButton(R.id.check1).text.toString()
            }
        }
    }


    private fun isMasterOne() = idCheck(R.id.check1) ||
            idCheck(R.id.check2) ||
            idCheck(R.id.check3) ||
            idCheck(R.id.check4) ||
            idCheck(R.id.check5) ||
            idCheck(R.id.check6)

    private fun isMasterTwo() = idCheck(R.id.check7) ||
            idCheck(R.id.check8) ||
            idCheck(R.id.check9) ||
            idCheck(R.id.check10) ||
            idCheck(R.id.check11) ||
            idCheck(R.id.check12)

    private fun idCheck(check: Int) = getRadioButton(check).isChecked

    private fun getRadioButton(check: Int) = myView.findViewById<RadioButton>(check)
}