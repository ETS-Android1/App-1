package com.ayowainc.quizbox.fragment.list.adapter

import com.ayowainc.quizbox.R


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayowainc.quizbox.model.Question
import kotlinx.android.synthetic.main.custom_room.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyVIewHolder>() {


    class MyVIewHolder (itemView : View):RecyclerView.ViewHolder(itemView){}


    private var questionList = emptyList<Question>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVIewHolder {
        return MyVIewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_room,parent,false))
    }

    override fun onBindViewHolder(holder: MyVIewHolder, position: Int) {
        val currentList = questionList[position]
        holder.itemView.srNumber.text =currentList.id.toString()
        holder.itemView.nameID.text = currentList.firstName
        holder.itemView.lastId.text = currentList.lastName
        holder.itemView.ageId.text = currentList.age.toString()

        holder.itemView.rawLayout.setOnClickListener {
//            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentList)
//            holder.itemView.findNavController().navigate(action)

        }
    }
    fun setData(question: List<Question>){
        this.questionList=question
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return questionList.size
    }


}