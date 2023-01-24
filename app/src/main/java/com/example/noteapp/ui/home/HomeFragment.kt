package com.example.noteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.noteapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     //   val homeViewModel =
     //       ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
/*
        val textView: TextView = binding.nadpis
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val textView1: TextView = binding.fullText
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView1.text = it
        }
*/

        binding.button.setOnClickListener {
                activity?.finish();
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}