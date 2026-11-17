# GUI_Hitung-Luas-Panjang-Persegi

# Aplikasi Kalkulator Luas Persegi Panjang (Java Swing GUI)

Aplikasi desktop sederhana berbasis Java Swing untuk menghitung luas persegi panjang dengan pilihan satuan (`cm`, `m`, `mm`).

## 5 Komponen Utama GUI yang Digunakan

1. **Kelas Kontainer Tingkat Atas (Top-Level Container)**
   - `javax.swing.JFrame`: Digunakan sebagai jendela utama aplikasi (`LuasPersegiPanjang extends JFrame`).

2. **Kelas Kontainer Menengah (Intermediate Container)**
   - `javax.swing.JPanel`: Digunakan untuk mengelompokkan komponen ke dalam beberapa bagian (`panelUtama`, `panelInput`, `panelTombol`, `panelBawah`).

3. **Kelas Komponen Atom (Atomic Components)**
   - `javax.swing.JLabel`: Menampilkan judul, label input, dan hasil perhitungan.
   - `javax.swing.JTextField`: Menerima input angka untuk panjang dan lebar.
   - `javax.swing.JComboBox`: Menyediakan pilihan satuan panjang (`cm`, `m`, `mm`).
   - `javax.swing.JButton`: Tombol eksekusi untuk menghitung luas (`btnHitung`) dan mengosongkan form (`btnReset`).

4. **Kelas Tata Letak (Layout Managers)**
   - `java.awt.BorderLayout`: Mengatur tata letak utama jendela menjadi bagian atas (`NORTH`), tengah (`CENTER`), dan bawah (`SOUTH`).
   - `java.awt.GridLayout`: Mengatur posisi label dan kolom input secara rapi dalam bentuk baris dan kolom (`3x2`).
   - `java.awt.FlowLayout`: Mengatur posisi tombol `Hitung Luas` dan `Reset` secara sejajar di tengah.

5. **Pendengar Peristiwa (Event Listeners & Adapters)**
   - **Antarmuka (Interface)**:
     - `java.awt.event.ActionListener`: Menangani aksi klik pada tombol `Hitung Luas` dan `Reset`.
     - `java.awt.event.FocusListener`: Memberikan efek sorotan warna biru muda pada `JTextField` yang sedang aktif diketik.
   - **Kelas Adaptor (Adapter Class)**:
     - `java.awt.event.KeyAdapter`: Menangani penekanan tombol `Enter` pada kolom lebar untuk langsung menghitung luas.
     - `java.awt.event.MouseAdapter`: Memberikan efek perubahan warna tombol saat kursor diarahkan ke tombol `Hitung Luas`.

## Tangkapan Layar (Screenshot)
![alt text](Tampilan.png)
![alt text](<Input Yang Salah.png>) 
![alt text](<Pesan Tidak Valid.png>) 
![alt text](<Pilihan Satuan.png>)