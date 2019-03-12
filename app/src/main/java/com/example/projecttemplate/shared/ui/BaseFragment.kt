package com.example.projecttemplate.shared.ui

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projecttemplate.shared.viewmodels.BaseViewModel
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment<B: ViewDataBinding, V: BaseViewModel<*>> : Fragment() {

    protected lateinit var viewDataBinding: B
    abstract var viewModel: V
    abstract var bindingVariable: Int
    abstract var layoutId: Int

    lateinit var baseActivity: BaseActivity<*, *>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.setVariable(bindingVariable, viewModel)
        viewModel.createdView()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        baseActivity = context as BaseActivity<*, *>
    }

    override fun onDestroyView() {
        viewModel.disposeBag.dispose()
        super.onDestroyView()
    }
}