package com.leo.test.data

import android.util.Log
import com.leo.test.data.dao.load.CategoriesDao
import com.leo.test.data.http.TaskClouds
import com.leo.test.data.rx.AbstractSingleHttp
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

/**
 * @date 2018/9/5
 * @author leo,ZhangWei
 * @function
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [23])
class TaskTest {

    @Before
    fun setUp() {
        ShadowLog.stream = System.out
        initRxJava()
    }

    fun initRxJava() {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun testGetCategories() {
        TaskClouds.getCategories()
                .subscribe(object : AbstractSingleHttp<CategoriesDao>() {
                    override fun onSuccess(t: CategoriesDao) {
                        Log.i("getData", "onSuccess")
                    }

                    override fun onError(e: Throwable) {
                        Log.i("getData", "onError")
                        e.printStackTrace()
                    }
                })
    }
}