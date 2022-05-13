package com.example.hamrahman

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.zang)
        mediaPlayer.start()

        setContentView(R.layout.activity_main)
        getStateLogin(this)

        val Edit_Phone = findViewById<EditText>(R.id.Edit_Phone)
        val Edit_Password = findViewById<EditText>(R.id.Edit_Password)
        val btn_Register = findViewById<Button>(R.id.btn_Register)

        btn_Register.setOnClickListener {
            mediaPlayer.start()
            if (Edit_Phone.text.toString() == "" || Edit_Password.text.toString() == "") {
                Toast.makeText(this, "فیلد های خالی میباشد", Toast.LENGTH_SHORT).show()
            } else if (!Edit_Phone.text.toString().startsWith("09")) {
                Toast.makeText(this, "شماره نامعتبر است", Toast.LENGTH_SHORT).show()
            } else if (Edit_Phone.text.toString().length != 11) {
                Toast.makeText(this, "شماره نامعتبر است", Toast.LENGTH_SHORT).show()
            } else {
                var intent: Intent = Intent(this, login::class.java)
                intent.putExtra("Edit_Phone", Edit_Phone.text.toString())
                finish()
                startActivity(intent)
            }

        }
    }

    private fun getStateLogin(context: Context) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("login_pref", Context.MODE_PRIVATE)
        if (sharedPreferences.getBoolean("state", false)) {
            var intent: Intent = Intent(this, login::class.java)
            finish()
            startActivity(intent)
        }
    }
}

