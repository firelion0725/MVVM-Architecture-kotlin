package com.leo.test.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import java.lang.reflect.ParameterizedType

/**
 * @date 2018/8/31
 * @author leo,ZhangWei
 * @function
 */
public abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBaseViewModel()
    }

    fun setBaseViewModel() {
        viewModel = ViewModelProviders.of(this).get(getTClass())
    }

    fun getTClass(): Class<T> {
        return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
    }

}