package com.example.imagelist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imagelist.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        if (intent != null){
            val name = intent.getStringExtra("name")
            val date = intent.getStringExtra("date")
            val credit = intent.getStringExtra("credit")
            val image = intent.getIntExtra("image", R.drawable._0240728_202604)

            binding.detailName.text = name
            binding.detailDate.text = date
            binding.detailCredit.text = credit
            binding.detailImage.setImageResource(image)
        }

    }
}