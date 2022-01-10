package com.ayowainc.quizbox.fragment.add



import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ayowainc.quizbox.R
import com.ayowainc.quizbox.model.Question

import com.ayowainc.quizbox.viewModel.QuestionViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    lateinit var mQuestionViewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)
        mQuestionViewModel=ViewModelProvider(this).get(QuestionViewModel::class.java)

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            insertDataToDataList()
        }

        return view
    }

    private fun insertDataToDataList() {
//        val tvHello = findViewById<TextView>(R.id.nameHint)
//        val firstName :EditText = findViewById(R.id.nameHint)
        val firstName = nameHint.text.toString()
        val lastName = lastName.text.toString()
        val age = ageHint.text

        if (inputChecks(firstName,lastName, age)){
            //create question objects
            val question = Question(0,firstName,lastName,Integer.parseInt(age.toString()))
            //Add data to data base
            mQuestionViewModel.addQuestion(question)
            Toast.makeText(requireContext(),"SuccessFully Added",Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Something went wrong",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputChecks (firstName:String,lastName:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&& age.isEmpty())
    }

}