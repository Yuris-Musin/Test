package com.overnightstay.view.auth

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.overnightstay.R
import com.overnightstay.databinding.FragmentAuthBinding
import dagger.android.support.AndroidSupportInjection

class AuthFragment : Fragment() {
    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    private lateinit var  viewModel: AuthViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBtnListeners()
    }

    private fun initBtnListeners() = with(binding) {
        tvReg.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_regFragment)
        }

        tvForgot.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_restoreFragment)
        }

        btnEnter.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_choosePersFragment)
        }
    }
}