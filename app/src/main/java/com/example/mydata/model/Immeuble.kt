package com.example.mydata.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "immeuble_table")
data class Immeuble (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val idI: Int,
    val type: String,
    val nomRue: String,
    val nomNum: String,
    val nbEtages: String,
    val nbAcces: Int
) : Parcelable {
    override fun toString(): String {
        return "Immeuble(id=$id, idI=$idI, type='$type', nomRue='$nomRue', nomNum='$nomNum', nbEtages='$nbEtages', nbAcces=$nbAcces)"
    }
}