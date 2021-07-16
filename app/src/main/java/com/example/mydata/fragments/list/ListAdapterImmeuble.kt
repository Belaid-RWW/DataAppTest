package com.example.mydata.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mydata.R
import com.example.mydata.model.Immeuble
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapterImmeuble : RecyclerView.Adapter<ListAdapterImmeuble.MyViewHolder>(){

    private var immeubleList = emptyList<Immeuble>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return immeubleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = immeubleList[position]
        holder.itemView.id_txt.text = currentItem.idI.toString()
        holder.itemView.type_et.text = currentItem.type
        holder.itemView.rue_et.text = currentItem.nomRue

        holder.itemView.rowLayout1.setOnClickListener{
            val action = ListFragmentImmeubleDirections.actionListFragmentImmeubleToUpdateFragmentImmeuble(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }
    fun setData (immeuble: List<Immeuble>){
        this.immeubleList = immeuble
        notifyDataSetChanged()
    }
}
