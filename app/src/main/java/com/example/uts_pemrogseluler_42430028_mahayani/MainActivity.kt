package com.example.uts_pemrogseluler_42430028_mahayani

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GeneratorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generator)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val inputJumlah = findViewById<EditText>(R.id.inputJumlahMahasiswa)
        val inputRata = findViewById<EditText>(R.id.inputRataRata)
        val btnProses = findViewById<Button>(R.id.btnProsesData)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // Menangkap data Nama Dosen dari MainActivity
        val namaDosen = intent.getStringExtra("NAMA_DOSEN")
        tvSapaan.text = "Selamat bertugas, Dosen $namaDosen"

        btnProses.setOnClickListener {
            val jumlahStr = inputJumlah.text.toString()
            val rataStr = inputRata.text.toString()

            // Validasi agar aplikasi tidak crash kalau input kosong
            if (jumlahStr.isEmpty() || rataStr.isEmpty()) {
                Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val jumlahMahasiswa = jumlahStr.toInt()
            val rataRata = rataStr.toDouble()

            // Logika 1: If-Else untuk menentukan Status Kelas
            val statusKelas = if (rataRata >= 80) {
                "Sangat Baik"
            } else if (rataRata >= 60) {
                "Cukup"
            } else {
                "Kurang"
            }

            // Membangun teks untuk ditampilkan
            val hasilText = StringBuilder()
            hasilText.append("Status Kelas: $statusKelas\n\n")
            hasilText.append("Daftar Absen:\n")

            // Logika 2: Perulangan For untuk mencetak baris absen
            for (i in 1..jumlahMahasiswa) {
                hasilText.append("Mahasiswa $i: ______ \n")
            }

            // Menampilkan hasil akhir ke layar
            tvHasil.text = hasilText.toString()
        }
    }
}