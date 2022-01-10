package com.ayowainc.quizbox.fragment.list

import com.ayowainc.quizbox.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.ayowainc.quizbox.fragment.list.adapter.ListAdapter
import com.ayowainc.quizbox.viewModel.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    lateinit var mQuestionViewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)

        //Recycler View
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter =adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        //questionViewModel
        mQuestionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        mQuestionViewModel.readAllData.observe(viewLifecycleOwner, Observer { question ->
            adapter.setData(question)
        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }

}