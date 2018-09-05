package com.leo.test

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.leo.test.base.BaseViewModel
import com.leo.test.data.dao.load.CategoriesDao
import com.leo.test.data.http.TaskClouds
import com.leo.test.data.rx.AbstractSingleHttp

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
class MainViewModel : BaseViewModel() {

    var categoryData = MutableLiveData<CategoriesDao>()

    fun getCategories() {
        TaskClouds.getCategories()
                .subscribe(object : AbstractSingleHttp<CategoriesDao>() {
                    override fun onSuccess(t: CategoriesDao) {
                        Log.i("getData", "onSuccess")
                        categoryData.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.i("getData", "onError")
                        categoryData.value = null
                        e.printStackTrace()
                    }

                })
    }


}