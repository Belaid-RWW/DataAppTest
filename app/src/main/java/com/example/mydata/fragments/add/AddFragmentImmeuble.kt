package com.example.mydata.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mydata.R
import com.example.mydata.model.Immeuble
import com.example.mydata.viewmodel.ImmeubleViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_add_immeuble.*
import kotlinx.android.synthetic.main.fragment_add_immeuble.view.*


class AddFragmentImmeuble : Fragment() {

    private lateinit var mImmeubleViewModel: ImmeubleViewModel

    lateinit var type: String
    lateinit var rue: String
    lateinit var etg: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_immeuble, container, false)

        mImmeubleViewModel = ViewModelProvider(this).get(ImmeubleViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        type = ""
        rue = ""
        etg = ""

        var typeList = arrayOf("Administration", "Siège Social","Commerce", "Bureautique", "Polyfonctionnel" ,"Habitation", "En chantier", "Ruine")
        val type : AutoCompleteTextView =  view.findViewById(R.id.addType)
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, typeList)
        type.setAdapter(adapter1)
        type.threshold=0

        var rueList = arrayOf("Avenue Farhat Hached", "Avenue La liberté", "Avenue Habib salem", "Boulevard Habib bourguiba",
        "Avenue 20 Mars", "Avenue Taher Sfar", "Avenue Les champs élysées")
        val rue : AutoCompleteTextView =  view.findViewById(R.id.addRue)
        val adapter2: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, rueList)
        rue.setAdapter(adapter2)
        rue.threshold=0

        var etgList = arrayOf("1", "2", "3", "4", "5", "6", "7")
        val etg : AutoCompleteTextView =  view.findViewById(R.id.addEtages)
        val adapter3: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, etgList)
        etg.setAdapter(adapter3)
        etg.threshold=0


        return view
    }

    private fun insertDataToDatabase() {

        val idI = addId.text
        val type = addType.text.toString()
        val nomRue = addRue.text.toString()
        val nomNum = addNomNum.text.toString()
        val etages = addEtages.text.toString()
        val acces = addAcces.text

        if (inputCheck(idI, type, nomRue, nomNum, etages, acces)){
            val immeuble = Immeuble(0, Integer.parseInt(idI.toString()), type, nomRue, nomNum, etages, Integer.parseInt(acces.toString()))
            print(immeuble)
            mImmeubleViewModel.addImmeuble(immeuble)
            Toast.makeText(requireContext(), "Immeuble ajoutée", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragmentImmeuble_to_listFragmentImmeuble)

        }
        else{
            Toast.makeText(requireContext(), "Vérifiez les champs", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(idd: Editable, typee:String, nomRuee:String, nomNumm:String, etagess: String, access: Editable): Boolean{
        return !(idd.isEmpty() && TextUtils.isEmpty(typee) && TextUtils.isEmpty(nomRuee) && TextUtils.isEmpty(nomNumm)
                && etagess.isEmpty() && access.isEmpty())

    }

}