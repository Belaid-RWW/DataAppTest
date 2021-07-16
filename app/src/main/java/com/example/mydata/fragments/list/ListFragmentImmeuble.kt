package com.example.mydata.fragments.list

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydata.ChoiceActivity
import com.example.mydata.HomeActivity2
import com.example.mydata.R
import com.example.mydata.viewmodel.EntrepriseViewModel
import com.example.mydata.viewmodel.ImmeubleViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list_entreprise.view.*
import kotlinx.android.synthetic.main.fragment_list_immeuble.view.*

class ListFragmentImmeuble : Fragment() {

    private lateinit var mImmeubleViewModel: ImmeubleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_immeuble, container, false)

        val adapter = ListAdapterImmeuble()
        val recyclerView = view.recyclerView1
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mImmeubleViewModel = ViewModelProvider(this).get(ImmeubleViewModel::class.java)
        mImmeubleViewModel.readAllDatax.observe(viewLifecycleOwner, Observer { immeuble ->
            adapter.setData(immeuble)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragmentImmeuble_to_addFragmentImmeuble)
        }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.menu_delete){
            deleteAllImmeubles()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllImmeubles() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Oui"){ _, _ ->
            mImmeubleViewModel.deleteAllImmeubles()
            Toast.makeText(requireContext(), "Immeubles supprimés", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Non"){ _, _ ->
        }
        builder.setTitle("Supprimer la liste des immeubles? ")
        builder.setMessage("Êtes vous sure de supprimer toutes les immeubles?")
        builder.create().show()
    }
}

