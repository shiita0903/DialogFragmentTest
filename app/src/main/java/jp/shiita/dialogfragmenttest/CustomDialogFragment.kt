package jp.shiita.dialogfragmenttest

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.linecorp.lich.viewmodel.viewModel
import jp.shiita.dialogfragmenttest.databinding.DialogCustomBinding
import timber.log.Timber


class CustomDialogFragment : DialogFragment() {

    private val viewModel: CustomDialogViewModel by viewModel(CustomDialogViewModel)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogCustomBinding.inflate(requireActivity().layoutInflater).also {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }

        viewModel.inputs.observe(this, Observer {
            Timber.d(it.joinToString(separator = ","))
        })

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("OK") { _, _ ->

            }
            .create()
    }
}
