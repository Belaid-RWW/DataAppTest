package com.example.mydata.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydata.R
import com.example.mydata.viewmodel.EntrepriseViewModel
import kotlinx.android.synthetic.main.fragment_list_entreprise.view.*

class ListFragmentEntreprise : Fragment() {

    private lateinit var mEntrepriseViewModel: EntrepriseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_entreprise, container, false)

        val adapter = ListAdapterEntreprise()
        val recyclerView = view.recyclerView2
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mEntrepriseViewModel = ViewModelProvider(this).get(EntrepriseViewModel::class.java)
        mEntrepriseViewModel.readAllData2.observe(viewLifecycleOwner, Observer { entreprise ->
            adapter.setData(entreprise)
        })

        view.floatingActionButton2.setOnClickListener{
            findNavController().navigate(R.id.action_listFragmentEntreprise_to_addFragmentEntreprise)
        }
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu2, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.menu_delete2){
            deleteAllImmeubles()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllImmeubles() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Oui"){ _, _ ->
            mEntrepriseViewModel.deleteAllEntreprises()
            Toast.makeText(requireContext(), "Entreprises supprimés", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Non"){ _, _ ->
        }
        builder.setTitle("Supprimer la liste des entreprises? ")
        builder.setMessage("Êtes vous sure de supprimer toutes les entreprises?")
        builder.create().show()
    }
}