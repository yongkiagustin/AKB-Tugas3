package id.yongki.tugas3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

import static id.yongki.tugas3.MyApp.db;

//29 April 2020 08.10 Layouting detail_activity dan Main_activity
//29 April 2020 10.35 membuat database room dan fungsinya
//29 April 2020 15.35 membuat dan layouting recyclerview_layout
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.etNim)
    EditText etNim;
    @BindView(R.id.etJurusan)
    EditText etJurusan;
    @BindView(R.id.etTelp)
    EditText etTelp;
    Mahasiswa mahasiswa;
    @BindView(R.id.btInsert)
    Button btInsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonListener();
            }
        });

    }


    void buttonListener(){
        if (!etTelp.getText().toString().isEmpty()&&!etJurusan.getText().toString().isEmpty()
                &&!etNama.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()){
            mahasiswa = new Mahasiswa();
            mahasiswa.setNim(etNim.getText().toString());
            mahasiswa.setNama(etNama.getText().toString());
            mahasiswa.setJurusan(etJurusan.getText().toString());
            mahasiswa.setNotlp(etTelp.getText().toString());

            //Insert data to database
            db.UserDao().insertAll(mahasiswa);
            startActivity(new Intent(MainActivity.this, DetailActivity.class));

        }else{
            Toast.makeText(this,"Mohon Masukkan Data Dengan Benar!",Toast.LENGTH_SHORT).show();

        }
    }
}
