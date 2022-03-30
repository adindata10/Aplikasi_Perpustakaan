package com.company;

class Buku {
    String judul;
    String penulis;
    String penerbit;
    int kodeBuku;
    static int hitungBuku = 0;

    Buku(String judul, String penulis, String penerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        hitungBuku += 1;
        kodeBuku = hitungBuku;
    }

    void tampilDetailBuku() {
        System.out.println("Detail Buku");
        System.out.println("Judul           : " + judul);
        System.out.println("Penulis         : " + penulis);
        System.out.println("Penerbit        : " + penerbit);
        System.out.println("Kode Buku       : " + kodeBuku + "\n");
    }
}

class Mahasiswa {
    String nama;
    String npm;
    String prodi;
    String alamat;
    String noTel;
    int idPemustaka;
    boolean statusPemustaka = false;
    Peminjaman pemustaka;

    Mahasiswa(String nama, String npm) {
        this.nama = nama;
        this.npm = npm;
    }

    void daftarPemustaka(Peminjaman pemustaka) {
        this.pemustaka = pemustaka;
        idPemustaka = pemustaka.idPemustaka;
        statusPemustaka = pemustaka.statusKeaktifan;
    }

    void tampilDetailMhs() {
        System.out.println("Detail Mahasiswa");
        System.out.println("Nama            : " + nama);
        System.out.println("NPM             : " + npm);
        System.out.println("ID Pemustaka    : " + idPemustaka);
    }

    public String getNama() {
        return nama;
    }

    public String getNPM() {
        return npm;
    }

    //Pengajuan SKBP
    Mahasiswa(String nama, String npm, String prodi, String alamat, String noTel) {
        System.out.println("Formulir Cetak Bebas Perpustakaan");
        System.out.println("Nama            : " + nama);
        System.out.println("NPM             : " + npm);
        System.out.println("Program Studi   : " + prodi);
        System.out.println("Alamat          : " + alamat);
        System.out.println("No. Telepon     : " + noTel);
        System.out.println("--- Surat Keterangan Bebas Perpustakaan Anda sedang diverifikasi. ---");
        System.out.println("--- Hasil verifikasi akan diinformasikan melalui nomor telepon Anda. ---");
        System.out.println("--- Mohon selesaikan administrasi setelah proses verifikasi selesai. --- \n");
    }
}

class Peminjaman {
    String nama;
    String npm;
    static int idPemustaka = 0;
    boolean statusKeaktifan;

    Peminjaman(Mahasiswa pemustaka) {
        this.nama = pemustaka.getNama();
        this.npm = pemustaka.getNPM();
        idPemustaka += 1;
        statusKeaktifan = true;
    }

    void pinjamBuku(Mahasiswa pemustaka, Buku buku) {
        System.out.println("----- DETAIL PEMINJAMAN -----");
        pemustaka.tampilDetailMhs();
        System.out.println("--- Mahasiswa tersebut meminjam buku: ---");
        buku.tampilDetailBuku();
    }

    void kembalikanBuku(Mahasiswa pemustaka, Buku buku) {
        System.out.println("----- DETAIL PENGEMBALIAN -----");
        pemustaka.tampilDetailMhs();
        System.out.println("--- Mahasiswa tersebut mengembalikan buku: ---");
        buku.tampilDetailBuku();
    }
}

class Absensi {
    Mahasiswa mahasiswa;

    void getData(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    void absen() {
        System.out.println("Detail Pemustaka");
        System.out.println("Nama                : " + mahasiswa.nama);
        System.out.println("NPM                 : " + mahasiswa.npm);
        System.out.println("ID Pemustaka        : " + (mahasiswa.idPemustaka != 0 ? mahasiswa.idPemustaka : "Belum terdaftar"));
        System.out.println("Status Keaktifan    : " + (mahasiswa.statusPemustaka == true ? "Aktif" : "Belum Aktif"));
    }
}

class Pustakawan {
    String nama;
    int ID;

    Pustakawan(String nama, int ID){
        this.nama = nama;
        this.ID = ID;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
}

public class Main {

    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("Siti", "123456");
        mhs1.daftarPemustaka(new Peminjaman(mhs1));

        Buku buku1 = new Buku("Kalkulus Edisi ke-9 Jilid 2", "Varberg, Purcell, Rigdon", "Erlangga");

        mhs1.pemustaka.pinjamBuku(mhs1, buku1);
        mhs1.pemustaka.kembalikanBuku(mhs1, buku1);

        Mahasiswa mhs3 = new Mahasiswa("Budi", "234567", "TI", "Bandar Lampung", "08xxxxxxxxxx");
    }
}
