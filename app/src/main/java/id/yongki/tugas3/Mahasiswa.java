package id.yongki.tugas3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey(autoGenerate = true)
    int uid;
    @ColumnInfo(name = "nama")
    String nama;
    @ColumnInfo(name = "nim")
    String nim;
    @ColumnInfo(name = "jurusan")
    String jurusan;
    @ColumnInfo(name = "no hp")
    String notlp;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNotlp() {
        return notlp;
    }

    public void setNotlp(String notlp) {
        this.notlp = notlp;
    }
}
