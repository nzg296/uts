Pesona Wisata Indonesia
--------------------------------------------------
dibuat oleh:
Nabil Zhafran Gyfari(2411500032)
Nabil Alfarizi(2412501641)
--------------------------------------------------
Tentang Aplikasi:
Jadi aplikasi ini tuh buat mesen tiket wisata ke beberapa destinasi populer di Indonesia. User bisa pilih mau ke Bali, Jogja, Lombok, Raja Ampat, atau Labuan Bajo. Nanti bakal muncul detail harga sama fasilitas tambahan yang bisa dipilih.

Kenapa pake tema wisata? soalnya di soal UTS dibilang bebas tema dan gak boleh pake Student Registration Form yang udah sering dibahas di kelas. Jadi ya wisata aja biar beda.

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

Bonus (nilai tambahan):

- DatePicker - Pilih tanggal keberangkatan pake kalender
- RecyclerView - Nampilin riwayat pemesanan dalam bentuk list
- Login & Register - Ada sistem akun biar lebih interaktif
- Logout - Bisa keluar dari akun
- Multiple Implicit Intent - Ada 4 jenis: dial, maps, email, share

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

Screenshot Aplikasi

Screenshot bakal ditambahin setelah presentasi / pas udah jalan di device

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

- Awalnya bingung mau pake tema apa, akhirnya milih wisata aja biar beda sama yang lain
- Sempet error pas ganti minSdk soalnya adaptive icon butuh API 26, jadi folder mipmap-anydpi dihapus
- Login system agak ribet soalnya harus nyimpen data user di SharedPreferences terus validasi pas login

--------------------------------------------------

Kesimpulan

Aplikasi ini udah memenuhi semua ketentuan wajib dari soal UTS + ada beberapa fitur bonus. Semoga lancar pas presentasi nanti.

--------------------------------------------------

Dibuat untuk memenuhi Ujian Tengah Semester (UTS) Mata Kuliah Mobile Programming
Universitas Budi Luhur - Semester Genap 2025/2026
