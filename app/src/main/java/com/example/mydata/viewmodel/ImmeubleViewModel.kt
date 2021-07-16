package com.example.mydata.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mydata.data.MyDatabase
import com.example.mydata.model.Immeuble
import com.example.mydata.repository.ImmeubleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImmeubleViewModel(application: Application): AndroidViewModel(application) {

    val readAllDatax: LiveData<List<Immeuble>>
    private val repository: ImmeubleRepository

    init {
        val immeubleDao = MyDatabase.getDatabase(
            application
        ).immeubleDao()
        repository =
            ImmeubleRepository(immeubleDao)
        readAllDatax = repository.readAllDatax
    }

    fun addImmeuble(immeuble: Immeuble) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addImmeuble(immeuble)
        }
    }

    fun updateImmeuble(immeuble: Immeuble){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateImmeuble(immeuble)
        }
    }

    fun deleteImmeuble(immeuble: Immeuble){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteImmeuble(immeuble)
        }
    }

    fun deleteAllImmeubles(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllImmeubles()
        }
    }

}