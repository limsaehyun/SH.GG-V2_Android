package com.example.shggv2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shggv2.databinding.FragmentFriendBinding

class FriendFragment : Fragment() {

    private lateinit var binding: FragmentFriendBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFriendBinding.inflate(inflater, container, false)

        return binding.root
    }
}