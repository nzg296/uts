Pesona Wisata Indonesia
--------------------------------------------------
dibuat oleh:
Nabil Zhafran Gyfari (2411500032)
Nabil Alfarizi (2412501641)

--------------------------------------------------

Tentang Aplikasi:

Aplikasi ini dibuat untuk memfasilitasi proses pemesanan tiket wisata ke beberapa destinasi populer di Indonesia. Pengguna dapat memilih berbagai tujuan wisata, seperti Bali, Yogyakarta, Lombok, Raja Ampat, dan Labuan Bajo. Setelah destinasi dipilih, aplikasi akan menampilkan informasi terkait harga tiket serta fasilitas tambahan yang tersedia dan dapat dipilih sesuai kebutuhan pengguna.

--------------------------------------------------

Fitur-Fitur:

1. 2 Activity - Terdapat LoginActivity, MainActivity, dan ResultActivity
2. Explicit Intent - Digunakan untuk perpindahan dari Login ke Main, lalu dari Main ke Result
3. Implicit Intent - Dapat membuka telepon, maps, email, dan share ke WhatsApp
4. Validasi Form - Mengecek field kosong, format email, nomor HP harus angka, dan lain-lain
5. EditText - Input nama, email, nomor HP, dan jumlah tiket
6. Spinner - Memilih destinasi wisata
7. RadioButton - Memilih jenis kelamin
8. CheckBox - Memilih fasilitas tambahan
9. ImageView - Menampilkan gambar destinasi wisata
10. SharedPreferences - Data pemesanan disimpan secara lokal, termasuk session login
11. Fragment - HistoryFragment digunakan untuk melihat riwayat pemesanan

fitur yang ada untuk nilai tambahan:
12. DatePicker - Memilih tanggal keberangkatan menggunakan kalender
13. RecyclerView - Menampilkan riwayat pemesanan dalam bentuk list
14. Login & Register - Terdapat sistem akun agar aplikasi lebih interaktif
15. Logout - Digunakan untuk keluar dari akun
16. Multiple Implicit Intent - Terdapat 4 jenis intent: dial, maps, email, dan share

--------------------------------------------------

Alur Penggunaan

1. Buka aplikasi -> akan muncul halaman login
2. Jika belum memiliki akun -> klik "Daftar di sini" -> isi username dan password -> register
3. Login -> masuk ke halaman form pemesanan
4. Isi form -> nama, email, nomor HP, pilih destinasi, tanggal, jumlah tiket, gender, dan fasilitas tambahan
5. Klik "Pesan Tiket Sekarang" -> akan muncul detail pemesanan beserta total harga
6. Klik "Bagikan" -> detail pemesanan dapat dibagikan ke WhatsApp
7. Klik "Riwayat" -> melihat seluruh riwayat pemesanan yang pernah dibuat
8. Klik "Logout" -> keluar dari aplikasi

--------------------------------------------------

Daftar Destinasi & Harga

Bali - Pantai Kuta          : Rp 1.500.000
Yogyakarta - Borobudur      : Rp 800.000
Lombok - Gunung Rinjani     : Rp 1.200.000
Raja Ampat - Papua          : Rp 3.500.000
Labuan Bajo - NTT           : Rp 2.000.000

Fasilitas Tambahan:
- Transportasi : +Rp 200.000/orang
- Makanan      : +Rp 150.000/orang
- Penginapan   : +Rp 500.000/orang

--------------------------------------------------

Cara Run Project

Dari Android Studio:
1. Clone repository ini
2. Buka project di Android Studio
3. Tunggu proses Gradle Sync selesai
4. Pilih device (emulator atau HP)
5. Klik tombol Run (>) atau tekan Shift + F10

Install APK langsung ke HP:
1. Cari file PesonaWisataIndonesia-debug.apk
2. Copy file ke HP
3. Install seperti biasa (izinkan install dari sumber tidak dikenal jika diminta)

Note:
Minimum Android 7.0 (API 24) ke atas.
Jika versi Android masih di bawah itu, aplikasi tidak dapat di-install.

--------------------------------------------------

Screenshot Aplikasi

Screenshot aplikasi akan ditambahkan setelah presentasi atau setelah aplikasi dijalankan pada device.

--------------------------------------------------

Tech Stack

- Bahasa    : Java
- IDE       : Android Studio
- UI        : XML + Material Design Components
- Storage   : SharedPreferences (lokal tanpa internet)
- Min SDK   : 24 (Android 7.0)
- Target SDK: 36

--------------------------------------------------

Kendala Selama Pengerjaan

- Pada tahap awal pengembangan, sempat mengalami kesulitan dalam menentukan tema aplikasi yang akan digunakan. Setelah mempertimbangkan beberapa pilihan, akhirnya dipilih tema wisata karena dianggap lebih menarik dan berbeda dari aplikasi lainnya.

- Selama proses pengembangan, sempat terjadi error ketika melakukan perubahan pada nilai minSdk. Hal tersebut disebabkan karena penggunaan adaptive icon yang membutuhkan minimal API 26. Untuk mengatasi masalah tersebut, folder mipmap-anydpi dihapus agar aplikasi dapat berjalan dengan normal pada versi API yang digunakan.

- Implementasi sistem login juga menjadi salah satu tantangan dalam pembuatan aplikasi. Proses ini memerlukan penyimpanan data pengguna menggunakan SharedPreferences serta validasi data saat login agar sistem dapat berjalan dengan baik sesuai kebutuhan aplikasi.

--------------------------------------------------

Kesimpulan

- Aplikasi Pesona Wisata Indonesia berhasil dibuat sesuai dengan ketentuan Ujian Tengah Semester (UTS) Mata Kuliah Mobile Programming. Aplikasi ini telah menjalankan berbagai fitur utama, seperti login dan register, pemesanan tiket wisata, validasi form, penggunaan SharedPreferences, Fragment, RecyclerView, DatePicker, serta Explicit dan Implicit Intent.

- Selain memenuhi seluruh fitur wajib, aplikasi ini juga memiliki beberapa fitur tambahan yang bertujuan untuk meningkatkan kenyamanan dan interaktivitas pengguna. Dengan adanya aplikasi ini, proses pemesanan wisata diharapkan dapat dilakukan dengan lebih mudah, praktis, dan efisien.

--------------------------------------------------

Dibuat untuk memenuhi Ujian Tengah Semester (UTS)
Mata Kuliah Mobile Programming
Universitas Budi Luhur - Semester Genap 2025/2026
