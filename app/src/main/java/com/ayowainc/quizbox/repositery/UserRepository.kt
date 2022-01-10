package com.ayowainc.quizbox.repositery

import androidx.lifecycle.LiveData
import com.ayowainc.quizbox.model.Question
import com.ayowainc.quizbox.room.QuestionDao

class UserRepository(private  val questionDao: QuestionDao) {

    val readAllData: LiveData<List<Question>> = questionDao.readAllData()

    suspend fun addUser (question: Question){
        questionDao.addQuestion(question)
    }
}