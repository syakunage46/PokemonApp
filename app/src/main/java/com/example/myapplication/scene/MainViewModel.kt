package com.example.myapplication.scene

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.navigation.Navigation
import com.example.myapplication.module.navigation.NavigationPresenterInterface
import javax.inject.Inject

abstract class MainViewModelAbstract: ViewModel() {
    abstract val navigation: LiveData<Navigation>
}

class MainViewModel @Inject constructor(presenter: NavigationPresenterInterface): MainViewModelAbstract(){
    override val navigation: LiveData<Navigation> = presenter.navigationFlow.asLiveData()
}