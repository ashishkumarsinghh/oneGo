package com.ashish.onego

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.onego.db.Subscriber
import com.ashish.onego.db.SubscriberRepo
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repo: SubscriberRepo): ViewModel() {

    val subscribers = repo.subscribers
    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val addBtnTxt = MutableLiveData<String>()
    @Bindable
    val clearAllBtnTxt = MutableLiveData<String>()

    init {
        addBtnTxt.value = "Save"
        clearAllBtnTxt.value = "Clear All"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0,name, email))
        inputName.value=null
        inputEmail.value=null
    }
    fun clearAllOrDelete(){
        clearAll()
    }
    fun insert(subscriber:Subscriber){
        viewModelScope.launch { repo.insert(subscriber) }
    }

    fun update(subscriber: Subscriber){
        viewModelScope.launch { repo.update(subscriber) }
    }

    fun delete(subscriber: Subscriber){
        viewModelScope.launch { repo.delete(subscriber) }
    }

    fun clearAll(){
        viewModelScope.launch { repo.deleteAll() }
    }
}