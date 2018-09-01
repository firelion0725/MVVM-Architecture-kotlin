package com.leo.test.data.http

import com.leo.test.data.RetrofitManger
import com.leo.test.data.dao.load.TaskModel
import com.leo.test.data.dao.up.PostTaskModel
import com.leo.test.data.rx.RxUtils
import io.reactivex.Single

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
class TaskClouds {

    companion object {
        private val SERVICE: TaskService = RetrofitManger.getInstance().create(TaskService::class.java)

        public fun getTaskData(body: PostTaskModel): Single<TaskModel> {
            return RxUtils.compile(SERVICE.getTaskData(body))
        }
    }

}