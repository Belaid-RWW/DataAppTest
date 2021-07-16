package com.example.mydata.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "entreprise_table")

data class Entreprise (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nomPresta: String,
    val dom: String,
    val act: String,
    val horDebut: String,
    val horFin: String,
    val tel: Int,
    val fax: Int,
    val gsm: Int,
    val email: String,
    val site: String,
    val idI: Int
) : Parcelable