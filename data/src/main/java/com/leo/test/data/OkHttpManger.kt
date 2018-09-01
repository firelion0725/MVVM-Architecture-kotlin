package com.leo.test.data

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
class OkHttpManger {

    private object SingletonHolder {
        private const val TIME_OUT: Long = 10
        val OK_HTTP_CLIENT = OkHttpClient.Builder()
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(getHttpLoggingInterceptor())
                .build()!!

        private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor { it ->
                Log.d("OkHttpManger", "body: $it")
            }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }
    }

    public companion object {
        fun getInstance(): OkHttpClient {
            return SingletonHolder.OK_HTTP_CLIENT
        }
    }

}