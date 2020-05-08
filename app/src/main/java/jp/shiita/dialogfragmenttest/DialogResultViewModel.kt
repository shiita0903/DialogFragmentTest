package jp.shiita.dialogfragmenttest

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.linecorp.lich.viewmodel.AbstractViewModel
import com.linecorp.lich.viewmodel.SavedState
import com.linecorp.lich.viewmodel.ViewModelFactory

class DialogResultViewModel : AbstractViewModel() {

    val result: LiveData<String>
        get() = _result

    private val _result = MutableLiveData<String>()

    fun setResult(result: String) {
        _result.value = result
    }

    companion object : ViewModelFactory<DialogResultViewModel>() {
        override fun createViewModel(
            context: Context,
            savedState: SavedState
        ) = DialogResultViewModel()
    }
}