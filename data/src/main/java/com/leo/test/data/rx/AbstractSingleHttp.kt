package com.leo.test.data.rx

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
abstract class AbstractSingleHttp<T> : SingleObserver<T> {

    override fun onSubscribe(d: Disposable) {
    }
}