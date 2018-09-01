package com.leo.test

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.leo.test.base.BaseViewModel
import com.leo.test.data.dao.load.TaskModel
import com.leo.test.data.dao.up.PostTaskModel
import com.leo.test.data.http.TaskClouds
import com.leo.test.data.rx.AbstractSingleHttp

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
class MainViewModel : BaseViewModel() {

    var data = MutableLiveData<TaskModel>()

    public fun getData() {
        val postTaskModel = PostTaskModel("123456789", "123456")

        TaskClouds.getTaskData(postTaskModel).subscribe(object : AbstractSingleHttp<TaskModel>() {
            override fun onSuccess(task: TaskModel) {
                Log.i("getData", "onSuccess")
                data.value = task
            }

            override fun onError(e: Throwable) {
                Log.i("getData", "onError")
                data.value = null
                e.printStackTrace()
            }
        })
    }


}