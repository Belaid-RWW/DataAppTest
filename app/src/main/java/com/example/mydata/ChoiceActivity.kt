package com.example.mydata

import android.R.attr.fragment
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mydata.fragments.list.ListFragmentImmeuble
import kotlinx.android.synthetic.main.activity_choice.*


class ChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        btn_imm.setOnClickListener {
            val intent = Intent(this, HomeActivity1::class.java)
            startActivity(intent)
            finish()        }

        btn_entre.setOnClickListener {
            val intent = Intent(this, HomeActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}