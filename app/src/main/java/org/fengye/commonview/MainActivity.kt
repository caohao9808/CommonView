package org.fengye.commonview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.fengye.commonview.databinding.ActivityMainBinding
import org.fengye.commonview.lib.scrollpicker.DatePickerAdapter
import org.fengye.commonview.lib.scrollpicker.PickAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.yearPicker.setAdapter(DatePickerAdapter(1, 10))
    }
}