package com.example.mydata.repository

import androidx.lifecycle.LiveData
import com.example.mydata.data.EntrepriseDao
import com.example.mydata.model.Entreprise

class EntrepriseRepository(private val entrepriseDao: EntrepriseDao) {

    val readAllData2: LiveData<List<Entreprise>> = entrepriseDao.readAllData()

    suspend fun addEntreprise(entreprise: Entreprise) {
        entrepriseDao.addEntreprise(entreprise)
    }

    suspend fun updateEntreprise(entreprise: Entreprise){
        entrepriseDao.updateEntreprise(entreprise)
    }

    suspend fun deleteEntreprise(entreprise: Entreprise){
        entrepriseDao.deleteEntreprise(entreprise)
    }

    suspend fun deleteAllEntreprises(){
        entrepriseDao.deleteAllEntreprises()
    }
}