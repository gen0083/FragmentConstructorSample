package jp.gcreate.sample.fragmentconstructorsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jp.gcreate.sample.fragmentconstructorsample.databinding.FragmentHasArgumentsBinding

class HasArgumentsFragment(val count: Int) : Fragment() {
    private lateinit var binding: FragmentHasArgumentsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_has_arguments, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView.text = "$count times"
        binding.fragmentInstance.text = this.toString()
    }
}
