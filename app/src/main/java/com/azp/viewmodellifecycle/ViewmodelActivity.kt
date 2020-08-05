package com.azp.viewmodellifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.azp.viewmodellifecycle.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_viewmodel.*

class ViewmodelActivity : AppCompatActivity() {

    val sharedFile = "SHARED_PREFERENCED"
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null
    lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        countViewModel = ViewModelProvider(this)
            .get(CountViewModel::class.java)

        sharedPreferences = this.getSharedPreferences(
            sharedFile, Context.MODE_PRIVATE
        )

        editor = sharedPreferences?.edit()

        var storedCount = sharedPreferences?.getInt("COUNT", 0)
        txtCount.text = storedCount.toString()

        btnCount.setOnClickListener {
            var count = txtCount.text.toString().toInt()
            countViewModel.setCount(count)  //2

            txtCount.text = countViewModel.getCount().toString()
        }
    }

    override fun onPause() {
        super.onPause()
        editor?.putInt("COUNT", countViewModel.getCount())
        editor?.apply()
    }
}
