package com.example.calorimonitoring

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calorimonitoring.databinding.ActivityHomescreenBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomescreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            val name = extras.getString(GetStartedActivity.EXTRA_NAME)
            val currentWeight = extras.getString(GetStartedActivity.EXTRA_CURRENT_WEIGHT)
            val currentWeightSatuan = extras.getString(GetStartedActivity.EXTRA_CURRENT_WEIGHT_SATUAN)
            val targetWeight = extras.getString(GetStartedActivity.EXTRA_TARGET_WEIGHT)
            val targetWeightSatuan = extras.getString(GetStartedActivity.EXTRA_TARGET_WEIGHT_SATUAN)
            val maxCalories = extras.getString(GetStartedActivity.EXTRA_CALORIES)
            val goals = extras.getStringArray(GetStartedActivity.EXTRA_GOALS)

            // Set text views in your layout with the retrieved data
            binding.txtCurrentWeight.text = "Current Weight: $currentWeight $currentWeightSatuan"
            binding.txtTargetWeight.text = "Target Weight: $targetWeight $targetWeightSatuan"
            binding.txtMaxCalories.text = "Max Calories: $maxCalories"


        }
    }
}











