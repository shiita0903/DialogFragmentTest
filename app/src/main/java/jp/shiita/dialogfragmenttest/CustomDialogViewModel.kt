package jp.shiita.dialogfragmenttest

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.linecorp.lich.viewmodel.AbstractViewModel
import com.linecorp.lich.viewmodel.SavedState
import com.linecorp.lich.viewmodel.ViewModelFactory

class CustomDialogViewModel : AbstractViewModel() {

    val inputLiveData = MutableLiveData("")
    val inputIsNotBlank = inputLiveData.map { !it.isNullOrBlank() }

    val inputs: LiveData<List<String>>
        get() = _inputs

    private val _inputs = MutableLiveData<List<String>>()

    fun add() {
        val value = inputLiveData.value ?: return

        val list = _inputs.value?.toMutableList() ?: mutableListOf()
        list.add(value)
        _inputs.value = list
        inputLiveData.value = ""
    }

    companion object : ViewModelFactory<CustomDialogViewModel>() {
        override fun createViewModel(
            context: Context,
            savedState: SavedState
        ) = CustomDialogViewModel()
    }
}