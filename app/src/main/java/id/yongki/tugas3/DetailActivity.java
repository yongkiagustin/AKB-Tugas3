package id.yongki.tugas3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    RecyclerAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();
    public static AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }
    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswas = db.UserDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listMahasiswas.size();i++){
            Log.e("Aplikasi",listMahasiswas.get(i).getNotlp()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getJurusan()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNim()+i);
        }
    }
    private void initRecyclerView() {
        RecyclerView myRecyclerview = (RecyclerView)findViewById(R.id.myRecyclerview);
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter =new RecyclerAdapter(this, listMahasiswas);
    }
    private void setAdapter() {
        RecyclerView myRecyclerview = (RecyclerView)findViewById(R.id.myRecyclerview);
        myRecyclerview.setAdapter(recycleAdapter);
    }
}
