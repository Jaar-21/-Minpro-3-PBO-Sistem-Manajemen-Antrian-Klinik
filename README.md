# 🏥 Sistem Manajemen Antrian Pasien pada Klinik

> Mini Project 3 - Pemrograman Berorientasi Objek (PBO)

Program CRUD (Create, Read, Update, Delete) berbasis Java console untuk mengelola data antrian pasien pada sebuah klinik. Program memiliki dua jenis pasien, yaitu **Pasien Umum** dan **Pasien BPJS**.

Program ini merupakan pengembangan dari Mini Project sebelumnya dengan penerapan **Encapsulation, Inheritance, Polymorphism, Abstraction, MVC (Model-View-Controller), validasi input**, serta **Interface** sebagai nilai tambah.

---

# Sistem Manajemen Antrian Pasien pada Klinik

## Identitas Mahasiswa

| Keterangan        | Data                           |
| ----------------- | ------------------------------ |
| **Nama**          | Ahmad Fajar Novia              |
| **NIM**           | 2509116041                     |
| **Program Studi** | Sistem Informasi               |
| **Fakultas**      | Fakultas Teknik                |
| **Universitas**   | Universitas Mulawarman         |
| **Praktikum**     | Pemrograman Berorientasi Objek |
| **Project**       | Mini Project 3                 |

---

## 📋 Deskripsi Singkat

Program ini dibuat untuk mensimulasikan sistem manajemen antrian pasien pada sebuah klinik. Program berjalan menggunakan console dan menyediakan beberapa menu yang dapat digunakan untuk menampilkan, menambahkan, memperbarui, menghapus, dan memanggil pasien.

Pasien dibedakan menjadi dua jenis, yaitu **Pasien Umum** dan **Pasien BPJS**. Pasien Umum memiliki pilihan pembayaran berupa **Tunai** atau **Transfer**, sedangkan Pasien BPJS memiliki **nomor BPJS**.

Setiap pasien mendapatkan ID secara otomatis ketika data pasien dibuat. Program juga dilengkapi validasi input untuk memastikan data yang dimasukkan sesuai dengan ketentuan, seperti nama hanya berupa huruf, umur berada pada rentang 1–200, nomor telepon terdiri dari 9–13 digit, dan nomor BPJS hanya berupa angka.

Pada program juga diterapkan konsep **abstraction** melalui abstract class `Pasien`, **inheritance** melalui `PasienUmum` dan `PasienBPJS`, serta **polymorphism** melalui method overriding dan overloading. Struktur program menggunakan pola **MVC** agar bagian model, tampilan, dan pengatur alur program dipisahkan.

---

## 🗂️ Struktur Program (Package)

Program disusun menggunakan struktur **MVC (Model-View-Controller)** dengan beberapa package tambahan untuk memisahkan fungsi setiap bagian program.

```text
src/
├── main/
│   └── Main.java
│
├── controller/
│   └── PasienController.java
│
├── model/
│   ├── Pasien.java
│   ├── PasienUmum.java
│   ├── PasienBPJS.java
│   └── Pembayaran.java
│
├── service/
│   └── PasienCRUD.java
│
├── view/
│   └── PasienView.java
│
└── helper/
    └── ValidasiInput.java
```

### Penjelasan Package

- **main**
  - `Main.java` → menjadi titik awal program dan menjalankan `PasienController`.

- **controller**
  - `PasienController.java` → mengatur alur program, menerima input dari pengguna, menentukan menu yang dipilih, serta menghubungkan View dengan Service dan Model.

- **model**
  - `Pasien.java` → abstract class yang menjadi superclass untuk seluruh jenis pasien.
  - `PasienUmum.java` → subclass dari `Pasien` untuk pasien umum.
  - `PasienBPJS.java` → subclass dari `Pasien` untuk pasien BPJS.
  - `Pembayaran.java` → interface yang digunakan untuk proses pembayaran pasien umum.

- **service**
  - `PasienCRUD.java` → menangani proses pengelolaan data pasien seperti tambah, update, hapus, cek ID, dan panggil pasien menggunakan `ArrayList`.

