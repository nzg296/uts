Pesona Wisata Indonesia
--------------------------------------------------
dibuat oleh:
Nabil Zhafran Gyfari(2411500032)
Nabil Alfarizi(2412501641)
--------------------------------------------------
Tentang Aplikasi:

Aplikasi ini dibuat untuk memfasilitasi proses pemesanan tiket wisata ke beberapa destinasi populer di Indonesia. Pengguna dapat memilih berbagai tujuan wisata, seperti Bali, Yogyakarta, Lombok, Raja Ampat, dan Labuan Bajo. Setelah destinasi dipilih, aplikasi akan menampilkan informasi terkait harga tiket serta fasilitas tambahan yang tersedia dan dapat dipilih sesuai kebutuhan pengguna.


--------------------------------------------------

Fitur-Fitur:

1. 2 Activity - Ada LoginActivity, MainActivity, sama ResultActivity
2. Explicit Intent - Pindah dari Login ke Main, terus Main ke Result
3. Implicit Intent - Bisa buka telepon, maps, email, sama share ke whatsapp
4. Validasi Form - Cek field kosong, email harus ada @, no hp harus angka, dll
5. EditText - Input nama, email, no hp, jumlah tiket
6. Spinner - Pilih destinasi wisata
7. RadioButton - Pilih jenis kelamin
8. CheckBox - Pilih fasilitas tambahan
9. ImageView - Nampilin gambar destinasi
10. SharedPreferences - Data pemesanan disimpen di lokal, session login juga
11. Fragment - HistoryFragment buat liat riwayat pemesanan

fitur yang ada untuk nilai tambahan:
12. DatePicker - Pilih tanggal keberangkatan pake kalender
13. RecyclerView - Nampilin riwayat pemesanan dalam bentuk list
14. Login & Register - Ada sistem akun biar lebih interaktif
15. Logout - Bisa keluar dari akun
16. Multiple Implicit Intent - Ada 4 jenis: dial, maps, email, share

--------------------------------------------------

Alur Penggunaan

1. Buka aplikasi -> muncul halaman login
2. Belum punya akun? -> klik "Daftar di sini" -> isi username & password -> register
3. Login -> masuk ke form pemesanan
4. Isi form -> nama, email, no hp, pilih destinasi, tanggal, jumlah tiket, gender, fasilitas
5. Klik "Pesan Tiket Sekarang" -> muncul detail pemesanan + total harga
6. Klik "Bagikan" -> bisa share detail pemesanan ke whatsapp
7. Klik "Riwayat" -> liat semua pemesanan yang pernah dibuat
8. Klik "Logout" -> keluar dari aplikasi

--------------------------------------------------

Daftar Destinasi & Harga

- Bali - Pantai Kuta          : Rp 1.500.000

- Yogyakarta - Borobudur      : Rp 800.000

- Lombok - Gunung Rinjani     : Rp 1.200.000

- Raja Ampat - Papua          : Rp 3.500.000

- Labuan Bajo - NTT           : Rp 2.000.000

Fasilitas Tambahan:
- Transportasi : +Rp 200.000/orang
- Makanan      : +Rp 150.000/orang
- Penginapan   : +Rp 500.000/orang

--------------------------------------------------

Cara Run Project

Dari Android Studio:
1. Clone repo ini
2. Buka di Android Studio
3. Tunggu gradle sync
4. Pilih device (emulator atau hp real)
5. Klik tombol run (>) atau Shift+F10

Install APK langsung ke HP:
1. Cari file PesonaWisataIndonesia-debug.apk
2. Copy ke HP
3. Install seperti biasa (izinkan install dari sumber tidak dikenal kalau diminta)

Note: Minimun Android 7.0 (API 24) ke atas. Kalau HP kamu masih di bawah itu, gak bakal bisa install.

--------------------------------------------------

Tech Stack

- Bahasa    : Java
- IDE       : Android Studio
- UI        : XML + Material Design Components
- Storage   : SharedPreferences (lokal, gak perlu internet)
- Min SDK   : 24 (Android 7.0)
- Target SDK: 36

--------------------------------------------------

Kendala Selama Pengerjaan

- Pada tahap awal pengembangan, terdapat kebingungan dalam menentukan tema aplikasi yang akan digunakan. Setelah mempertimbangkan beberapa opsi, dipilih tema wisata agar memiliki konsep yang lebih menarik dan       berbeda dari aplikasi lain.

- Selama proses pengembangan, sempat terjadi error ketika melakukan perubahan pada nilai minSdk. Hal tersebut disebabkan karena penggunaan adaptive icon yang memerlukan minimal API 26. Untuk mengatasi masalah       tersebut, folder mipmap-anydpi dihapus sehingga aplikasi dapat berjalan dengan normal pada versi API yang digunakan.

- Implementasi sistem login juga menjadi salah satu tantangan dalam pengembangan aplikasi. Proses ini memerlukan penyimpanan data pengguna menggunakan SharedPreferences, serta pembuatan validasi data saat proses    login agar sistem dapat berjalan dengan baik dan sesuai kebutuhan aplikasi

--------------------------------------------------

Kesimpulan

- Aplikasi Pesona Wisata Indonesia berhasil dikembangkan sesuai dengan ketentuan yang diberikan pada Ujian Tengah Semester (UTS) Mata Kuliah Mobile Programming. Aplikasi ini mampu menjalankan berbagai fitur         utama, seperti sistem login dan registrasi, pemesanan tiket wisata, validasi form, penyimpanan data menggunakan SharedPreferences, penggunaan RecyclerView, Fragment, DatePicker, serta implementasi Explicit dan    Implicit Intent.

- Selain memenuhi seluruh persyaratan wajib, aplikasi ini juga dilengkapi dengan beberapa fitur tambahan yang bertujuan untuk meningkatkan kenyamanan dan interaktivitas pengguna. Dengan adanya aplikasi ini,         diharapkan proses pemesanan wisata dapat dilakukan dengan lebih mudah, praktis, dan efisien.

--------------------------------------------------

Dibuat untuk memenuhi Ujian Tengah Semester (UTS) Mata Kuliah Mobile Programming
Universitas Budi Luhur - Semester Genap 2025/2026
