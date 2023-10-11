package com.example.calorimonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.example.calorimonitoring.databinding.ActivityGetStartedBinding

class GetStartedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Isi Spinner dengan opsi tujuan diet
        val dietOptions = arrayOf("Cutting", "Bulking", "Maintaining")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dietOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDietGoal.adapter = adapter

        // Tindakan yang akan diambil saat item dipilih dalam Spinner
        binding.spinnerDietGoal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedDiet = parent.getItemAtPosition(position).toString()
                // Lakukan sesuatu dengan opsi yang dipilih (misalnya, simpan ke variabel atau tampilkan pesan)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle jika tidak ada yang dipilih
            }
        }

        // Tambahkan tindakan saat tombol "Mulai" diklik
        binding.btnStart.setOnClickListener {
            // Dapatkan nilai dari semua EditText
            val name = binding.edtName.text.toString()
            val currentWeight = binding.edtCurrentWeight.text.toString()
            val targetWeight = binding.edtTargetWeight.text.toString()
            val targetDate = binding.edtTargetDate.text.toString()
            val maxCalories = binding.edtMaxCalories.text.toString()

            // Lakukan sesuatu dengan data yang diambil dari EditText sesuai kebutuhan aplikasi Anda
        }
    }
}
