package com.example.mydata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mydata.data.MyDatabase
import com.example.mydata.model.Entreprise
import com.example.mydata.repository.EntrepriseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntrepriseViewModel(application: Application): AndroidViewModel(application) {

    val readAllData2: LiveData<List<Entreprise>>
    private val repository: EntrepriseRepository

    init {
        val entrepriseDao = MyDatabase.getDatabase(
            application
        ).entrepriseDao()
        repository =
            EntrepriseRepository(
                entrepriseDao
            )
        readAllData2 = repository.readAllData2
    }

    fun addEntreprise(entreprise: Entreprise) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEntreprise(entreprise)
        }
    }

    fun updateEntreprise(entreprise: Entreprise){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateEntreprise(entreprise)
        }
    }

    fun deleteEntreprise(entreprise: Entreprise){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteEntreprise(entreprise)
        }
    }

    fun deleteAllEntreprises(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllEntreprises()
        }
    }
}