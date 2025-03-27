package com.example.sampledependencyinjection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val users: LiveData<List<UserModel>> = repository.getUsers()

    fun fetchUsers() {
        viewModelScope.launch {
            repository.fetchUsersFromApi()
        }
    }
}