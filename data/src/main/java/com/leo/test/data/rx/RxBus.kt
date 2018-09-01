package com.leo.test.data.rx

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
class RxBus private constructor() {

    private val mBus: Subject<Any>

    init {
        mBus = PublishSubject.create()
    }

    companion object {
        val RX_BUS = RxBus
    }

    public fun getInstance(): Companion {
        return RX_BUS
    }

    public fun post(any: Any) {
        mBus.onNext(any)
    }

    public fun <T> toObservable(eventType: Class<T>): Observable<T>? {
        return mBus.ofType(eventType)
    }

}