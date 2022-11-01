package com.example.codialapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codialapp.databinding.FragmentViewPagerBinding
import com.example.codialapp.databinding.ItemLayoutBinding
import com.example.codialapp.databinding.ItemLayoutGuruhBinding
import com.example.codialapp.databinding.ItemListBinding
import com.example.codialapp.models.Guruh


class GuruhAdapter (var list: List<Guruh>,var rvClic:RvClic) : RecyclerView.Adapter<GuruhAdapter.VP_Vh>() {

    inner class VP_Vh(var itemRv:FragmentViewPagerBinding):
        RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(guruh: Guruh,position: Int) {

            itemRv.txtGuruhName.text=guruh.name



            itemRv.korishParent.setOnClickListener {

                rvClic.showClik(guruh,position)
            }
            itemRv.editParent.setOnClickListener {


                rvClic.editclic(guruh,position)
            }

            itemRv.deleteParent.setOnClickListener {
                rvClic.deleteClic( guruh,position)
            }




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(FragmentViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size



}

interface RvClic{

     fun showClik(guruh: Guruh,position: Int)
      fun editclic(guruh: Guruh,position: Int)
      fun deleteClic(guruh: Guruh,position: Int)
}