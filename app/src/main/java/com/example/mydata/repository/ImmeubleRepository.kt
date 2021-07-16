package com.example.mydata.repository

import androidx.lifecycle.LiveData
import com.example.mydata.data.ImmeubleDao
import com.example.mydata.model.Immeuble

class ImmeubleRepository(private val immeubleDao: ImmeubleDao) {

    val readAllDatax: LiveData<List<Immeuble>> = immeubleDao.readAllDatax()

    suspend fun addImmeuble(immeuble: Immeuble) {
        immeubleDao.addImmeuble(immeuble)
    }

    suspend fun updateImmeuble(immeuble: Immeuble){
        immeubleDao.updateImmeuble(immeuble)
    }

    suspend fun deleteImmeuble(immeuble: Immeuble){
        immeubleDao.deleteImmeuble(immeuble)
    }

    suspend fun deleteAllImmeubles(){
        immeubleDao.deleteAllImmeubles()
    }
}