package com.example.mydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_home1.*

class HomeActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)

        btn_acc.setOnClickListener {
            val intent = Intent(this, ChoiceActivity::class.java)
            startActivity(intent)
            finish()
        }

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

        img_help.setOnClickListener{
            MaterialAlertDialogBuilder(this)
                    .setTitle("Liste des activités")
                    .setItems(arrItems) {_, which -> when(which){
                    } }.show()
        }


        setupActionBarWithNavController(findNavController(R.id.fragment))

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}