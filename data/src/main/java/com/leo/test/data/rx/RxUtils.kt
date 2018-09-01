package com.leo.test.data.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
public class RxUtils {

    public companion object {
        fun <T> compile(observable: Observable<T>): Observable<T> {
            return observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

        fun <T> compile(observable: Single<T>): Single<T> {
            return observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

        fun <T> compile(observable: Flowable<T>): Flowable<T> {
            return observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

}