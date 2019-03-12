package com.example.projecttemplate.shared.viewmodels

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel<N> : Disposable{
    var navigator: N? = null
    var disposeBag: CompositeDisposable = CompositeDisposable()

    open fun createdView() {}
    open fun destroyView() {
        disposeBag.dispose()
    }
}