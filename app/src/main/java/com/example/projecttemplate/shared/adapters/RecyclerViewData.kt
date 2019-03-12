package com.example.projecttemplate.shared.adapters

import android.databinding.ObservableList


abstract class RecyclerViewData<T> {
    abstract val itemBindID: Int
    abstract val items: ObservableList<T>
    abstract fun itemLayoutID(viewType: Int): Int
    abstract val itemHandler:Int
}