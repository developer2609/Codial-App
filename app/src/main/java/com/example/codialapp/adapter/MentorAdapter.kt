package com.example.codialapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codialapp.OnItemClick
import com.example.codialapp.databinding.ItemLayoutBinding
import com.example.codialapp.databinding.ItemListBinding
import com.example.codialapp.databinding.ItemMentorBinding
import com.example.codialapp.models.Course
import com.example.codialapp.models.Mentor

//   interface onClik{
//
//       fun ClikItems(item:Mentor)
//   }

class MentorAdapter(var list: List<Mentor>,val mentorItemIvent:MentorItemEvent) : RecyclerView.Adapter<MentorAdapter.VP_Vh>() {

    inner class VP_Vh(var itemLayoutBinding: ItemMentorBinding):
        RecyclerView.ViewHolder(itemLayoutBinding.root) {
        fun onBind(mentor: Mentor,position: Int) {



              itemLayoutBinding.textName.text=mentor.name
            itemLayoutBinding.textNumber.text=mentor.number
            itemLayoutBinding.editText.setOnClickListener {
                mentorItemIvent.editClic(mentor,position)

            }

            itemLayoutBinding.deleteText.setOnClickListener {
                mentorItemIvent.deleteClic(mentor,position)
            }


//            itemLayoutBinding.tvName.text=course.name
//            itemLayoutBinding.linerLayout.setOnClickListener {
//
//
//
//            }






        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(ItemMentorBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    interface  MentorItemEvent{
        fun editClic(mentor: Mentor,position: Int)
        fun   deleteClic(mentor: Mentor,position: Int)


    }



}