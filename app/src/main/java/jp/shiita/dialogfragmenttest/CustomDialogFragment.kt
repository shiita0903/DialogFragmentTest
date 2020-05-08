package jp.shiita.dialogfragmenttest

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.linecorp.lich.viewmodel.activityViewModel
import com.linecorp.lich.viewmodel.viewModel
import jp.shiita.dialogfragmenttest.databinding.DialogCustomBinding

class CustomDialogFragment : DialogFragment() {

    private val resultViewModel by activityViewModel(DialogResultViewModel)
    private val viewModel by viewModel(CustomDialogViewModel)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogCustomBinding.inflate(requireActivity().layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("OK") { _, _ ->
                val inputs = viewModel.inputs.value ?: emptyList()
                resultViewModel.setResult(inputs.joinToString(separator = ","))
            }
            .create()
    }
}
