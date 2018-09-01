package com.leo.test.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
class RetrofitManger {

    private object SingletonHolder {
        val RETROFIT_CLIENT = Retrofit.Builder()
                .baseUrl(BaseUrlManger.BASE_URL)
                .client(OkHttpManger.getInstance())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()!!
    }

    public companion object {
        fun getInstance(): Retrofit {
            return SingletonHolder.RETROFIT_CLIENT
        }
    }

}