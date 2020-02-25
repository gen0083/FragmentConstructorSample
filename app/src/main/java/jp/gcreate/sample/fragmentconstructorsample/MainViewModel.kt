package jp.gcreate.sample.fragmentconstructorsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count: Int = 0
    private val _countLiveData: MutableLiveData<Int> = MutableLiveData(0)
    val countLiveData: LiveData<Int> = _countLiveData

    fun increment() {
        count++
        _countLiveData.value = count
    }

    fun decrement() {
        count--
        _countLiveData.value = count
    }
}