package com.ayowainc.quizbox.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayowainc.quizbox.repositery.UserRepository
import com.ayowainc.quizbox.room.QuestionDatabase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(application: Application) :AndroidViewModel(application) {

    val  readAllData:LiveData<List<Question>>
    private val repository : UserRepository


    init {
        val questionDao = QuestionDatabase.getDatabase(application).questionDao()
        repository= UserRepository(questionDao)
        readAllData=repository.readAllData
    }

    fun addQuestion(question: Question){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(question)
        }
    }
}