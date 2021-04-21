package com.example.beautysalon.ui.record

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import com.example.beautysalon.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class RecordFragment : Fragment() {
    private lateinit var myView: View
    private lateinit var sharedPreferences: SharedPreferences.Editor
    private lateinit var date: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_record, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myView = view

        val recordsTime: List<String> = arguments?.get("master") as List<String>
        getCheckBox(R.id.time1).text = recordsTime[0]
        getCheckBox(R.id.time2).text = recordsTime[1]
        getCheckBox(R.id.time3).text = recordsTime[2]
        getCheckBox(R.id.time4).text = recordsTime[3]
        getCheckBox(R.id.time5).text = recordsTime[4]
        getCheckBox(R.id.time6).text = recordsTime[5]


        getDate()
        initListeners()
    }

    private fun initListeners() {
        myView.findViewById<Button>(R.id.buttonRecord).setOnClickListener {
            sharedPreferences = requireContext().getSharedPreferences(
                "UserPreference",
                AppCompatActivity.MODE_PRIVATE
            ).edit()

            sharedPreferences.apply {
                when {
                    isChecked(R.id.time1) -> putString("TIME", getStringTime(R.id.time1))
                    isChecked(R.id.time2) -> putString("TIME", getStringTime(R.id.time2))
                    isChecked(R.id.time3) -> putString("TIME", getStringTime(R.id.time3))
                    isChecked(R.id.time4) -> putString("TIME", getStringTime(R.id.time4))
                    isChecked(R.id.time5) -> putString("TIME", getStringTime(R.id.time5))
                    isChecked(R.id.time6) -> putString("TIME", getStringTime(R.id.time6))
                    else -> putString("TIME", getStringTime(R.id.time1))
                }
            }.apply()

            NavHostFragment.findNavController(myView.findFragment()).navigate(
                R.id.action_recordFragment_to_profileFragment
            )

            Toast.makeText(requireContext(), "Вы звписались к мастеру на ${getStringTime(R.id.time1)}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun getStringTime(check: Int) = "$date, ${getCheckBox(check).text}"


    private fun getDate() {
        val calendarView = myView.findViewById<CalendarView>(R.id.calendarView)
        val dateFormat: DateFormat = SimpleDateFormat("dd.M", Locale.getDefault())
        date = dateFormat.format(Date())

        calendarView.setOnDateChangeListener { _, _, month, dayOfMonth ->
            date = "$dayOfMonth, ${month + 1}"
        }
    }

    private fun getCheckBox(check: Int) = myView.findViewById<RadioButton>(check)

    private fun isChecked(check: Int) = getCheckBox(check).isChecked
}