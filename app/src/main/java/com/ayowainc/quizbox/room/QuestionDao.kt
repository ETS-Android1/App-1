package com.ayowainc.quizbox.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ayowainc.quizbox.model.Question

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addQuestion(question: Question)

    @Query("SELECT * FROM QuestionTable ORDER BY id ASC")
    fun  readAllData():LiveData<List<Question>>
}