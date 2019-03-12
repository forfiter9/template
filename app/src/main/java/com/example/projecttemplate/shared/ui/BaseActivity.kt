package com.example.projecttemplate.shared.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.projecttemplate.shared.viewmodels.BaseViewModel
import dagger.android.AndroidInjection

abstract class BaseActivity<B:ViewDataBinding, V : BaseViewModel<*>> : AppCompatActivity() {
    protected lateinit var viewDataBinding: B
    abstract var viewModel: V
    abstract var bindingVariable: Int
    abstract var layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        viewDataBinding.setVariable(bindingVariable, viewModel)
        viewModel.createdView()
    }

    inline fun <reified T> startActivity(finish: Boolean = false, bundle: Bundle? = null) {

        val intent = Intent(this, T::class.java)

        if (bundle != null)
            intent.putExtras(bundle)

        startActivity(intent)

        if (finish)
            this.finish()
    }
    fun replaceFragment(fragment: BaseFragment<*, *>, where: Int, addToBackStack: Boolean = false, withAnimation: Boolean = false,
                        animationEnter: Int? = null, animationExit: Int? = null, animationPopEnter: Int? = null, animationPopExit: Int? = null, bundle: Bundle? = null) {
        val transaction = supportFragmentManager.beginTransaction()

        if (withAnimation) {

            animationEnter?.let { enter ->
                animationExit?.let { exit ->
                    animationPopEnter?.let { popEnter ->
                        animationPopExit?.let { popExit ->
                            transaction.setCustomAnimations(enter, exit, popEnter, popExit)
                        }
                    } ?: transaction.setCustomAnimations(enter, exit)
                }
            }
        }

        if (bundle != null) {
            fragment.arguments = bundle
        }
        transaction.replace(where, fragment)

        if (addToBackStack)
            transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onDestroy() {
        viewModel.destroyView()
        super.onDestroy()
    }
}