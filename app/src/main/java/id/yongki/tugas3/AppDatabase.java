package id.yongki.tugas3;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao UserDao();
}
