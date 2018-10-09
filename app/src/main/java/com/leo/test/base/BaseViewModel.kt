package com.leo.test.base

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

    private val TAG = this.javaClass.simpleName

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addSubscribe(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    protected fun unSubscribe() {
        compositeDisposable.clear()
    }

    //----------------------LifeCycle----------------------

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected fun onCreate() {
        Log.i(TAG, "onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected fun onStart() {
        Log.i(TAG, "onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected fun onResume() {
        Log.i(TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected fun onPause() {
        Log.i(TAG, "onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected fun onStop() {
        Log.i(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected fun onDestroy() {
        Log.i(TAG, "onDestroy")
        unSubscribe()
    }

    abstract inner class BaseViewModelSingleObserver<T> : SingleObserver<T> {
        override fun onSubscribe(d: Disposable) {
            addSubscribe(d)
        }
    }
}