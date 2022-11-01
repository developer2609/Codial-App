package com.example.codialapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codialapp.databinding.ItemLayoutBinding
import com.example.codialapp.models.Course
import com.example.codialapp.models.Mentor

interface OnItemClick {
    fun onItemClicked(item: Course,position: Int)
}

class RvAdapter(var list: List<Course>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<RvAdapter.VP_Vh>() {

    inner class VP_Vh(var itemLayoutBinding: ItemLayoutBinding, context: Context) :
        RecyclerView.ViewHolder(itemLayoutBinding.root) {
        fun onBindCourse(course: Course, position: Int) {


            itemLayoutBinding.tvName.text = course.name
            itemLayoutBinding.root.setOnClickListener {
                onItemClick.onItemClicked(list[position],position)
            }


        }

        fun onBindMentor(mentor: Mentor) {

            itemLayoutBinding


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(
            ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context
        )


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        try {
            val course: Course = list[position] as Course
            holder.onBindCourse(course, position)


        } catch (e: Exception) {

        }


    }

    override fun getItemCount(): Int = list.size


}