- **view**
  - `PasienView.java` → menangani tampilan menu, daftar pasien, pilihan jenis pasien, dan pesan yang ditampilkan kepada pengguna.

- **helper**
  - `ValidasiInput.java` → menangani validasi input pengguna agar data yang dimasukkan sesuai dengan ketentuan program.

---

# ⚙️ Alur Program & Tampilan Menu

Saat program dijalankan, akan muncul menu utama:

<img width="504" height="208" alt="image" src="https://github.com/user-attachments/assets/d04923de-8aee-436b-afa7-fd7e58de21eb" />


---

## 1️⃣ Tampilkan Pasien

<img width="786" height="284" alt="image" src="https://github.com/user-attachments/assets/f989b5f7-3640-4847-95e1-c50becb5107b" />

Menu **Tampilkan Pasien** digunakan untuk melihat seluruh pasien yang sedang berada di dalam antrian.

Data ditampilkan dalam bentuk tabel yang berisi:

- ID Pasien
- Nama
- Umur
- Nomor Telepon
- Informasi tambahan

Informasi tambahan akan menyesuaikan jenis pasien. Untuk Pasien Umum akan menampilkan jenis pembayaran, sedangkan Pasien BPJS akan menampilkan nomor BPJS.

Jika belum terdapat data pasien, program akan menampilkan pesan bahwa belum ada data pasien.

---

## 2️⃣ Tambahkan Pasien

<img width="657" height="398" alt="image" src="https://github.com/user-attachments/assets/d5e0851e-a6c0-4908-8c3b-55dd7261485e" />

Menu **Tambahkan Pasien** digunakan untuk memasukkan pasien baru ke dalam sistem.

Program akan meminta:

1. Nama pasien
2. Umur pasien
3. Nomor telepon
4. Jenis pasien

Terdapat dua pilihan jenis pasien:

```text
1. Pasien Umum
2. Pasien BPJS
```

### Pasien Umum

Jika pengguna memilih Pasien Umum, program akan meminta jenis pembayaran:

```text
1. Tunai
2. Transfer
```

Data kemudian dibuat sebagai objek `PasienUmum` dan dimasukkan ke dalam daftar pasien.

### Pasien BPJS

Jika pengguna memilih Pasien BPJS, program akan meminta nomor BPJS. Data kemudian dibuat sebagai objek `PasienBPJS` dan dimasukkan ke dalam daftar pasien.

ID pasien tidak perlu dimasukkan secara manual karena akan dibuat secara otomatis oleh class `Pasien`.

---

## 3️⃣ Update Pasien

<img width="655" height="638" alt="image" src="https://github.com/user-attachments/assets/4e223434-5333-4e98-a5ff-e006756bb296" />

Menu **Update Pasien** digunakan untuk memperbarui data pasien berdasarkan ID.

Program akan meminta ID pasien terlebih dahulu. Jika ID ditemukan, pengguna dapat mengubah:

- Nama
- Umur
- Nomor telepon

Jika ID tidak ditemukan, program akan menampilkan pesan:

```text
ID pasien tidak ditemukan
```

Validasi input tetap diterapkan ketika data baru dimasukkan.

---

## 4️⃣ Menghapus Pasien

<img width="666" height="556" alt="image" src="https://github.com/user-attachments/assets/8808af62-17fd-4c6f-83a7-2db17fa33bec" />

Menu **Menghapus Pasien** digunakan untuk menghapus data pasien berdasarkan ID.

Program akan mencari ID pasien di dalam daftar. Jika ditemukan, data pasien akan dihapus dari daftar pasien.

Jika ID tidak ditemukan, program akan menampilkan pesan:

```text
ID pasien tidak ditemukan
```

---

## 5️⃣ Panggil Pasien

<img width="659" height="464" alt="image" src="https://github.com/user-attachments/assets/2f67f1ea-27c6-48e6-8906-e7a1a5442d06" />

Menu **Panggil Pasien** digunakan untuk memanggil pasien berdasarkan ID.

Jika pasien ditemukan, program akan menampilkan informasi lengkap pasien sesuai dengan jenisnya.

