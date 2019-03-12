package com.example.projecttemplate.gitusers.ui


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.projecttemplate.BR
import com.example.projecttemplate.R
import com.example.projecttemplate.databinding.FragmentGitUsersBinding
import com.example.projecttemplate.gitusers.navigators.GitUsersFragmentNavigator
import com.example.projecttemplate.gitusers.viewmodels.GitUsersFragmentViewModel
import com.example.projecttemplate.shared.adapters.DataBoundRecyclerViewAdapter
import com.example.projecttemplate.shared.ui.BaseFragment
import javax.inject.Inject

class GitUsersFragment : BaseFragment<FragmentGitUsersBinding, GitUsersFragmentViewModel>(), GitUsersFragmentNavigator {

    @Inject
    override lateinit var viewModel: GitUsersFragmentViewModel

    override var bindingVariable: Int = BR.viewModel

    override var layoutId: Int = R.layout.fragment_git_users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewDataBinding.recyclerView.adapter = DataBoundRecyclerViewAdapter(viewModel.users)
    }

    override fun success() {
        Toast.makeText(context, R.string.success, Toast.LENGTH_SHORT).show()
    }

    override fun failed() {
        Toast.makeText(context, R.string.failed, Toast.LENGTH_SHORT).show()
    }
}