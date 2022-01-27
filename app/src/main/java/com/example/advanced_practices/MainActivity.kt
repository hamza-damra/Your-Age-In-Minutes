package com.example.advanced_practices


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view->
            openCalendar(view)


        }

    }
    private fun openCalendar(view:View)
    {
        val myDate = Calendar.getInstance()
        val year = myDate.get(Calendar.YEAR)
        val month = myDate.get(Calendar.MONTH)
        val day = myDate.get(Calendar.DAY_OF_MONTH)
       val dpd =  DatePickerDialog(this,DatePickerDialog.OnDateSetListener {
        view, selectedYear, selectedMonth, selectedDayOfMonth ->
            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            tvSelectedDate.setText(selectedDate)
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val TheDate = sdf.parse(selectedDate)

           val selectedDateInMinutes = TheDate!!.time / 60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = currentDate!!.time / 60000
            val defferanceDate = currentDateInMinutes - selectedDateInMinutes
            tvSelectedDateInMinutes.setText(defferanceDate.toString())

        }

            ,year
            ,month
            ,day)



         dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()


    }


}
