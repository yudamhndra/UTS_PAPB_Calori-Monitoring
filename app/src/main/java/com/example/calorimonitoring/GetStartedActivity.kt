package com.example.calorimonitoring

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calorimonitoring.databinding.ActivityGetStartedBinding
import java.util.Calendar

class GetStartedActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var binding: ActivityGetStartedBinding

    private val satuanBeratBadan = arrayOf(
        "Kg",
        "Pound"
    )
    private val goals = arrayOf(
        "Bulk",
        "Maintain",
        "Cut"
    )

    companion object {
        const val EXTRA_NAME = "name"
        const val EXTRA_CURRENT_WEIGHT = "cWeight"
        const val EXTRA_CURRENT_WEIGHT_SATUAN = "cWeightSatuan"
        const val EXTRA_TARGET_WEIGHT = "tWeight"
        const val EXTRA_TARGET_WEIGHT_SATUAN = "tWeightSatuan"
        const val EXTRA_CALORIES = "calories"
        const val EXTRA_GOALS = "goals"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, goals)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinnerDietGoal.adapter = adapter

        binding.spinnerDietGoal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedDiet = parent.getItemAtPosition(position).toString()
                // Lakukan sesuatu dengan opsi yang dipilih (misalnya, simpan ke variabel atau tampilkan pesan)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle jika tidak ada yang dipilih
            }
        }

        val adapterSatuanBerat = ArrayAdapter(this, android.R.layout.simple_spinner_item, satuanBeratBadan)
        adapterSatuanBerat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerSatuanBerat1.adapter = adapterSatuanBerat
        binding.spinnerSatuanBerat2.adapter = adapterSatuanBerat

        val intentToHome = Intent(this@GetStartedActivity, HomeActivity::class.java)

        binding.btnStart.setOnClickListener {
            val name = binding.edtName.text.toString()
            val cWeight = binding.edtCurrentWeight.text.toString()
            val cWeightSatuan = binding.spinnerSatuanBerat1.selectedItem.toString()
            val tWeight = binding.edtTargetWeight.text.toString()
            val tWeightSatuan = binding.spinnerSatuanBerat2.selectedItem.toString()
            val maxCalories = binding.edtMaxCalories.text.toString()

            if (name.isNotEmpty() && cWeight.isNotEmpty() && tWeight.isNotEmpty() && maxCalories.isNotEmpty()) {
                // Buat Intent untuk pindah ke HomeActivity
                val intent = Intent(this, HomeActivity::class.java)

                intentToHome.putExtra(EXTRA_NAME, name)
                intentToHome.putExtra(EXTRA_CURRENT_WEIGHT, cWeight)
                intentToHome.putExtra(EXTRA_CURRENT_WEIGHT_SATUAN, cWeightSatuan)
                intentToHome.putExtra(EXTRA_TARGET_WEIGHT, tWeight)
                intentToHome.putExtra(EXTRA_TARGET_WEIGHT_SATUAN, tWeightSatuan)
                intentToHome.putExtra(EXTRA_CALORIES, maxCalories)
                intentToHome.putExtra(EXTRA_GOALS, goals)

                startActivity(intentToHome)
            } else {
                Toast.makeText(this, "Harap isi semua bidang!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.edtTargetDate.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, this, year, month, day)
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = "$dayOfMonth/${month + 1}/$year"
        binding.edtTargetDate.setText(selectedDate)
    }
}
