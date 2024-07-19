package com.example.pruebabcp.presentation.screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebabcp.domain.model.DeviceDomainModel
import com.example.pruebabcp.domain.usecase.GetDevicesUseCase
import com.example.pruebabcp.utils.Result
import com.example.pruebabcp.utils.ErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Screen1ViewModel @Inject constructor(
    private val getDevicesUseCase: GetDevicesUseCase
) : ViewModel() {
    private val _devices = MutableStateFlow<List<DeviceDomainModel>>(emptyList())
    val devices: StateFlow<List<DeviceDomainModel>> = _devices

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun loadDevices() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                when (val result = getDevicesUseCase()) {
                    is Result.Success -> {
                        _devices.value = result.data
                        _errorMessage.value = null
                    }
                    is Result.Failure -> {
                        _devices.value = emptyList()
                        _errorMessage.value = ErrorHandler.handle(result.error)
                    }
                }
            } catch (e: Exception) {
                _errorMessage.value = "Unexpected error occurred"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
