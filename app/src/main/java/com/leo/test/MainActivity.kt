package com.leo.test

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.leo.test.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.categoryData.observe(this, Observer {
            if (it != null) {
                Log.i("observe", "" + it)
            } else {
                Log.i("observe", "no data")
            }
        })

        viewModel.getCategories()
    }
}
