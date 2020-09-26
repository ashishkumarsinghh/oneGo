package com.ashish.onego

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashish.onego.db.SubscriberRepo
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repo: SubscriberRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SubscriberViewModel::class.java)){
            return SubscriberViewModel(repo) as T
        }
        throw IllegalArgumentException("Undefined ViewModel Class")
    }
}