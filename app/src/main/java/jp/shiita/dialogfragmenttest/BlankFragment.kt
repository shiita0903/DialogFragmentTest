package jp.shiita.dialogfragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.linecorp.lich.viewmodel.activityViewModel
import kotlinx.android.synthetic.main.fragment_blank.*
import timber.log.Timber

class BlankFragment : Fragment() {

    private val resultViewModel by activityViewModel(DialogResultViewModel)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        show_dialog_button.setOnClickListener {
            findNavController().navigate(
                BlankFragmentDirections.actionBlankFragmentToCustomDialogFragment()
            )
        }

        resultViewModel.result.observe(viewLifecycleOwner, Observer {
            Timber.d(it)
        })
    }
}
