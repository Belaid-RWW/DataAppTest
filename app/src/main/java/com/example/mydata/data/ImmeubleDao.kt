package com.example.mydata.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mydata.model.Immeuble

@Dao
interface ImmeubleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addImmeuble(immeuble: Immeuble)

    @Update
    suspend fun updateImmeuble(immeuble: Immeuble)


    @Query("select * from immeuble_table order by id asc")
    fun readAllDatax(): LiveData<List<Immeuble>>

    @Delete
    suspend fun deleteImmeuble(immeuble: Immeuble)

    @Query("delete from immeuble_table")
    suspend fun deleteAllImmeubles()
}