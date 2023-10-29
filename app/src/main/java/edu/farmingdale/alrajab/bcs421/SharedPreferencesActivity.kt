package edu.farmingdale.alrajab.bcs421

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.farmingdale.alrajab.bcs421.databinding.ActivitySharedPreferencesBinding
class SharedPreferencesActivity  : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Saves the data to the devices SharedPreferences
        binding.saveButton.setOnClickListener {
            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()

            val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("firstName", firstName)
            editor.putString("lastName", lastName)
            editor.apply()
        }

        // Reads the  data from the devices SharedPreferences
        binding.readButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
            val firstName = sharedPreferences.getString("firstName", "")
            val lastName = sharedPreferences.getString("lastName", "")

            binding.resultTextView.text = "First Name: $firstName\nLast Name: $lastName"
        }
    }

}