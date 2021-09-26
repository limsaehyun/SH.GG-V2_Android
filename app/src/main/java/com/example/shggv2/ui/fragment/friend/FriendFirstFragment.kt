package com.example.shggv2.ui.fragment.friend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shggv2.databinding.FragmentFriendBinding

class FrienFirstdFragment : Fragment() {
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFriendBinding.inflate(inflater, container, false)

        return binding.root
    }
}