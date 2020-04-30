package id.yongki.tugas3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        db.userDao().insertAll(mahasiswa);
        db.userDao().getAll();
        db.userDao().findByName("");
        db.userDao().deleteUsers(mahasiswa);
    }
}
