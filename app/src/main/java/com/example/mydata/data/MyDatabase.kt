package com.example.mydata.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mydata.model.Entreprise
import com.example.mydata.model.Immeuble

@Database(entities = [Immeuble::class, Entreprise::class], version = 2 , exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun immeubleDao(): ImmeubleDao
    abstract fun entrepriseDao(): EntrepriseDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}
