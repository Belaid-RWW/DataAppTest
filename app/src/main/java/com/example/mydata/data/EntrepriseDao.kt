package com.example.mydata.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mydata.model.Entreprise

@Dao
interface EntrepriseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEntreprise(entreprise: Entreprise)

    @Update
    suspend fun updateEntreprise(entreprise: Entreprise)

    @Query("select * from entreprise_table order by id asc")
    fun readAllData(): LiveData<List<Entreprise>>

    @Delete
    suspend fun deleteEntreprise(entreprise: Entreprise)

    @Query("delete from entreprise_table")
    suspend fun deleteAllEntreprises()
}