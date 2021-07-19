package com.example.mydata.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mydata.R
import com.example.mydata.model.Immeuble
import com.example.mydata.viewmodel.ImmeubleViewModel
import kotlinx.android.synthetic.main.fragment_update_immeuble.*
import kotlinx.android.synthetic.main.fragment_update_immeuble.view.*

class UpdateFragmentImmeuble : Fragment() {

    private lateinit var  mImmeubleViewModel: ImmeubleViewModel

    lateinit var type: String
    lateinit var rue: String
    lateinit var etg: String

    private val args by navArgs<UpdateFragmentImmeubleArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update_immeuble, container, false)

        mImmeubleViewModel = ViewModelProvider(this).get(ImmeubleViewModel::class.java)

        type = ""
        rue = ""
        etg = ""

        var typeList = arrayOf("Administration", "Siège Social","Commerce", "Bureautique", "Polyfonctionnel" ,"Habitation", "En chantier", "Ruine")
        val type : AutoCompleteTextView =  view.findViewById(R.id.updateType)
        val adapter1: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, typeList)
        type.setAdapter(adapter1)
        type.threshold=0

        var rueList = arrayOf("Avenue Farhat Hached", "Avenue La liberté", "Avenue Habib salem", "Boulevard Habib bourguiba",
                "Avenue 20 Mars", "Avenue Taher Sfar", "Avenue Les champs élysées")
        val rue : AutoCompleteTextView =  view.findViewById(R.id.updateRue)
        val adapter2: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, rueList)
        rue.setAdapter(adapter2)
        rue.threshold=0

        var etgList = arrayOf("1", "2", "3", "4", "5", "6", "7")
        val etg : AutoCompleteTextView =  view.findViewById(R.id.updateEtages)
        val adapter3: ArrayAdapter<String> = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, etgList)
        etg.setAdapter(adapter3)
        etg.threshold=0

        view.updateId.setText(args.currentImmeuble.idI.toString())
        view.updateType.setText(args.currentImmeuble.type.toString())
        view.updateRue.setText(args.currentImmeuble.nomRue)
        view.updateNomNum.setText(args.currentImmeuble.nomNum)
        view.updateEtages.setText(args.currentImmeuble.nbEtages)
        view.updateAcces.setText(args.currentImmeuble.nbAcces.toString())


        view.update_btn.setOnClickListener {
            updateItem()
        }


        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val id = updateId.text
        val type = updateType.text.toString()
        val rue = updateRue.text.toString()
        val nomnum = updateNomNum.text.toString()
        val etages = updateEtages.text
        val acces = updateAcces.text


        if (inputCheck(id, type, rue, nomnum, etages, acces)){
            var updatedImmeuble = Immeuble(args.currentImmeuble.id,Integer.parseInt(id.toString()), type , rue, nomnum, etages.toString(), Integer.parseInt(acces.toString()))
            mImmeubleViewModel.updateImmeuble(updatedImmeuble)
            Toast.makeText(requireContext(),"Immeuble mis à jour", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragmentImmeuble_to_listFragmentImmeuble)
        }
        else{
            Toast.makeText(requireContext(),"Vérifiez les champs à mettre à jour", Toast.LENGTH_SHORT).show()
        }

    }
    private fun inputCheck(idd: Editable, typee:String, nomRuee:String, nomNumm:String, etagess: Editable, access: Editable): Boolean{
        return !(idd.isEmpty() && TextUtils.isEmpty(typee) && TextUtils.isEmpty(nomRuee) && TextUtils.isEmpty(nomNumm)
                && etagess.isEmpty() && access.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Oui"){ _, _ ->
            mImmeubleViewModel.deleteImmeuble(args.currentImmeuble)
            Toast.makeText(requireContext(), "Immeuble de type ${args.currentImmeuble.type} supprimée", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragmentImmeuble_to_listFragmentImmeuble)
        }
        builder.setNegativeButton("Non"){ _, _ ->
        }
        builder.setTitle("Supprimer l'immeuble de type ${args.currentImmeuble.type}?")
        builder.setMessage("Êtes vous sûre de supprimer l'immeuble de type ${args.currentImmeuble.type}?")
        builder.create().show()
    }
}