Untuk Pasien Umum, program juga akan menampilkan informasi proses pembayaran:

```text
Pembayaran pasien umum: Tunai
```

atau:

```text
Pembayaran pasien umum: Transfer
```

Setelah pasien dipanggil, data pasien akan dihapus dari daftar antrian karena pasien dianggap sudah masuk untuk mendapatkan pelayanan.

---

## 6️⃣ Keluar

<img width="514" height="200" alt="image" src="https://github.com/user-attachments/assets/b5f3d01b-c18f-42b2-acfa-1c91eb62c571" />

Menu **Keluar** digunakan untuk mengakhiri program.

Program akan menampilkan pesan:

```text
program selesai
```

Kemudian program berhenti.

---

# 🔒 Penerapan Encapsulation

<img width="459" height="139" alt="image" src="https://github.com/user-attachments/assets/0e7372ff-e2f7-4396-9eec-12fb96dc2b6a" />

Encapsulation diterapkan dengan membatasi akses langsung terhadap atribut yang terdapat pada class.

Pada class `Pasien`, atribut data utama dibuat `private`, yaitu:

```java
private String nama;
private int umur;
private String noTelepon;
```

Sedangkan `idPasien` dibuat:

```java
protected final int idPasien;
```

Akses terhadap data pasien dilakukan melalui method seperti:

- `getNama()`
- `setNama()`
- `getUmur()`
- `setUmur()`
- `getNoTelepon()`
- `setNoTelepon()`
- `getIdPasien()`

Setter juga memiliki validasi sehingga data yang dimasukkan tidak langsung diterima tanpa pemeriksaan.

Contohnya pada `setNama()`, nama harus berupa huruf dan tidak boleh kosong.

Pada `PasienBPJS`, atribut:

```java
private String nomorBPJS;
```

juga diakses melalui getter dan setter.

Pada `PasienUmum`, atribut:

```java
private String jenisPembayaran;
```

juga menggunakan getter dan setter.

Selain itu, data pasien pada `PasienCRUD` disimpan dalam atribut `private`:

```java
private ArrayList<Pasien> listPasien = new ArrayList<>();
private ArrayList<PasienUmum> listPasienUmum = new ArrayList<>();
private ArrayList<PasienBPJS> listPasienBPJS = new ArrayList<>();
```

Dengan demikian, data tidak diakses secara langsung dari luar class, tetapi melalui method yang telah disediakan.

---

# 🧬 Penerapan Inheritance

<img width="240" height="92" alt="image" src="https://github.com/user-attachments/assets/5ea580c3-9ced-4064-9ce1-372f89070757" />

Inheritance digunakan untuk membuat hubungan antara class `Pasien` dengan dua jenis pasien.

Struktur inheritance pada program:

```text
                 Pasien
                /      \
               /        \
      PasienUmum      PasienBPJS
```

### Superclass

`Pasien` merupakan superclass yang berisi data dan perilaku dasar yang dimiliki oleh semua pasien, seperti:

- ID pasien
- Nama
- Umur
- Nomor telepon
- Getter dan setter
- Method `tampilkanInfo()`

### Subclass PasienUmum

`PasienUmum` merupakan subclass dari `Pasien` dan memiliki data tambahan:

```java
private String jenisPembayaran;
```

### Subclass PasienBPJS

`PasienBPJS` merupakan subclass dari `Pasien` dan memiliki data tambahan:

```java
private String nomorBPJS;
```

Kedua subclass menggunakan `extends Pasien` dan memanggil constructor superclass menggunakan:

```java
super(nama, umur, noTelepon);
```

Dengan inheritance, atribut dan method dasar pasien tidak perlu ditulis ulang pada setiap subclass.

---

# 🎭 Penerapan Polymorphism

Polymorphism diterapkan dalam dua bentuk, yaitu **method overriding** dan **method overloading**.

## 1. Method Overriding

Method `tampilkanInfo()` dibuat sebagai abstract method pada class `Pasien`:

```java
public abstract void tampilkanInfo();
```

Method tersebut kemudian di-override oleh `PasienUmum`:

