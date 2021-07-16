package com.example.mydata.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mydata.R
import com.example.mydata.model.Entreprise
import kotlinx.android.synthetic.main.custom_row2.view.*


class ListAdapterEntreprise : RecyclerView.Adapter<ListAdapterEntreprise.MyViewHolder>(){

    private var entrepriseList = emptyList<Entreprise>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row2, parent, false))
    }

    override fun getItemCount(): Int {
        return entrepriseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = entrepriseList[position]
        holder.itemView.nomPress.text = currentItem.nomPresta
        holder.itemView.hor1.text = currentItem.horDebut
        holder.itemView.hor2.text = currentItem.horFin
        holder.itemView.idimm.text = currentItem.idI.toString()

        holder.itemView.rowLayout2.setOnClickListener{
            val action = ListFragmentEntrepriseDirections.actionListFragmentEntrepriseToUpdateFragmentEntreprise(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }
    fun setData (entreprise: List<Entreprise>){
        this.entrepriseList = entreprise
        notifyDataSetChanged()
    }
}