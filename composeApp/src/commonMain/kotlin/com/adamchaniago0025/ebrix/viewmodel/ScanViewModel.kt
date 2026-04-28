package com.adamchaniago0025.ebrix.viewmodel

import androidx.lifecycle.ViewModel
import com.adamchaniago0025.ebrix.data.ScanData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScanViewModel : ViewModel() {

    private val _dataList = MutableStateFlow<List<ScanData>>(emptyList())
    val dataList: StateFlow<List<ScanData>> = _dataList

    fun addData(data: ScanData) {
        _dataList.value = _dataList.value + data
    }

    fun getDataById(id: Int): ScanData? {
        return _dataList.value.find { it.id == id }
    }
}