<img width="638" height="226" alt="image" src="https://github.com/user-attachments/assets/18721af7-3a60-4adb-b7ce-789d4d481da2" />


dan oleh `PasienBPJS`:

<img width="627" height="223" alt="image" src="https://github.com/user-attachments/assets/589ee797-aaf0-46a3-84cc-1f92eb65755c" />


Walaupun nama method sama, isi method menampilkan informasi yang berbeda sesuai dengan jenis pasien.

Pasien Umum menampilkan informasi pembayaran, sedangkan Pasien BPJS menampilkan nomor BPJS.

Selain `tampilkanInfo()`, method `getInfoTambahan()` juga di-override oleh kedua subclass.

Pada `PasienUmum`:

```java
@Override
public String getInfoTambahan() {
    return "Pembayaran: " + jenisPembayaran;
}
```

Sedangkan pada `PasienBPJS`:

```java
@Override
public String getInfoTambahan() {
    return "BPJS: " + nomorBPJS;
}
```

Method tersebut digunakan oleh `toString()` pada class `Pasien` untuk menampilkan informasi tambahan sesuai objek yang digunakan.

---

## 2. Method Overloading

Method overloading diterapkan pada class `Pasien` melalui dua method dengan nama yang sama tetapi parameter yang berbeda.

Method pertama:

```java
public abstract void tampilkanInfo();
```

Method kedua:

```java
public void tampilkanInfo(int cekId) {
    if (cekId == idPasien) {
        tampilkanInfo();
    } else {
        System.out.println("ID pasien tidak sesuai");
    }
}
```

Perbedaannya terletak pada parameter. Method pertama tidak memiliki parameter, sedangkan method kedua memiliki parameter `int cekId`.

Pada `PasienController`, method overloading tersebut digunakan ketika pasien dipanggil:

```java
pasienDipanggil.tampilkanInfo(idPanggil);
```

Method tersebut kemudian memeriksa ID dan memanggil `tampilkanInfo()` sesuai jenis objek pasien.

---

# 🧱 Penerapan Abstraction

Abstraction diterapkan menggunakan **abstract class** dan **abstract method**.

Class `Pasien` dibuat sebagai abstract class:

<img width="394" height="134" alt="image" src="https://github.com/user-attachments/assets/4c36a8c1-863c-4d0c-a71a-c9ca705f8194" />

Karena `Pasien` merupakan konsep umum, class tersebut tidak dibuat sebagai objek secara langsung. Objek yang digunakan dalam program adalah `PasienUmum` dan `PasienBPJS`.

Selain itu, class `Pasien` memiliki abstract method:

<img width="449" height="41" alt="image" src="https://github.com/user-attachments/assets/01258486-2e26-4314-868e-b1f9c9ddc6e0" />

Method tersebut tidak memiliki implementasi di superclass dan harus diimplementasikan oleh setiap subclass.

Pada `PasienUmum`, method tersebut digunakan untuk menampilkan informasi pasien umum.

Pada `PasienBPJS`, method tersebut digunakan untuk menampilkan informasi pasien BPJS.

Dengan abstraction, class `Pasien` hanya menentukan perilaku dasar yang harus dimiliki oleh setiap jenis pasien, sedangkan detail tampilannya ditentukan oleh masing-masing subclass.

---

# 🧩 Penerapan Interface

Sebagai nilai tambah, program menerapkan interface `Pembayaran`.

Interface dibuat pada file:

```text
model/Pembayaran.java
```

Isi interface:

<img width="319" height="93" alt="image" src="https://github.com/user-attachments/assets/b9355c3c-fc45-4550-b1a0-9b5dec6e008f" />

Interface tersebut kemudian diterapkan oleh class `PasienUmum`:

```java
public class PasienUmum extends Pasien implements Pembayaran
```

Class `PasienUmum` kemudian mengimplementasikan method:

<img width="720" height="93" alt="image" src="https://github.com/user-attachments/assets/11335b1d-52de-453d-bb3b-a304fce76419" />

Method `prosesPembayaran()` digunakan pada saat pasien umum dipanggil melalui `PasienController`.

