package com.example.projecttemplate.gitusers.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.projecttemplate.BR
import com.example.projecttemplate.R
import com.example.projecttemplate.databinding.ActivityGitUsersBinding
import com.example.projecttemplate.gitusers.navigators.GitUsersActivityNavigator
import com.example.projecttemplate.gitusers.viewmodels.GitUsersActivityViewModel
import com.example.projecttemplate.shared.ui.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class GitUsersActivity : BaseActivity<ActivityGitUsersBinding, GitUsersActivityViewModel>(), GitUsersActivityNavigator,
    HasSupportFragmentInjector {

    @Inject
    override lateinit var viewModel: GitUsersActivityViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    override var bindingVariable: Int = BR.viewModel
    override var layoutId: Int = R.layout.activity_git_users


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        replaceFragment(GitUsersFragment(), R.id.fragment_container, false, true,
            R.anim.auth_fragment_enter_anim, R.anim.auth_fragment_exit_anim, R.anim.auth_fragment_enter_pop_anim, R.anim.auth_fragment_exit_pop_anim)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
}
