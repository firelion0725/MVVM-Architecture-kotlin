package com.leo.test.data.http

import com.leo.test.data.dao.load.TaskModel
import com.leo.test.data.dao.up.PostTaskModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
interface TaskService {

    @POST("papi/login/login")
    fun getTaskData(@Body body: PostTaskModel): Single<TaskModel>

}