Dengan adanya interface, proses pembayaran menjadi sebuah perilaku khusus yang diterapkan pada class yang menggunakan `Pembayaran`.

---

# 🏗️ Penerapan MVC

Program menggunakan pola **Model-View-Controller (MVC)** untuk memisahkan pengelolaan data, tampilan, dan alur program.

## Model

Package `model` berisi:

```text
Pasien.java
PasienUmum.java
PasienBPJS.java
Pembayaran.java
```

Model bertanggung jawab terhadap data dan perilaku objek pasien.

`Pasien` menjadi abstract class, sedangkan `PasienUmum` dan `PasienBPJS` menjadi turunannya.

---

## View

Package `view` berisi:

```text
PasienView.java
```

`PasienView` bertanggung jawab terhadap tampilan yang dilihat pengguna, seperti:

- Menampilkan menu utama
- Menampilkan daftar pasien
- Menampilkan pilihan jenis pasien
- Menampilkan pesan atau notifikasi

Contohnya:

```java
view.tampilkanMenu();
```

dan:

```java
view.tampilkanDaftarPasien(crud.getListPasien());
```

---

## Controller

Package `controller` berisi:

```text
PasienController.java
```

`PasienController` bertugas mengatur alur utama program.

Controller menerima input dari pengguna, menentukan menu yang dipilih, kemudian menghubungkan View dengan Service dan Model.

Contohnya ketika pengguna memilih menu tambah pasien, Controller meminta input melalui `ValidasiInput`, membuat objek `PasienUmum` atau `PasienBPJS`, kemudian mengirimkannya ke `PasienCRUD`.

---

## Service

Package `service` berisi:

```text
PasienCRUD.java
```

Class `PasienCRUD` menangani proses pengelolaan data pasien, seperti:

- Menambah pasien
- Mengecek ID pasien
- Mengubah data pasien
- Menghapus pasien
- Memanggil pasien
- Menyimpan data menggunakan `ArrayList`

Service tidak bertugas menampilkan menu kepada pengguna. Proses tampilan tetap ditangani oleh `PasienView`.

---

## Main

Package `main` berisi:

```text
Main.java
```

`Main.java` hanya menjadi titik awal program dengan membuat objek `PasienController` dan menjalankan program.

```java
public static void main(String[] args) {
    PasienController controller = new PasienController();
    controller.jalankanProgram();
}
```

Dengan demikian, `Main.java` tidak menangani proses menu dan CRUD secara langsung.

---

# ✅ Validasi Input

Validasi input dibuat pada class `ValidasiInput` yang berada di package `helper`.

Validasi digunakan agar program tidak berhenti atau menghasilkan data yang tidak sesuai ketika pengguna memasukkan input yang salah.

### Validasi pilihan angka

Method `inputInteger()` memastikan input berupa angka.

Jika pengguna memasukkan huruf, program akan menampilkan:

<img width="679" height="318" alt="image" src="https://github.com/user-attachments/assets/930e18c1-a598-4639-8323-d1291f74e245" />

dan meminta input kembali.

### Validasi nama

Nama hanya dapat berisi huruf dan spasi.

<img width="666" height="274" alt="image" src="https://github.com/user-attachments/assets/bd9172cb-be04-403d-a3eb-adc451364aa7" />

### Validasi umur

Umur harus berada pada rentang:

<img width="646" height="236" alt="image" src="https://github.com/user-attachments/assets/8ac13da5-1c8e-4feb-abd8-d79b9e1402c2" />

### Validasi nomor telepon

Nomor telepon harus berupa angka dengan panjang:

<img width="917" height="271" alt="image" src="https://github.com/user-attachments/assets/b29a05db-43e9-42a3-9770-3f9f41b4b778" />

### Validasi nomor BPJS

<img width="728" height="278" alt="image" src="https://github.com/user-attachments/assets/9950b87f-23bf-4aaa-8031-75fa5ae988e1" />

Nomor BPJS hanya boleh berupa angka.

Jika input tidak sesuai, program akan meminta pengguna memasukkan kembali data yang benar.

Validasi dibuat menggunakan perulangan sehingga hanya bagian input yang salah yang akan diminta ulang.

---
