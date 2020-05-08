package jp.shiita.dialogfragmenttest

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.linecorp.lich.viewmodel.AbstractViewModel
import com.linecorp.lich.viewmodel.SavedState
import com.linecorp.lich.viewmodel.ViewModelFactory

class CustomDialogViewModel : AbstractViewModel() {

    val inputLiveData = MutableLiveData("")
    val inputIsNotBlank = inputLiveData.map { !it.isNullOrBlank() }

    fun add() {
        inputLiveData.value = ""
    }

    companion object : ViewModelFactory<CustomDialogViewModel>() {
        override fun createViewModel(
            context: Context,
            savedState: SavedState
        ) = CustomDialogViewModel()
    }
}