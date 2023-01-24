package com.example.noteapp.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }


        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(OverviewViewModel::class.java)

        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        val root: View = binding.root

            // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
            binding.lifecycleOwner = this

            // Giving the binding access to the OverviewViewModel
            binding.viewModel = viewModel

            //setHasOptionsMenu(true)

        return root
    }
    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        //super.onCreateOptionsMenu(menu, inflater)
    }*/


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}