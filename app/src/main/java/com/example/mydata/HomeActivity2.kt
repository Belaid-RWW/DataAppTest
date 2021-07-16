package com.example.mydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home1.*
import kotlinx.android.synthetic.main.activity_home2.*
import kotlinx.android.synthetic.main.fragment_add_immeuble.view.*

class HomeActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        val arrItems = arrayOf("Santé : الصحة",
                "Alimentation : التغذية",
                "Industrie : الصناعة",
                "Education : التعليم",
                "Tourisme : السياحة",
                "Mécanique : ميكانيك",
                "Alimentation : التغذية",
                "Industrie : الصناعة",
                "Education : التعليم",
                "Tourisme : السياحة",
                "Alimentation : التغذية",
                "Industrie : الصناعة",
                "Education : التعليم",
                "Tourisme : السياحة",
                "Alimentation : التغذية",
                "Industrie : الصناعة",
                "Education : التعليم",
                "Tourisme : السياحة")

        img_help2.setOnClickListener{
            MaterialAlertDialogBuilder(this)
                    .setTitle("Liste des activités")
                    .setItems(arrItems) {_, which -> when(which){
                    } }.show()
        }

        btn_acc2.setOnClickListener {
            val intent = Intent(this, ChoiceActivity::class.java)
            startActivity(intent)
            finish()
        }

        setupActionBarWithNavController(findNavController(R.id.fragment2))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment2)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}