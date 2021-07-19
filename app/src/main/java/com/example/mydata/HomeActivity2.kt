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

        val arrItems = arrayOf("Restauration et cafés" ,"Auto, Moto", "Coiffure et soins de beauté", "Sport, loisir et divertissement",
                "Culture et arts", "Santé", "Alimentation", "Matériel et équipments de construction", "BTP", "Service spécialisé scientifique et technique",
                "Service B2B", "Réparation et service aux personnes", "Tourisme", "Droit et justice", "Education et enseignement",
                "Banque, finance, assurance", "Immoblier", "Transport et logistique", "Réligion", "Magasin spécialisé - Meuble",
                "Magasin spécialisé - Vêtements", "Magasin spécialisé - Sports", "Magasin spécialisé - Informatique et télécommunications",
                "Magasin spécialisé - Eléctroniques", "Magasin spécialisé - TV et Audio", "Magasin spécialisé - Matériels audio/vidéo",
                "Magasin spécialisé - Matériels de sécurité et surveillance", "Magasin spécialisé - Récepteurs et paraboles", "Magasin spécialisé - Consoles et jeux vidéos",
                "Magasin spécialisé - Horlogerie", "Magasin spécialisé - Bijoux", "Magasin spécialisé - Instruments et matériels du musique",
                "Magasin spécialisé - Produits artisanals et souvenirs", "Magasin spécialisé - Cigarettes éléctroniques et accessoires", "Magasin spécialisé - Article d'emballage et packaging",
                "Magasin spécialisé - Article de pâtisserie", "Magasin spécialisé - Zoomagasin - Animalerie", "Magasin spécialisé - Articles en plastiques","Magasin spécialisé - Equipements de pêche",
                "Magasin spécialisé - Equipements de chasse", "Magasin spécialisé - Biens d'antiquité et de brocante", "Magasin spécialisé - Biens d'occasion",
                "Magasin spécialisé - Equipements des restaurents et cafés", "Magasin spécialisé - Parfumerie", "Magasin spécialisé - Parfumerie Professionnel", "Magasin spécialisé - Matériel et équipement de salon de coiffure",
                "Magasin spécialisé - Jeux et jouets", "Magasin spécialisé - Maison")

        img_help2.setOnClickListener{
            MaterialAlertDialogBuilder(this)
                    .setTitle("Secteurs des activités")
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