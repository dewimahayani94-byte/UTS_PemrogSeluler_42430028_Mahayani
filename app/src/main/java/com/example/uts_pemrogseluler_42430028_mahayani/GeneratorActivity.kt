package com.example.uts_pemrogseluler_42430028_mahayani

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNama = findViewById<EditText>(R.id.inputNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            val namaDosen = inputNama.text.toString()

            if (namaDosen.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                // Berpindah ke Halaman 2 dan membawa data
                val intent = Intent(this, GeneratorActivity::class.java)
                intent.putExtra("NAMA_DOSEN", namaDosen)
                startActivity(intent)
            }
        }
    }
}