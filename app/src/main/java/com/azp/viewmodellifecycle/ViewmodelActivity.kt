package com.azp.viewmodellifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.azp.viewmodellifecycle.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ViewmodelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        var countViewModel = ViewModelProvider(this)
            .get(CountViewModel::class.java)

        txtCount.text = countViewModel.getCount().toString()

        btnCount.setOnClickListener {
            countViewModel.setCount()

            txtCount.text = countViewModel.getCount().toString()

        }

    }
}
