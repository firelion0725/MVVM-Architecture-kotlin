package com.leo.test.data.http

import com.leo.test.data.dao.load.CategoriesDao
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
interface TaskService {

    @GET("api/xiandu/categories")
    fun getCategories(): Single<CategoriesDao>
}