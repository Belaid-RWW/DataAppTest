package com.example.mydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val et_Email = findViewById<EditText>(R.id.et_Email)
        val et_Password = findViewById<EditText>(R.id.et_Password)

        btnLogin.setOnClickListener{
            val email = et_Email.editableText.toString()
            val password = et_Password.editableText.toString()

            if (validateInputs(email, password)) {
                firebaseLogin(email, password)
            }
        }

    }

    private fun validateInputs(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            et_Email.error = getString(R.string.empty_email)
            return false
        }
        if (password.isEmpty()) {
            et_Password.error = getString(R.string.empty_password)
            return false
        }
        if (isEmailInvalid(email)) {
            showAlert(getString(R.string.invalid_email))
            return false
        }
        if (!checkPassword(password)) {
            showAlert(getString(R.string.invalid_pass))
            return false
        }
        return true
    }

    private fun goToHomeActivity(email: String) {
        val intent = Intent(this, ChoiceActivity::class.java)
        intent.putExtra(EMAILL, email)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        et_Password.text = null
        et_Email.text = null
    }


    private fun isEmailInvalid(email: String): Boolean {
        return !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun checkPassword(password: String): Boolean {
        val passwordREGEX = Pattern.compile(
            "^" +
                    "(?=.*[!&{}¿?.<>~()^@+*/=;:#%\$])" +    //Au moins un caractère spécial
                    ".{8,}" +               //Au moins 8 caractères
                    "$"
        )
        return passwordREGEX.matcher(password).matches()
    }

    private fun showAlert(message: String){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(getString(R.string.msg_erreur))
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton(getString(R.string.Ok_button)) { dialog, i-> dialog.dismiss()}
        alertDialog.create().show()
    }

    private fun firebaseLogin(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                goToHomeActivity(email)
            }
            .addOnFailureListener {
                showAlert(getString(R.string.verify_creds))
            }
    }
}