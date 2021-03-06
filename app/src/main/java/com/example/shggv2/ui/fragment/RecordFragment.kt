package com.example.shggv2.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shggv2.R
import com.example.shggv2.databinding.FragmentRecordBinding
import com.example.shggv2.databinding.FragmentSearchBinding
import com.example.shggv2.model.DTO.RecordRvData

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding

    private var recordList = arrayListOf<RecordRvData>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentRecordBinding.inflate(inflater, container, false)

        return binding.root
    }
}